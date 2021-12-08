package com.cinema.CinemaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.CinemaProject.model.Screening;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening,Long> {
}
