package com.example.JPADemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPADemo.dto.PostDTO;
import com.example.JPADemo.model.Post;
import com.example.JPADemo.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public List<Post> getAllPosts(){
		return postService.getAllPosts();
	}

	@PostMapping
	public Post createPost(@RequestBody PostDTO post) {
		return postService.createPost(post);
	}
	
	@GetMapping("/user/{userId}")
	public List<Post> getPostsByUserId(@PathVariable Long userId){
		return postService.getPostsByUserId(userId);
	}
	
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable Long id) {
		 postService.deletePost(id);
	}
}
