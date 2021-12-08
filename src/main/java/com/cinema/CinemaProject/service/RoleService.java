package com.cinema.CinemaProject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.CinemaProject.model.ERole;
import com.cinema.CinemaProject.model.Role;
import com.cinema.CinemaProject.repository.RoleRepository;

@Service
public class RoleService {
	private RoleRepository roleRepository;
	
	@Autowired
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public Optional<Role> findByName(ERole name){
		return roleRepository.findByName(name);
	}
}
