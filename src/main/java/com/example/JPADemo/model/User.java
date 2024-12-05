package com.example.JPADemo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// More settings can refer : https://www.baeldung.com/jpa-entities
// https://spring.io/guides/gs/accessing-data-jpa

// @Entity = To indicate that this will be a table in db
@Entity
// @Table - To indicate / overwrite default table name "user"
// ONLY FOR H2 = the user access to the DB table is called Users
// If we dont overwrite there will be conflict with the DB USER table 
@Table(name="\"user\"")
public class User {
	
	// @Id = to devide the table ID
	@Id
	// Primary + Auto Increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// @Column - To set constraint on the table 
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	private int age;
	
	
	// 1 user has many review
	// Fetch TYpe = LAZY it will be loaded on demand , EAGER = loaded together with the Parent
	// CASCADETYPE -> When parent is deleted, what happen to the child (Detach,Remove)
	
	@OneToMany(mappedBy= "user", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Review> reviews;
	
	
	// 1 user has many post
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

	private List<Post> posts;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	

}
