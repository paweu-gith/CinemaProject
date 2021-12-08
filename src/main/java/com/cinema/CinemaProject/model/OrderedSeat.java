package com.cinema.CinemaProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.codec.digest.DigestUtils;

@Entity
@Table(name = "ordered_seats")
public class OrderedSeat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "screening_id", nullable = false)
    private Screening screening;
    
    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    
    @Column(columnDefinition= "char(64)")
    private String idHash;
    
	public OrderedSeat(Long id,Screening screening, Seat seat, Order order) {
		super();
		this.screening = screening;
		this.seat = seat;
		this.order = order;
		this.idHash = DigestUtils.sha256Hex(id.toString());

	}
	
	public OrderedSeat(Long id, Screening screening, Seat seat, Order order, String idHash) {
		super();
		this.id = id;
		this.screening = screening;
		this.seat = seat;
		this.order = order;
		this.idHash = idHash;
	}
	
	public OrderedSeat() {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Screening getScreening() {
		return screening;
	}

	public void setScreening(Screening screening) {
		this.screening = screening;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getIdHash() {
		return idHash;
	}

	public void setIdHash(String idHash) {
		this.idHash = idHash;
	}

	@Override
	public String toString() {
		return "OrderedSeat [id=" + id + ", idHash=" + idHash + "]";
	}
    
    
}
