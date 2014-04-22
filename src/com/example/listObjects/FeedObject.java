package com.example.listObjects;

public class FeedObject {
	private String username;
	private String title;
	private String rating;
	//TODO: implement picture
	public FeedObject(String username, String title, String rating) {
		super();
		this.username = username;
		this.title = title;
		this.rating = rating;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getUsername() {
		return username;
	}
	public String getTitle() {
		return title;
	}
	public String getRating() {
		return rating;
	}
	
	
}
