package com.cinema.CinemaProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.CinemaProject.model.Seat;
import com.cinema.CinemaProject.service.SeatService;

@RestController
@CrossOrigin
@RequestMapping("/api/seats")
public class SeatController {
	private SeatService seatService;
	
	@Autowired
	public SeatController(SeatService seatService) {
		super();
		this.seatService = seatService;
	}

	@GetMapping
	public List<Seat> getUsers(){
		return seatService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Seat> getUser(@PathVariable Long id){
		return seatService.findById(id);
	}
	
	@GetMapping("/hall/{id}")
	public List<Seat> findByHall(@PathVariable Long id){
		return seatService.findByHall(id);
	}

	@GetMapping("/ordered_seats/{id}")
	public List<Seat> findByOrderedSeats(@PathVariable Long id){
		return seatService.findByOrderedSeats(id);
	}
	
	@PostMapping
	public Seat saveOrder(final @RequestBody Seat screening) {
		return seatService.save(screening);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		seatService.deleteById(id);
	}
}
