package com.cinema.CinemaProject.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Double ticketPrice;
	
    @OneToMany(mappedBy="movie", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnore
    private Set<Screening> screening;
    
    @OneToOne(mappedBy = "movie")
    private Image image;
    
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
	

}
