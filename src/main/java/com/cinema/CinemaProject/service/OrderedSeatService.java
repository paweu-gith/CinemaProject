package com.cinema.CinemaProject.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.CinemaProject.model.OrderedSeat;
import com.cinema.CinemaProject.repository.OrderedSeatRepository;

@Service
public class OrderedSeatService {
	
	private OrderedSeatRepository orderedSeatRepository;
	@Autowired
	public OrderedSeatService(OrderedSeatRepository orderedSeatRepositor) {
		super();
		this.orderedSeatRepository = orderedSeatRepositor;
	}

	public Optional<OrderedSeat> findById(Long id) {
		return orderedSeatRepository.findById(id);
	}
	public Optional<OrderedSeat> findByIdHash(String id) {
		return orderedSeatRepository.findByIdHash(id);
	}
	
	
	public List<OrderedSeat> findAll() {
		return orderedSeatRepository.findAll();
	}
	
	public OrderedSeat save(OrderedSeat seat) {
		OrderedSeat temp = orderedSeatRepository.save(seat);
		temp.setIdHash(DigestUtils.sha256Hex(seat.getId().toString()));

		return orderedSeatRepository.save(temp);
	}
	
	public void deleteById(Long id) {
		orderedSeatRepository.deleteById(id);
	}
	
	public void deleteByOrderId(Long id) {
		orderedSeatRepository.deleteByOrder_id(id);
	}
	
	public List<OrderedSeat> findByScreeaning(Long id){
		return orderedSeatRepository.findByScreening_id(id);
	}
	
	public List<OrderedSeat> findByOrder(Long id){
		return orderedSeatRepository.findByOrder_id(id);
	}
	
	public List<OrderedSeat> findByOrderUser(Long id){
		return orderedSeatRepository.findByOrder_User_id(id);
	}
}
