package com.cinema.CinemaProject.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.CinemaProject.model.OrderedSeat;
import com.cinema.CinemaProject.service.OrderedSeatService;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.imageio.ImageIO;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmailController {
	private OrderedSeatService orderedSeatService;
	private ImageController imageController;
		
	@Autowired
	public EmailController(OrderedSeatService hallRepositor, ImageController imageController) {
		super();
		this.orderedSeatService = hallRepositor;
		this.imageController = imageController;
	}
	
	@GetMapping("/sendemail/{orderId}")
	public String sendEmail( @PathVariable Long orderId) throws AddressException, MessagingException, IOException, URISyntaxException, DocumentException{
		List<OrderedSeat> data= orderedSeatService.findByOrder(orderId);
	   
		Document document = new Document();
		
		String fileName = "Bilet-"+data.get(0).getOrder().getUser().getSurname()+data.get(0).getOrder().getId()+".pdf";
		PdfWriter.getInstance(document, new FileOutputStream(fileName) );

		document.open();
		
		for(OrderedSeat x : data ) {

			addTicket(document, x);
		}

		document.close();
	   
		sendmail(data.get(0).getOrder().getUser().getEmail(), fileName, data.get(0));
		
		File myObj = new File("C:\\Users\\abc\\eclipse-workspace\\CinemaProject\\"+fileName); 
		myObj.delete();
		
		return "Email sent successfully";
	}
	
	private void addTicket(Document document, OrderedSeat ticket) throws DocumentException, IOException {
		BaseFont polishFont = BaseFont.createFont(FontFactory.HELVETICA, "Cp1257",
				BaseFont.NOT_EMBEDDED);
		Font normalFont = new Font(polishFont, 12, Font.NORMAL);
		
		com.cinema.CinemaProject.model.Image image = imageController.getImageByMovie(ticket.getScreening().getMovie().getId());
		System.out.println(image.getPicByte());
		Image poster = Image.getInstance(image.getPicByte());
		poster.scaleToFit(110, 160);
		
		BarcodeQRCode code = new BarcodeQRCode(ticket.getIdHash(), 90, 90, null);
		Image qrImage = code.getImage();
	   
		PdfPTable table = new PdfPTable(3);
		table.setWidths(new int[]{140,210,140});
		PdfPCell defaultcell = table.getDefaultCell();
		defaultcell.setFixedHeight(27f);
		defaultcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		
		addTableHeader(table);
		
		PdfPCell cellPoster = new PdfPCell(poster);
		cellPoster.setRowspan(6);
		cellPoster.setPaddingTop(5);
		cellPoster.setPaddingBottom(5);
		cellPoster.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellPoster.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cellPoster);
		
		table.addCell(new Phrase("Tytuł: "+ ticket.getScreening().getMovie().getTitle(), normalFont));
		
		PdfPCell cellQR = new PdfPCell(qrImage);
		cellQR.setRowspan(6);
		cellQR.setPaddingTop(5);
		cellQR.setPaddingBottom(5);
		cellQR.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellQR.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cellQR);
		
		table.addCell("Data: "+ ticket.getScreening().getDate());
		table.addCell("Nazwa sali kinowej: "+ ticket.getSeat().getHall().getHallName());
		table.addCell(new Phrase("Numer rzędu: "+ ticket.getSeat().getRow(), normalFont));
		table.addCell("Numer miejsca: "+ ticket.getSeat().getSeatNumber());
		table.addCell("Cena za bilety: "+ (ticket.getScreening().getMovie().getTicketPrice()));
		
		table.setSpacingAfter(60);
		document.add(table);
	}
	
	public static BufferedImage decodeToImage(byte[] imageByte) {
		 
        BufferedImage image = null;

        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return image;
    }
	
	private void addTableHeader(PdfPTable table) {
		Stream.of("Plakat", "Bilet na film", "Kod QR")
		.forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header.setFixedHeight(27f);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});
	}

	private void sendmail(String email, String fileName, OrderedSeat data) throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "poczta.stud.uz.zgora.pl");
		props.put("mail.smtp.port", "587");
	   
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("98855@stud.uz.zgora.pl", "45.Wojna");
			}
		});
		
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("noreply@kino.com", false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject("Potwierdzenie zakupu biletu");
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		String mesg = "Dziękujemy za zakup biletu.<br><br>"
				+ "Seans na jaki kupiłeś bilet:<br>"
				+ "Tytuł filmu: "+data.getScreening().getMovie().getTitle()+"<br>"
				+ "Data seansu: "+data.getScreening().getDate()+"<br><br>"
				+ "W celu weryfikacji zakupionego biletu prosimy zabrać ze sobą wydrukowany bilet, będź okazać go w postaci pliku PDF na telefonie.";
		messageBodyPart.setContent(mesg, "text/html; charset=UTF-8" );

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
	   
		MimeBodyPart attachPart = new MimeBodyPart();

		attachPart.attachFile("C:\\Users\\abc\\eclipse-workspace\\CinemaProject\\"+fileName);
		multipart.addBodyPart(attachPart);
	   
		msg.setContent(multipart);
		Transport.send(msg);   
	}
}