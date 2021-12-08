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

import com.cinema.CinemaProject.model.Movie;
import com.cinema.CinemaProject.service.MovieService;

@RestController
@CrossOrigin
@RequestMapping("/api/movies")
public class MovieController {
	private MovieService movieService;
	
	@Autowired
	public MovieController(MovieService ordersController) {
		super();
		this.movieService = ordersController;
	}

	@GetMapping
	public List<Movie> getUsers(){
		return movieService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Movie> getUser(@PathVariable Long id){
		return movieService.findById(id);
	}
	
	@PostMapping
	public Movie saveOrder(final @RequestBody Movie movie) {
		return movieService.save(movie);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		movieService.deleteById(id);
	}
}
