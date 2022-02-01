package com.cinema.CinemaProject.model;


import javax.persistence.*;


@Entity
@Table(name = "images")
public class Image {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;
	
    @OneToOne(mappedBy = "image")
    private Movie movie;
    
	@Column(name = "picByte", length = 1000)
	private byte[] picByte;
	
	public Image() {
		super();
	}

	public Image (String name, byte[] picByte) {
		this.name = name;
		this.picByte = picByte;
	}
	public Image (String name, Movie movie, byte[] picByte) {
		this.name = name;
		this.picByte = picByte;
		this.movie = movie;
	}
    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column

	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPicByte() {
		return picByte;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
}
