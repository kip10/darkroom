package com.example.listObjects;

import android.net.Uri;

public class ReviewsObject {
	private String review;
	private String userName;
	private boolean following;
	private int rating1;
	private int rating2;
	private int rating3;
	private int rating4;
	private int rating5;

	private Uri image;
	private Uri avatar;
	
	public ReviewsObject(String review, String userName, boolean following,
			int rating1, int rating2, int rating3, int rating4, int rating5,
			Uri image, Uri avatar) {
		super();
		this.review = review;
		this.userName = userName;
		this.following = following;
		this.rating1 = rating1;
		this.rating2 = rating2;
		this.rating3 = rating3;
		this.rating4 = rating4;
		this.rating5 = rating5;
		this.image = image;
		this.avatar = avatar;
	}

	public String getReview() {
		return review;
	}
	public String getUserName() {
		return userName;
	}
	public boolean isFollowing() {
		return following;
	}
	public int getRating1() {
		return rating1;
	}
	public int getRating2() {
		return rating2;
	}
	public int getRating3() {
		return rating3;
	}
	public int getRating4() {
		return rating4;
	}
	public int getRating5() {
		return rating5;
	}
	public Uri getImage(){
		return image;
	}
	public Uri getAvatar(){
		return avatar;
	}
	public void setImage(Uri imageLocation){
		image = imageLocation;
	}
	public void setAvatar(Uri avatarLocation){
		avatar = avatarLocation;
	}
}
