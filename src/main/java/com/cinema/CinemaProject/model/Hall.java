package com.cinema.CinemaProject.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "halls")
public class Hall {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String hallName;

    @OneToMany(mappedBy="hall", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnore
    private Set<Screening> screening;
    
    @OneToMany(mappedBy="hall", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnore
    private Set<Seat> seat;
    

	public Hall(Long id, String hallName, Set<Screening> screening, Set<Seat> seat) {
		super();
		this.id = id;
		this.hallName = hallName;
		this.screening = screening;
		this.seat = seat;
	}
	public Hall() {

	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public Set<Screening> getScreening() {
		return screening;
	}
	public void setScreening(Set<Screening> screening) {
		this.screening = screening;
	}
	public Set<Seat> getSeat() {
		return seat;
	}
	public void setSeat(Set<Seat> seat) {
		this.seat = seat;
	}
	
	
}
