package com.cinema.CinemaProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.CinemaProject.model.Screening;
import com.cinema.CinemaProject.repository.ScreeningRepository;

@Service
public class ScreeningService {
	
	private ScreeningRepository screeningRepository;
	
	@Autowired
	public ScreeningService(ScreeningRepository hallRepositor) {
		super();
		this.screeningRepository = hallRepositor;
	}

	public Optional<Screening> findById(Long id) {
		return screeningRepository.findById(id);
	}
	
	public List<Screening> findAll() {
		return screeningRepository.findAll();
	}
	
	public Screening save(Screening screening) {
		return screeningRepository.save(screening);
	}
	
	public void deleteById(Long id) {
		screeningRepository.deleteById(id);
	}
}
