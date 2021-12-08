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

import com.cinema.CinemaProject.model.Screening;
import com.cinema.CinemaProject.service.ScreeningService;

@RestController
@RequestMapping("/api/screenings")
@CrossOrigin
public class ScreeningController {
	private ScreeningService screeningService;
	
	@Autowired
	public ScreeningController(ScreeningService screeningService) {
		super();
		this.screeningService = screeningService;
	}

	@GetMapping
	public List<Screening> getUsers(){
		return screeningService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Screening> getUser(@PathVariable Long id){
		return screeningService.findById(id);
	}
	
	@PostMapping
	public Screening saveOrder(final @RequestBody Screening screening) {
		return screeningService.save(screening);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		screeningService.deleteById(id);
	}
}
