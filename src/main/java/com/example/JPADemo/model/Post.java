package com.example.JPADemo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


// Table name = posts

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI, Primary
	private Long id;
	
	@Column(nullable =false)
	private String title;
	
	@Column(nullable=false)
	private String content;
	
	
	// 1 post has many to reviews
	@OneToMany(mappedBy="post", cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	private List<Review> reviews;
	
	
	// 1u post manytone user (reverse relation of one to many)
	@ManyToOne(fetch=FetchType.LAZY) // FetchType.LAZY DAta is retrieved on demand
									// FetchType.EAGER // Data is retrieved together with the parent object
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	

}
