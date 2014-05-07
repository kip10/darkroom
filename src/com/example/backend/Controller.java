package com.example.backend;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.example.darkroom.DatabaseQueryer;

public class Controller {

	private static String displayName;
	private static String avatarLocation;
	private static String equipment;
	private static String style;
	private static String website;
	private static String work_interests;
	private static String about;
	
	private Boolean for_hire; //need to translate 1s and 0s to boolean
	private Boolean reviews_allowed;
	private Boolean guestbook_allowed;
	private Boolean comments_allowed;
	
	
	private static String photoTitle;
	private static String rating;
	private static String photoPath;
	
	
	public static String getDisplayName() {
		String data;
		if (userName == null) {
			data = DatabaseQueryer.getData("getDisplayName");

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
			
			return displayName;
		}
		return displayName;
	}
	public static void setDisplayName(String displayName) {
		Controller.displayName = displayName;
	}
	
	public static String getAvatarLocation() {
		String data;
		if (avatarLocation == null) {
			data = DatabaseQueryer.getData("getAvatarLocation");

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("userAvatarPath"); 
					}
					avatarLocation = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
			return avatarLocation;
		}
		return avatarLocation;
	}
	public static void setAvatarLocation(String avatarLocation) {
		Controller.avatarLocation = avatarLocation;
	}
	
	public static String getEquipment() {
		String data;
		if (equipment == null) {
			data = DatabaseQueryer.getData("getEquipment");
			
			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("equipment"); 
					}
					equipment = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
			return equipment;
		}
		return equipment;
	}
	public static void setEquipment(String equipment) {
		Controller.equipment = equipment;
	}
	
	public static String getStyle() {
		String data;
		if (style == null) {
			data = DatabaseQueryer.getData("getStyle");
			
			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("style"); 
					}
					style = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
			return style;
		}
		return style;
	}
	public static void setStyle(String style) {
		Controller.style = style;
	}
	
	public static String getWebsite() {
		String data;
		if (website == null) {
			data = DatabaseQueryer.getData("getWebsite");

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("website"); 
					}
					website = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
			return website;
		}
		return website;
	}
	public static void setWebsite(String website) {
		Controller.website = website;
	}
	
	public static String getWork_Interests() {
		String data;
		if (work_interests == null) {
			data = DatabaseQueryer.getData("getWork_Interests");

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("work_interests"); 
					}
					work_interests = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
			return work_interests;
		}
		return work_interests;
	}
	public static void setWork_Interests(String work_interests) {
		Controller.work_interests = work_interests;
	}
	
	public static String getAbout() {
		String data;
		if (about == null) {
			data = DatabaseQueryer.getData("getAbout");

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("about"); 
					}
					about = s;
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
			return about;
		}
		return about;
	}
	public static void setAbout(String about) {
		Controller.about = about;
	}
	
	public Boolean getFor_Hire() {
		String data;
		if (for_hire == null) {
			data = DatabaseQueryer.getData("getFor_Hire");

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("for_hire"); 
					}
					int fh = Integer.parseInt(s);
					if(fh == 1) {
						for_hire = true;
					} else {
						for_hire = false;
					}
						
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
			return for_hire;
		}
		return for_hire;
	}
	public void setForHire(Boolean for_hire) {
		this.for_hire = for_hire;
	}
	
	public Boolean getReviews_Allowed() {
		String data;
		if (reviews_allowed == null) {
			data = DatabaseQueryer.getData("getReviews_Allowed");

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("reviews_allowed"); 
					}
					int fh = Integer.parseInt(s);
					if(fh == 1) {
						reviews_allowed = true;
					} else {
						reviews_allowed = false;
					}
						
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
			return reviews_allowed;
		}
		return reviews_allowed;
	}
	public void setReviewsAllowed(Boolean reviews_allowed) {
		this.reviews_allowed = reviews_allowed;
	}
	
	public Boolean getGuestbook_Allowed() {
		String data;
		if (guestbook_allowed == null) {
			data = DatabaseQueryer.getData("getGuestbook_Allowed");

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("guestbook_allowed"); 
					}
					int fh = Integer.parseInt(s);
					if(fh == 1) {
						guestbook_allowed = true;
					} else {
						guestbook_allowed = false;
					}
						
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
			return guestbook_allowed;
		}
		return guestbook_allowed;
	}
	public void setGuestBookAllowed(Boolean guestbook_allowed) {
		this.guestbook_allowed = guestbook_allowed;
	}
	
	public Boolean getComments_Allowed() {
		String data;
		if (comments_allowed == null) {
			data = DatabaseQueryer.getData("comments_allowed");

			try { 
				String s = ""; 
				JSONArray jArray = new JSONArray(data); 
					for (int i = 0; i < jArray.length(); i++) { 
						JSONObject json = jArray.getJSONObject(i); 
						s = s + json.getString("comments_allowed"); 
					}
					int fh = Integer.parseInt(s);
					if(fh == 1) {
						comments_allowed = true;
					} else {
						comments_allowed = false;
					}
						
				} catch (Exception e) {
					Log.e("log_tag", "Error Parsing Data " + e.toString()); 
				}
			
			return comments_allowed;
		}
		return comments_allowed;
	}
	public void setCommentsAllowed(Boolean comments_allowed) {
		this.comments_allowed = comments_allowed;
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
