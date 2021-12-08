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

import com.cinema.CinemaProject.model.Hall;
import com.cinema.CinemaProject.service.HallService;

@RestController
@CrossOrigin
@RequestMapping("/api/halls")
public class HallController {
	private HallService hallService;
	
	@Autowired
	public HallController(HallService hallService) {
		super();
		this.hallService = hallService;
	}

	@GetMapping
	public List<Hall> getUsers(){
		return hallService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Hall> getUser(@PathVariable Long id){
		return hallService.findById(id);
	}
	
	@PostMapping
	public Hall saveOrder(final @RequestBody Hall hall) {
		return hallService.save(hall);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		hallService.deleteById(id);
	}
}
