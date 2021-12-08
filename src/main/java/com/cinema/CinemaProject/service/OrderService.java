package com.cinema.CinemaProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.CinemaProject.model.Order;
import com.cinema.CinemaProject.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}
	
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	
	public List<Order> findByUser(Long id) {
		return orderRepository.findByUser_Id(id);
	}
	
	public Order save(Order orders) {
		return orderRepository.save(orders);
	}
	
	public void deleteById(Long id) {
		orderRepository.deleteById(id);
	}

}
