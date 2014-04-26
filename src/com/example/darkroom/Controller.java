package com.example.darkroom;

import java.io.File;

public class Controller {

	private static String userName;
	private static String userAvatarPath;
	private static String equipmentText;
	private static String styleText;
	private static String websiteText;
	private static String workText;
	private static String aboutText;
	
	private Boolean forHire; //need to translate 1s and 0s to boolean
	private Boolean reviewsAllowed;
	private Boolean guestBookAllowed;
	private Boolean commentsAllowed;
	
	
	private static String photoTitle;
	private static String rating;
	private static String photoPath;
	
	
	public static String getUserName() {
		String data;
		if (userName == null) {
			data = DatabaseQueryer.getData("userName");
			//parse
			//set userName
			return userName;
		}
		return userName;
	}
	public static void setUserName(String userName) {
		Controller.userName = userName;
	}
	
	public static String getUserAvatarPath() {
		String data;
		if (userAvatarPath == null) {
			data = DatabaseQueryer.getData("userAvatarPath");
			//parse
			//set userAvatarPath
			return userAvatarPath;
		}
		return userAvatarPath;
	}
	public static void setUserAvatar(String userAvatarPath) {
		Controller.userAvatarPath = userAvatarPath;
	}
	
	public static String getEquipmentText() {
		String data;
		if (equipmentText == null) {
			data = DatabaseQueryer.getData("equipmentText");
			//parse
			//set equipmentText
			return equipmentText;
		}
		return equipmentText;
	}
	public static void setEquipmentText(String equipmentText) {
		Controller.equipmentText = equipmentText;
	}
	
	public static String getStyleText() {
		String data;
		if (styleText == null) {
			data = DatabaseQueryer.getData("styleText");
			//parse
			//set styleText
			return styleText;
		}
		return styleText;
	}
	public static void setStyleText(String styleText) {
		Controller.styleText = styleText;
	}
	
	public static String getWebsiteText() {
		String data;
		if (websiteText == null) {
			data = DatabaseQueryer.getData("websiteText");
			//parse
			//set styleText
			return websiteText;
		}
		return websiteText;
	}
	public static void setWebsiteText(String websiteText) {
		Controller.websiteText = websiteText;
	}
	
	public static String getWorkText() {
		String data;
		if (workText == null) {
			data = DatabaseQueryer.getData("workText");
			//parse
			//set workText
			return workText;
		}
		return workText;
	}
	public static void setWorkText(String workText) {
		Controller.workText = workText;
	}
	
	public static String getAboutText() {
		String data;
		if (aboutText == null) {
			data = DatabaseQueryer.getData("aboutText");
			//parse
			//set aboutText
			return aboutText;
		}
		return aboutText;
	}
	public static void setAboutText(String aboutText) {
		Controller.aboutText = aboutText;
	}
	
	public Boolean getForHire() {
		String data;
		if (forHire == null) {
			data = DatabaseQueryer.getData("forHire");
			//parse
			//set forHire
			return forHire;
		}
		return forHire;
	}
	public void setForHire(Boolean forHire) {
		this.forHire = forHire;
	}
	
	public Boolean getReviewsAllowed() {
		String data;
		if (reviewsAllowed == null) {
			data = DatabaseQueryer.getData("reviewsAllowed");
			//parse
			//set reviewsAllowed
			return reviewsAllowed;
		}
		return reviewsAllowed;
	}
	public void setReviewsAllowed(Boolean reviewsAllowed) {
		this.reviewsAllowed = reviewsAllowed;
	}
	
	public Boolean getGuestBookAllowed() {
		String data;
		if (guestBookAllowed == null) {
			data = DatabaseQueryer.getData("guestBookAllowed");
			//parse
			//set guestBookAllowed
			return guestBookAllowed;
		}
		return guestBookAllowed;
	}
	public void setGuestBookAllowed(Boolean guestBookAllowed) {
		this.guestBookAllowed = guestBookAllowed;
	}
	
	public Boolean getCommentsAllowed() {
		String data;
		if (commentsAllowed == null) {
			data = DatabaseQueryer.getData("commentsAllowed");
			//parse
			//set forHire
			return commentsAllowed;
		}
		return commentsAllowed;
	}
	public void setCommentsAllowed(Boolean commentsAllowed) {
		this.commentsAllowed = commentsAllowed;
	}
	
	public static String getPhotoTitle() {
		String data;
		if (photoTitle == null) {
			data = DatabaseQueryer.getData("photoTitle");
			//parse
			//set forHire
			return photoTitle;
		}
		return photoTitle;
	}
	public static void setPhotoTitle(String photoTitle) {
		
		Controller.photoTitle = photoTitle;
	}
	
	public static String getRating() {
		String data;
		if (rating == null) {
			data = DatabaseQueryer.getData("rating");
			//parse
			//set rating
			return rating;
		}
		return rating;
	}
	public static void setRating(String rating) {
		Controller.rating = rating;
	}
	
	public static String getPhotoPath() {
		String data;
		if (photoPath == null) {
			data = DatabaseQueryer.getData("photoPath");
			//parse
			//set PhotoPath
			return photoPath;
		}
		return photoPath;
	}
	public static void setPhoto(File photo) {
		Controller.photoPath = photoPath;
	}
	
	


	

	




}
