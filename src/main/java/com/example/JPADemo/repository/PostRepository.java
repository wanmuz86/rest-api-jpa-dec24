package com.example.JPADemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPADemo.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByUserId(Long userId);

}
