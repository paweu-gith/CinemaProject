package com.cinema.CinemaProject.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.CinemaProject.model.OrderedSeat;
import com.cinema.CinemaProject.service.OrderedSeatService;

@RestController
@CrossOrigin
@RequestMapping("/api/ordered_seats")
public class OrderedSeatController {
	private OrderedSeatService seatService;
	
	@Autowired
	public OrderedSeatController(OrderedSeatService orderedSeatService) {
		super();
		this.seatService = orderedSeatService;
	}

	@GetMapping
	public List<OrderedSeat> getUsers(){
		return seatService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<OrderedSeat> getUser(@PathVariable Long id){
		return seatService.findById(id);
	}
	
	@PostMapping
	public OrderedSeat saveOrder(final @RequestBody OrderedSeat orderedSeat) {
		return seatService.save(orderedSeat);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		seatService.deleteById(id);
	}
	
	@Transactional
	@DeleteMapping("/order/{id}")
	public void deleteByOrderId(@PathVariable Long id) {
		seatService.deleteByOrderId(id);
	}
	
	@GetMapping("/screening/{id}")
	public List<OrderedSeat> findByHall(@PathVariable Long id){
		return seatService.findByScreeaning(id);
	}
	
	@GetMapping("/order/user/{id}")
	public List<OrderedSeat> findByOrderUser(@PathVariable Long id){
		return seatService.findByOrderUser(id);
	}
	
	@GetMapping("/order/{id}")
	public List<OrderedSeat> findByOrder(@PathVariable Long id){
		return seatService.findByOrder(id);
	}
}
