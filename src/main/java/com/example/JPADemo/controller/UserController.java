package com.example.JPADemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPADemo.service.UserService;
import com.example.JPADemo.model.User;
// Indicate that this is a RestController

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired // The creation, injection and destroy manage by Spring
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
	}
	
	// localhost:8080/api/users/paged?page=1&size=5
	@GetMapping("/paged")
	public Page<User> getUsersPaged(@RequestParam int page,
			@RequestParam int size){
		return userService.getUsersPage(PageRequest.of(page-1, size));
	}

	
	@GetMapping("/{name}")
	public List<User> getUserByName(@PathVariable String name){
		return userService.findUsersByName(name);
	}

}
