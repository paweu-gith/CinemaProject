package com.cinema.CinemaProject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "seats")
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int seatNumber;
	
	private int row;
	
	private int col;
    
    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;
    
    @OneToMany(mappedBy="seat", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnore
    private List<OrderedSeat> orderedSeat = new ArrayList<>();
    
	public Seat(Long id, int seatNumber, int row, int column, Hall hall) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		this.row = row;
		this.col = column;
		this.hall = hall;
	}
	public Seat() {

	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return col;
	}

	public void setColumn(int column) {
		this.col = column;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}
	@Override
	public String toString() {
		return "Seat [id=" + id + ", seatNumber=" + seatNumber + ", row=" + row + ", col=" + col ;
	}

}