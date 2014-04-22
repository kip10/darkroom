package com.example.listObjects;

import java.io.File;

public class UploadObject {
	private String rating;
	private String username;
	private String title;
	private File image;
	private boolean following;
	public String getRating() {
		return rating;
	}
	public String getUsername() {
		return username;
	}
	public String getTitle() {
		return title;
	}
	public File getImage() {
		return image;
	}
	public boolean isFollowing() {
		return following;
	}
	public UploadObject(String rating, String username, String title,
			File image, boolean following) {
		super();
		this.rating = rating;
		this.username = username;
		this.title = title;
		this.image = image;
		this.following = following;
	}
	
}
