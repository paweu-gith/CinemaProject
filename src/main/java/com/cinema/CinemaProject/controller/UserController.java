package com.cinema.CinemaProject.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.CinemaProject.model.User;
import com.cinema.CinemaProject.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public List<User> getUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUser(@PathVariable Long id){
		/*
		Optional<User> us= userService.findById(id);
		User user = us.get();
		Order order = user.getOrder().get(0);
		System.out.print(order);
		*/
		return userService.findById(id);
	}
	
	@PostMapping
	public User saveUser(final @RequestBody User user) {
		return userService.save(user);
	}
	

	@PostMapping("/login")
	public User findByEmailAndPassword(final @RequestBody Map<String, String> json) {
		return userService.findByEmailAndPassword(json.get("email"), json.get("password"));
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteById(id);
	}
}
