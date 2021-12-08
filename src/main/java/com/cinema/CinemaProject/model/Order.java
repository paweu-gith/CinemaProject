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
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", shape= Shape.STRING)
	@Column(name = "date")
	private String date;
	
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @OneToMany(mappedBy="order", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnore
    private List<OrderedSeat> orderedSeat = new ArrayList<>();
    
	public Order(Long id, String date, User user) {
		super();
		this.id = id;
		this.date = date;
		this.user = user;
	}
	public Order() {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", date=" + date + ", user=" + user + "]";
	}

}
