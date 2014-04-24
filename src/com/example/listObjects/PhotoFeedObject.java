package com.example.listObjects;

public class PhotoFeedObject {
	private String username;
	private String title;
	private double rating;
	//TODO: implement picture
	public PhotoFeedObject(String username, String title, double rating) {
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
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getUsername() {
		return username;
	}
	public String getTitle() {
		return title;
	}
	public double getRating() {
		return rating;
	}
	
	
}
