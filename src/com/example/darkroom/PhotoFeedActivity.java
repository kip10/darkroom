package com.example.darkroom;

import java.util.ArrayList;
import java.util.List;

import com.example.listObjects.FeedObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PhotoFeedActivity extends Activity {
	private Button backButton;
	private ListView list;
	private List<FeedObject> feedList = new ArrayList<FeedObject>(200);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_following);
		
		list = (ListView)findViewById(R.id.FollowingList);
		populateList();
		populateListView();
		backButton = (Button)findViewById(R.id.FollowingBackButton);
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToUserHome = new Intent(v.getContext(),
						UserHomeActivity.class);
				startActivityForResult(goToUserHome, 0);
				
			}
		});
	}
	

	private void populateList() {
		/*
		Cursor cursor = myDb.getAllRows();
		
		//allow activity to manage cursor
		startManagingCursor(cursor);
		
		//setup mapping from cursor to fields
		String[] fromFieldNames = new String[]{"username"};
		int[] toViewIDs = new int[]{R.id.pageFeedUserName};
		
		//create adapter to map one element of db to element of ui
		SimpleCursorAdapter mySCA = new SimpleCursorAdapter(
				this, 
				R.layout.feed_layout,
				cursor,
				fromFieldNames, 
				toViewIDs,
				0);
		*/
		//TODO: add all items to List
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feed, menu);
		return true;
	}
	private void populateListView() {
		ArrayAdapter<FeedObject> myAdapter = new MyListAdapter();
		ListView feedList = (ListView) findViewById(R.layout.activity_following);
		feedList.setAdapter(myAdapter);
		
	}
	
	private class MyListAdapter extends ArrayAdapter<FeedObject>{
		public MyListAdapter(){
			super(PhotoFeedActivity.this, R.layout.feed_layout, feedList);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//Make sure we have view to work with
			View itemView = convertView;
			if(itemView==null){
				itemView = getLayoutInflater().inflate(R.layout.feed_layout, parent, false);
			}
			FeedObject currentObject = feedList.get(position);
			
			//fill fields
			ImageView image = (ImageView)itemView.findViewById(R.id.pageFeedImage);
			//TODO: set image
			image.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//TODO: Implement
					
				}
			});
			
			
			TextView userName = (TextView)itemView.findViewById(R.id.videoFeedUserName);
			userName.setText(currentObject.getUsername());
			userName.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				Intent goToHomePage = new Intent(v.getContext(),
							UserHomeActivity.class);
					startActivityForResult(goToHomePage, 0);
					
				}
			});
			
			TextView title = (TextView)itemView.findViewById(R.id.videoFeedTitle);
			title.setText(currentObject.getTitle());
			title.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent goToRatingPage = new Intent(v.getContext(),
							UserHomeActivity.class);
					startActivityForResult(goToRatingPage, 0);
					
				}
			});
			
			TextView rating = (TextView)itemView.findViewById(R.id.videoFeedRating);
			rating.setText(String.valueOf(currentObject.getRating()));
			rating.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent goToReviews = new Intent(v.getContext(),
							ReviewsActivity.class);
					startActivityForResult(goToReviews, 0);
					
				}
			});
			return itemView;
		}
	}

}
