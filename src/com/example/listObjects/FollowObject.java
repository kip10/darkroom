package com.example.listObjects;


import android.net.Uri;

public class FollowObject {
	private String username;
	private boolean following;
	private Uri avatar;
	public FollowObject(String username, boolean following, Uri avatar) {
		super();
		this.username = username;
		this.following = following;
		this.avatar = avatar;
	}
	public String getUsername() {
		return username;
	}
	public boolean isFollowing() {
		return following;
	}
	public Uri getAvatar() {
		return avatar;
	}
	
}
