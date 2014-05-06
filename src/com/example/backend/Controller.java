package com.example.backend;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.example.darkroom.DatabaseQueryer;

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

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("displayname"); 
					}
					userName = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
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

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("userAvatarPath"); 
					}
					userAvatarPath = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
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
			
			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("equipment"); 
					}
					equipmentText = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
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
			
			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("style"); 
					}
					styleText = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
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

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("website"); 
					}
					websiteText = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
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

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("work_interests"); 
					}
					workText = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
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
			data = DatabaseQueryer.getData("about");

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("about"); 
					}
					aboutText = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
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

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("for_hire"); 
					}
					int fh = Integer.parseInt(s);
					if(fh == 1) {
						forHire = true;
					} else {
						forHire = false;
					}
						
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
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

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("reviews_allowed"); 
					}
					int fh = Integer.parseInt(s);
					if(fh == 1) {
						reviewsAllowed = true;
					} else {
						reviewsAllowed = false;
					}
						
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
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

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("guestbook_allowed"); 
					}
					int fh = Integer.parseInt(s);
					if(fh == 1) {
						guestBookAllowed = true;
					} else {
						guestBookAllowed = false;
					}
						
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
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

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("comments_allowed"); 
					}
					int fh = Integer.parseInt(s);
					if(fh == 1) {
						commentsAllowed = true;
					} else {
						commentsAllowed = false;
					}
						
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
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

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("filename"); 
					}
					photoTitle = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
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
