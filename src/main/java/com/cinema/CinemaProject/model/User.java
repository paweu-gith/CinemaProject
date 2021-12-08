package com.cinema.CinemaProject.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users",
	uniqueConstraints = { 
		@UniqueConstraint(columnNames = "email") 
	})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String surname;
	
	@NotBlank
	private String email;
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnore
    private List<Order> order = new ArrayList<>();
	
	public User(String name, String surname, String email, String password, Set<Role> roles,
			List<Order> order) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.order = order;
	}
	public User(String name, String surname, String email, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}
	public User() {

	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password="
				+ password ;
	}
	
	
}
