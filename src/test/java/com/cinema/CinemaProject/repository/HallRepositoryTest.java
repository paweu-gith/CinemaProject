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

import com.cinema.CinemaProject.model.Hall;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@ComponentScan("com.cinema")
@SpringBootTest(classes= {HallRepository.class, Hall.class})
public class HallRepositoryTest {
	@Autowired
	private HallRepository hallRepository;
	private Hall hall;
	
	@BeforeEach
	public void setUp() {
		hall = new Hall(Long.valueOf(3), "Sala 1");
	}
	
	@AfterEach
	public void tearDown() {
		//hallRepository.deleteAll();
		hall = null;
	}
	
	@Test
	void shouldReturnAddedMovie() {
		hallRepository.save(hall);
		Hall fetchedMovie = hallRepository.findById(hall.getId()).get();
		
		assertEquals(1, fetchedMovie.getId());
	}
	
	@Test
	public void shouldReturnListOfAllAddedProducts(){
		Hall hall2 = new Hall(Long.valueOf(4), "Sala 2");
		hallRepository.save(hall);
		hallRepository.save(hall2);
	    List<Hall> hallList = hallRepository.findAll();
	    
	    assertEquals("Sala 2", hallList.get(1).getHallName());
	}

}*/