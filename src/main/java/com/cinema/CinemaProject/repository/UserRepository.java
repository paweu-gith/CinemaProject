package com.cinema.CinemaProject.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.CinemaProject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	User findByEmailAndPassword(String email, String password);
	
	Optional<User> findByEmail(String email);

	Boolean existsByEmail(String email);
}