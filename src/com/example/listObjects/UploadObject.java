package com.example.listObjects;
import android.net.Uri;

public class UploadObject {
	private double rating;
	private String username;
	private String title;
	private Uri image;
	private boolean following;
	public double getRating() {
		return rating;
	}
	public String getUsername() {
		return username;
	}
	public String getTitle() {
		return title;
	}
	public Uri getImage() {
		return image;
	}
	public boolean isFollowing() {
		return following;
	}
	public UploadObject(double rating, String username, String title,
			Uri image, boolean following) {
		super();
		this.rating = rating;
		this.username = username;
		this.title = title;
		this.image = image;
		this.following = following;
	}
	
}
