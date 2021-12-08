package com.cinema.CinemaProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.CinemaProject.model.Movie;
import com.cinema.CinemaProject.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public Optional<Movie> findById(Long id) {
		return movieRepository.findById(id);
	}
	
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public void deleteById(Long id) {
		movieRepository.deleteById(id);
	}

}