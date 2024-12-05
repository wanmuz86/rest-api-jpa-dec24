package com.example.JPADemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPADemo.dto.PostDTO;
import com.example.JPADemo.model.Post;
import com.example.JPADemo.model.User;
import com.example.JPADemo.repository.PostRepository;
import com.example.JPADemo.repository.UserRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Post> getAllPosts(){
		// Auto generated
		return postRepository.findAll();
	}
	
	// For security reason
	// And to customize our Post Entity Json
	// We will use DTO instead of entity
	public Post createPost(PostDTO post) {
		// Auto generated
		
		// From the DTO we will transform to Post Entity
	
		// Retrieve the user from the passed Id
		User currentUser = userRepository.findById(post.getUserId()).orElseThrow(
				()-> new RuntimeException("User not found"));
		
		
		// Create the post
		Post newPost = new Post();
		newPost.setTitle(post.getTitle());
		newPost.setContent(post.getContent());
		newPost.setUser(currentUser);
		
		return postRepository.save(newPost);
	}
	
	public List<Post> getPostsByUserId(Long userId){
		// Custom query with JPA Repository
		return postRepository.findByUserId(userId);
	}
	public void deletePost(Long id) {
		// Auto generated
		postRepository.deleteById(id);
	}

}
