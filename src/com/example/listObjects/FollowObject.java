package com.example.listObjects;

import java.io.File;

public class FollowObject {
	private String username;
	private boolean following;
	private File avatar;
	public FollowObject(String username, boolean following, File avatar) {
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
	public File getAvatar() {
		return avatar;
	}
	
}
