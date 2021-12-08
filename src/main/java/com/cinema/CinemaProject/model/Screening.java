package com.cinema.CinemaProject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@Entity
@Table(name = "screenings")
public class Screening {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", shape= Shape.STRING)
	@Column(name = "date", columnDefinition="datetime")
	private String date;
	
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    
    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;
    
    @OneToMany(mappedBy="screening", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnore
    private List<OrderedSeat> orderedSeat = new ArrayList<>();

	public Screening(Long id, String date, Movie movie, Hall hall) {
		super();
		this.id = id;
		this.date = date;
		this.movie = movie;
		this.hall = hall;
	}
	public Screening() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}
	@Override
	public String toString() {
		return "Screening [id=" + id + ", date=" + date + "]";
	}


}
