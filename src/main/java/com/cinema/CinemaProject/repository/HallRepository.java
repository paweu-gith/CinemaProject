package com.cinema.CinemaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.CinemaProject.model.Hall;

@Repository
public interface HallRepository extends JpaRepository<Hall,Long> {
}