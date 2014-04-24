package com.example.darkroom;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Rating Activity still needs back end interaction after submitting the rating,
 * as well as loading everything (username, image, title, score in score0), from the PhotoFeed 
 * that generated this view  
 * 
 *
 */
public class RatingActivity extends Activity {
	private Button backButton;
	private Button submitButton;
	private ImageView image;
	private TextView userName;
	private TextView title;
	private TextView score0;
	private EditText edit0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating);
		
		image = (ImageView)findViewById(R.id.ratingPicture);
		image.setOnClickListener(new View.OnClickListener() {
		//TODO: populate right picture
			@Override
			public void onClick(View v) {
				Intent goToReviewsPage = new Intent(v.getContext(),
						ReviewsActivity.class);
				startActivityForResult(goToReviewsPage, 0);
				//TODO: go to proper review
			}
		});
		
		userName = (TextView)findViewById(R.id.ratingUserName);
		userName.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToUserHome = new Intent(v.getContext(),
						UserHomeActivity.class);
				startActivityForResult(goToUserHome, 0);
				//TODO: go to right user page
			}
		});
		
		score0 = (TextView)findViewById(R.id.ratingRatingScore0);
		//TODO: Populate scores
		
		title = (TextView)findViewById(R.id.ratingTitle);
		
		edit0 = (EditText)findViewById(R.id.ratingRatingEntry0);
		
		backButton = (Button)findViewById(R.id.ratingBackButton);
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToFeedPage = new Intent(v.getContext(),
						PhotoFeedActivity.class);
				startActivityForResult(goToFeedPage, 0);
				
			}
		});
		
		submitButton = (Button)findViewById(R.id.ratingSubmitButton);
		submitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String rating = edit0.getText().toString();
				if(!isInt(rating)){
					Toast.makeText(getBaseContext(), "Enter an Integer for the Rating", Toast.LENGTH_LONG ).show();
					return;
				}
				
				if(!validRating(rating)){
					Toast.makeText(getBaseContext(), "Rating must be in range 0-10", Toast.LENGTH_LONG).show();
					return;
				}
				
				//TODO: rate on BackEnd
				Toast.makeText(getBaseContext(), "Rating Submitted!",Toast.LENGTH_LONG).show();
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rating, menu);
		return true;
	}
	
	private boolean isInt(String s){
		
		for(int i = 0; i<s.length(); i++){
			if((int)s.charAt(i)<48 || (int)s.charAt(i) > 57) {
				//determine if out of ASCII range
				return false;
			}
		}
		return true;
	}

	private boolean validRating(String rating) {
		if(rating.length() < 1 || rating.length() > 2){
			return false;
		}
		else if(rating.charAt(0) != '1' || rating.charAt(1)!= 0 ){
			//10 is a valid rating
			return false;
		}
		else{
			return true;
		}
		
	}
}
