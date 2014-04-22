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

public class ReviewsActivity extends Activity{
	private Button backButton;
	private ListView list;
	private ImageView image;
	private TextView title;
	private TextView userName;
	private TextView score;
	private CheckBox checkBoxFollowing;
	private List<ReviewsObject> reviewList = new ArrayList<ReviewsObject>();
	 
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
		
		populateListView();
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
		/*
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
		
		*/
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
			
			ImageView image = (ImageView)itemView.findViewById(R.id.pageReivewImage);
			//TODO: set image
			//TODO: set on click listneer
			
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
			
			TextView rating0 = (TextView)itemView.findViewById(R.id.pageReviewScore0);
			rating0.setText(currentObject.getRating1());
			
			TextView rating1 = (TextView)itemView.findViewById(R.id.pageReviewScore1);
			rating1.setText(currentObject.getRating2());
			
			TextView rating2 = (TextView)itemView.findViewById(R.id.pageReviewScore2);
			rating2.setText(currentObject.getRating3());
			
			TextView rating3 = (TextView)itemView.findViewById(R.id.pageReviewScore3);
			rating3.setText(currentObject.getRating4());
			
			TextView rating4 = (TextView)itemView.findViewById(R.id.pageReviewScore4);
			rating4.setText(currentObject.getRating5());
			
			return itemView;
		}
	}
}
