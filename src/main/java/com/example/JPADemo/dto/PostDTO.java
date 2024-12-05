package com.example.JPADemo.dto;

public class PostDTO {

	// https://chatgpt.com/share/67516737-a14c-8001-8258-e99ac93e38f3
	private String title;
	private String content;
	
	private Long userId;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
