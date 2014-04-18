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

public class RatingActivity extends Activity {
	private Button backButton;
	private Button submitButton;
	private ImageView image;
	private TextView userName;
	
	private TextView score0;
	private TextView score1;
	private TextView score2;
	private TextView score3;
	private TextView score4;
	
	private EditText edit0;
	private EditText edit1;
	private EditText edit2;
	private EditText edit3;
	private EditText edit4;
	private List<EditText> ratingsList;
	private List<TextView> scoresList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating);
		
		image = (ImageView)findViewById(R.id.ratingPicture);
		image.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToReviewsPage = new Intent(v.getContext(),
						ReviewsActivity.class);
				startActivityForResult(goToReviewsPage, 0);
				
			}
		});
		
		userName = (TextView)findViewById(R.id.ratingUserName);
		score0 = (TextView)findViewById(R.id.ratingRatingScore0);
		score1 = (TextView)findViewById(R.id.ratingRatingScore1);
		score2 = (TextView)findViewById(R.id.ratingRatingScore2);
		score3 = (TextView)findViewById(R.id.ratingRatingScore3);
		score4 = (TextView)findViewById(R.id.ratingRatingScore4);
		
		scoresList.add(score0);
		scoresList.add(score1);
		scoresList.add(score2);
		scoresList.add(score3);
		scoresList.add(score4);
		//TODO: Populate scores
		
		for(TextView tv: scoresList){
			tv.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent goToReviewsPage = new Intent(v.getContext(),
							ReviewsActivity.class);
					startActivityForResult(goToReviewsPage, 0);
					
				}
			});
		}
		edit0 = (EditText)findViewById(R.id.ratingRatingEntry0);
		edit1 = (EditText)findViewById(R.id.ratingRatingEntry1);
		edit2 = (EditText)findViewById(R.id.ratingRatingEntry2);
		edit3 = (EditText)findViewById(R.id.ratingRatingEntry3);
		edit4 = (EditText)findViewById(R.id.ratingRatingEntry4);
		
		ratingsList= new ArrayList<EditText>();
		ratingsList.add(edit0);
		ratingsList.add(edit1);
		ratingsList.add(edit2);
		ratingsList.add(edit3);
		ratingsList.add(edit4);
		
		userName.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToUserHome = new Intent(v.getContext(),
						UserHomeActivity.class);
				startActivityForResult(goToUserHome, 0);
				
			}
		});
		
		//TODO: set image on click listener
		
		backButton = (Button)findViewById(R.id.ratingBackButton);
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToFeedPage = new Intent(v.getContext(),
						FeedActivity.class);
				startActivityForResult(goToFeedPage, 0);
				
			}
		});
		
		submitButton = (Button)findViewById(R.id.ratingSubmitButton);
		submitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				for(EditText et: ratingsList){
					String rating = et.getText().toString();
					if(!isInt(rating)){
						Toast.makeText(getBaseContext(), "Enter an Integer for the Rating", Toast.LENGTH_LONG ).show();
						return;
					}
					if(!validRating(rating)){
						Toast.makeText(getBaseContext(), "Rating must be in range 0-10", Toast.LENGTH_LONG).show();
						return;
					}
				}
				//TODO: rate on BackEnd
				//TODO: change view after submitting? or toast
				
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
