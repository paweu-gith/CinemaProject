package com.cinema.CinemaProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.CinemaProject.model.Hall;
import com.cinema.CinemaProject.repository.HallRepository;

@Service
public class HallService {
	
	private HallRepository hallRepository;
	@Autowired
	public HallService(HallRepository hallRepositor) {
		super();
		this.hallRepository = hallRepositor;
	}

	public Optional<Hall> findById(Long id) {
		return hallRepository.findById(id);
	}
	
	public List<Hall> findAll() {
		return hallRepository.findAll();
	}
	
	public Hall save(Hall hall) {
		return hallRepository.save(hall);
	}
	
	public void deleteById(Long id) {
		hallRepository.deleteById(id);
	}
}
