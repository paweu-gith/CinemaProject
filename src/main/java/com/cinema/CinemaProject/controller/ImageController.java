package com.cinema.CinemaProject.controller;

//import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
/*
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
*/

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cinema.CinemaProject.model.Image;
import com.cinema.CinemaProject.model.Movie;
import com.cinema.CinemaProject.repository.ImageRepository;
import com.cinema.CinemaProject.repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@CrossOrigin
@RequestMapping(path = "/api/image")
public class ImageController {

	@Autowired
	ImageRepository imageRepository;
	@Autowired
	MovieRepository movieRepository;
	
	
	@PostMapping("/upload")
	public Image uplaodImage(@RequestParam MultipartFile file, String movieString) throws IOException {	

		ObjectMapper objectMapper = new ObjectMapper();
		Movie movie = objectMapper.readValue(movieString, Movie.class);

		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		Image img = new Image(file.getOriginalFilename(), movie,
				file.getBytes());
		

		imageRepository.save(img);

		Optional<Movie> movieFromDb = movieRepository.findById(movie.getId());
		
		movie = movieFromDb.get();
		movie.setImage(img);

		movieRepository.save(movie);

		return img;
	}

	@GetMapping(path = { "/get/{id}" })
	public Image getImage(@PathVariable Long id) throws IOException {

		final Optional<Image> retrievedImage = imageRepository.findById(id);
		Image img = new Image(retrievedImage.get().getName(), retrievedImage.get().getMovie(), retrievedImage.get().getPicByte());
		
		return img;
	}
	
	@GetMapping(path = { "/get/movie/{id}" })
	public Image getImageByMovie(@PathVariable Long id) throws IOException {

		final Optional<Image> retrievedImage = imageRepository.findByMovie_Id(id);
		Image img = new Image(retrievedImage.get().getName(), retrievedImage.get().getMovie(),
				retrievedImage.get().getPicByte());
		return img;
	}
	
	@GetMapping("/get")
	public List<Image> getImage() {
		List<Image> retrievedImage = imageRepository.findAll();
		int i = 0;
        for (Image x : retrievedImage) {
        	retrievedImage.get(i).setPicByte(x.getPicByte());
        	i++;
        }
		return imageRepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteImage(@PathVariable Long id) {
		imageRepository.deleteById(id);
	}
/*
	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
	*/
	
}