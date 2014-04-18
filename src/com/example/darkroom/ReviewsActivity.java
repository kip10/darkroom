package com.example.darkroom;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ReviewsActivity extends Activity{
	private Button backButton;
	private ListView list;
	private ImageView image;
	private TextView title;
	private TextView userName;
	private TextView score;
	private CheckBox checkBoxFollowing;
	
	 
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reviews);
	
		backButton = (Button)findViewById(R.id.reviewsBackButton);
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToUserPage = new Intent(v.getContext(),
						UserHomeActivity.class);
				startActivityForResult(goToUserPage, 0);
				//TODO: determine if right class?
			}
		});
		
		list = (ListView)findViewById(R.id.reviewsList);
		populateList();
		
		image = (ImageView)findViewById(R.id.reviewsImage);
		//TODO: full screen on click
		
		title = (TextView)findViewById(R.id.reviewsTitle);
		populateTitle();
		
		userName = (TextView)findViewById(R.id.reviewsUserName);
		populateUser();
		userName.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToUserPage = new Intent(v.getContext(),
						UserHomeActivity.class);
				startActivityForResult(goToUserPage, 0);
				
			}
		});
		
		checkBoxFollowing =(CheckBox)findViewById(R.id.reviewsCheckBox);
		populateCheckBox();
		
		score = (TextView)findViewById(R.id.reviewsScore);
		populateScore();
	}
	private void populateScore() {
		// TODO Auto-generated method stub
		
	}
	private void populateCheckBox() {
		// TODO Auto-generated method stub
		
	}
	private void populateUser() {
		// TODO Auto-generated method stub
		
	}
	private void populateTitle() {
		// TODO Auto-generated method stub
		
	}
	private void populateList() {
		Cursor cursor = myDb.getAllRows();
		
		//allow activity to manage cursor
		startManagingCursor(cursor);
		
		//setup mapping from cursor to fields
		String[] fromFieldNames = new String[]{"username"};
		int[] toViewIDs = new int[]{R.id.pageReviewUser};
		
		//create adapter to map one element of db to element of ui
		SimpleCursorAdapter mySCA = new SimpleCursorAdapter(
				this, 
				R.layout.reviews_layout,
				cursor,
				fromFieldNames, 
				toViewIDs,
				0);
		
		
	}
}
