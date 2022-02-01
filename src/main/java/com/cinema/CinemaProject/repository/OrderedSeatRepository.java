package com.cinema.CinemaProject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.CinemaProject.model.OrderedSeat;


@Repository
public interface OrderedSeatRepository extends JpaRepository<OrderedSeat, Long> {
	List<OrderedSeat> findByScreening_id(Long id);
	
	List<OrderedSeat> findByOrder_id(Long id);
	
	List<OrderedSeat> findByOrder_User_id(Long id);
	
	Optional<OrderedSeat> findByIdHash(String idHash);
	
	void deleteByOrder_id(Long id);
	
}