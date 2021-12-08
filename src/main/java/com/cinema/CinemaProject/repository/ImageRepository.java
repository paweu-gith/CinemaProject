package com.cinema.CinemaProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.CinemaProject.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	Optional<Image> findByName(String name);
	
}
