package com.example.darkroom;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.listObjects.ReviewsObject;

/**
 * This class still needs to :
 * 1. Load the proper image, title, overall rating, following, which will most likely be done through
 * communicating with the RatingsActivity class. Everything from the activity_reviews.xml file
 * 
 *2. populate each element of the reviewsList in the same manner as in the followers/followingActivity
 *classes. These elements are found in the reviews_layout.xml file
 *
 *3. set the onclick listener for the image in the getView method to full screen the image
 */
public class ReviewsActivity extends Activity{
	private Button backButton;
	private ListView list;
	private ImageView image;
	private TextView title;
	private TextView userName;
	private TextView score;
	private CheckBox checkBoxFollowing;
	private List<ReviewsObject> reviewList = new ArrayList<ReviewsObject>(40);
	 
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reviews);
	
		backButton = (Button)findViewById(R.id.reviewsBackButton);
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToMenuPage = new Intent(v.getContext(),
						MenuActivity.class);
				startActivityForResult(goToMenuPage, 0);
				//TODO: determine if right class?
			}
		});
		
		image = (ImageView)findViewById(R.id.reviewsImage);
		
		
		title = (TextView)findViewById(R.id.reviewsTitle);
		
		
		userName = (TextView)findViewById(R.id.reviewsUserName);
		
		userName.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToUserPage = new Intent(v.getContext(),
						UserHomeActivity.class);
				startActivityForResult(goToUserPage, 0);
				
			}
		});
		
		checkBoxFollowing =(CheckBox)findViewById(R.id.reviewsCheckBox);
		
		score = (TextView)findViewById(R.id.reviewsScore);
		populateListView();
	}
	
	private void populateListView() {
		ArrayAdapter<ReviewsObject> myAdapter = new MyListAdapter();
		ListView rList = (ListView) findViewById(R.layout.activity_reviews);
		rList.setAdapter(myAdapter);
		
	}
	
	private class MyListAdapter extends ArrayAdapter<ReviewsObject>{
		public MyListAdapter(){
			super(ReviewsActivity.this, R.layout.reviews_layout, reviewList);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//Make sure we have view to work with
			View itemView = convertView;
			if(itemView==null){
				itemView = getLayoutInflater().inflate(R.layout.reviews_layout, parent, false);
			}
			ReviewsObject currentObject = reviewList.get(position);
			ImageView avatar = (ImageView)itemView.findViewById(R.id.pageReviewAvatar);
			//TODO: set image
			//TODO: set onclick listener

			TextView review = (TextView)itemView.findViewById(R.id.pageReviewReview);
			review.setText(currentObject.getReview());

			TextView username = (TextView)itemView.findViewById(R.id.pageReviewUser);
			username.setText(currentObject.getUserName());
			username.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent goToUserPage = new Intent(v.getContext(),
							UserHomeActivity.class);
					startActivityForResult(goToUserPage, 0);
					
				}
			});
			
			TextView rating0 = (TextView)itemView.findViewById(R.id.pageReviewScore);
			rating0.setText(String.valueOf(currentObject.getRating1()));
					
			CheckBox following = (CheckBox)itemView.findViewById(R.id.pageReviewFollowing);
			following.setChecked(currentObject.isFollowing());
			following.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});
			return itemView;
		}
	}
}
