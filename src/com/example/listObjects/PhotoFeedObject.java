package com.example.listObjects;

import android.net.Uri;

public class PhotoFeedObject {
	private String username;
	private String title;
	private double rating;
	private Uri avatar;
	public PhotoFeedObject(String username, String title, double rating, Uri avatar) {
		super();
		this.username = username;
		this.title = title;
		this.rating = rating;
		this.avatar = avatar;
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
	public void setAvatar(Uri location){
		this.avatar = location;
	}
	public Uri getAvatar(){
		return avatar;
	}
	
}
