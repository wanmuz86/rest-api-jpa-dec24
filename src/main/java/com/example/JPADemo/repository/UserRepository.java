package com.example.JPADemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPADemo.model.User;

// To benefit the BOILER code / AUTO GENERATE code from JPA (Java persistence API)
// We extends our Interface to JpaRepository
// By Specifying <(Entity), (Data type of Id)>
// By doing so, we have access to the basic operation of the database (auto generate)
// CRUD - Create , Read, Update , Delete

public interface UserRepository extends JpaRepository<User, Long>{

}
