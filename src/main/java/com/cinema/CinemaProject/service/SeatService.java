package com.cinema.CinemaProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.CinemaProject.model.Seat;
import com.cinema.CinemaProject.repository.SeatRepository;

@Service
public class SeatService {
	
	private SeatRepository seatRepository;
	@Autowired
	public SeatService(SeatRepository seatRepositor) {
		super();
		this.seatRepository = seatRepositor;
	}

	public Optional<Seat> findById(Long id) {
		return seatRepository.findById(id);
	}
	
	public List<Seat> findAll() {
		return seatRepository.findAll();
	}
	
	public Seat save(Seat seat) {
		return seatRepository.save(seat);
	}
	
	public void deleteById(Long id) {
		seatRepository.deleteById(id);
	}
	public List<Seat> findByHall(Long hallId){
		return seatRepository.findByHall_Id(hallId);
	}
	public List<Seat> findByOrderedSeats(Long screeningId){
		return seatRepository.findByOrderedSeat_Screening_Id(screeningId);
	}
}
