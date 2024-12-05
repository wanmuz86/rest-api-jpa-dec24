package com.example.JPADemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPADemo.model.User;

// To benefit the BOILER code / AUTO GENERATE code from JPA (Java persistence API)
// We extends our Interface to JpaRepository
// By Specifying <(Entity), (Data type of Id)>
// By doing so, we have access to the basic operation of the database (auto generate)
// CRUD - Create , Read, Update , Delete

public interface UserRepository extends JpaRepository<User, Long>{

	
	// JPA Query builder Methods
	// Reference: https://docs.spring.io/spring-data/jpa/reference/repositories/query-methods-details.html
	
	// SELECT * FROM user WHERE name LIKE '%Muzaffar%'
	List<User> findByNameContaining(String name);
	
	// SELECT * FROM user WHERE age > 18
	List<User> findByAgeGreaterThan(int age);
	
	
	// SELECT * FROM user WHERE name="Muzaffar" AND email="wanwan@gmail.com"
	List<User> findByNameAndEmail(String name, String email);
	
	
	//SELECT * FROM user WHERE age < 18
	List<User> findByAgeLessThan(int age);
	
	
	
}
