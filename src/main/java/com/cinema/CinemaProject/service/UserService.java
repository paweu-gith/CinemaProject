package com.cinema.CinemaProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.CinemaProject.model.User;
import com.cinema.CinemaProject.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	public Optional<User> findByEmail(String email){
		return userRepository.findByEmail(email);
	}
	public Boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}
