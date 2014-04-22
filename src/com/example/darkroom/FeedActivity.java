package com.example.darkroom;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class FeedActivity extends Activity {
	private Button backButton;
	private ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_following);
		
		list = (ListView)findViewById(R.id.FollowingList);
		populateList();
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
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feed, menu);
		return true;
	}

}
