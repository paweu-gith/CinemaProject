package com.cinema.CinemaProject.repository;
/*
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.cinema.CinemaProject.model.Movie;
import com.cinema.CinemaProject.repository.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration
@ComponentScan("com.cinema")
@SpringBootTest(classes= {MovieRepository.class, Movie.class})
public class MovieRepositoryTest {
	@Autowired
	private MovieRepository movieRepository;
	private Movie movie;
	
	@BeforeEach
	public void setUp() {
		movie = new Movie(Long.valueOf(1), "Tytuł1", "test test", 10.00);
	}
	
	@AfterEach
	public void tearDown() {
		movieRepository.deleteAll();
		movie = null;
	}
	
	@Test
	void shouldReturnAddedMovie() {
		movieRepository.save(movie);
		Movie fetchedMovie = movieRepository.findById(movie.getId()).get();
		
		assertEquals(1, fetchedMovie.getId());
	}
	
	@Test
	public void shouldReturnListOfAllAddedProducts(){
		Movie movie2 = new Movie(Long.valueOf(2), "Tytuł2", "test test", 10.00);
		movieRepository.save(movie);
		movieRepository.save(movie2);
	    List<Movie> movieList = movieRepository.findAll();
	    
	    assertEquals("Tytuł2", movieList.get(1).getTitle());
	}

}*/
