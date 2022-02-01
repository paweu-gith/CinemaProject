package com.cinema.CinemaProject.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
    @Lob
    private String description;
    
	private Double ticketPrice;
	
    @OneToMany(mappedBy="movie", cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<Screening> screening;
    
    @JoinColumn(name="image_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Image image;
    
    
	public Movie(Long id, String title, String description, Double ticketPrice, Set<Screening> screening, Image image) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.ticketPrice = ticketPrice;
		this.screening = screening;
		this.image = image;
	}
	
	public Movie(Long id, String title, String description, Double ticketPrice) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.ticketPrice = ticketPrice;
	}
	
	public Movie() {

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Set<Screening> getScreening() {
		return screening;
	}

	public void setScreening(Set<Screening> screening) {
		this.screening = screening;
	}
	

}
