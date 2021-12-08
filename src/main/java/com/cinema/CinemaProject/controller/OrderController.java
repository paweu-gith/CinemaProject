package com.cinema.CinemaProject.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.CinemaProject.model.Order;
import com.cinema.CinemaProject.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/api/orders")
public class OrderController {
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService ordersController) {
		super();
		this.orderService = ordersController;
	}

	@GetMapping
	public List<Order> getUsers(){
		return orderService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Order> getUser(@PathVariable Long id){
		return orderService.findById(id);
	}
	
	@GetMapping("/user/{id}")
	public List<Order> getByUser(@PathVariable Long id){
		return orderService.findByUser(id);
	}
	
	@PostMapping
	public Order saveOrder(final @RequestBody Order orders) {
		return orderService.save(orders);
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		orderService.deleteById(id);
	}
	
	
}
