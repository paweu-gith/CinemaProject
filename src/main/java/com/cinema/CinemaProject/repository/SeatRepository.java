package com.cinema.CinemaProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.CinemaProject.model.Hall;
import com.cinema.CinemaProject.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {
	List<Seat> findByHall(Hall hall);
	
	List<Seat> findByHall_Id(Long hallId);
	
	List<Seat> findByOrderedSeat_Screening_Id(Long screeningId);
}
