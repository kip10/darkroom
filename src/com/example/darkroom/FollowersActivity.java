package com.example.darkroom;

import java.util.ArrayList;
import java.util.List;

import com.example.listObjects.FollowObject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FollowersActivity extends Activity{
	private Button backButton;
	private ListView list;
	private List<FollowObject> followList = new ArrayList<FollowObject>(100);
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_following);
	
		backButton = (Button)findViewById(R.id.FollowingBackButton);
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToUserPage = new Intent(v.getContext(),
						UserHomeActivity.class);
				startActivityForResult(goToUserPage, 0);
				
			}
		});
		
		list = (ListView)findViewById(R.id.FollowingList);
		populateList();
		populateListView();
	}
	private void populateList() {
		/*
		Cursor cursor = myDb.getAllRows();
		
		//allow activity to manage cursor
		startManagingCursor(cursor);
		
		//setup mapping from cursor to fields
		String[] fromFieldNames = new String[]{"username"};
		int[] toViewIDs = new int[]{R.id.itemLayoutUserName};
		
		//create adapter to map one element of db to element of ui
		SimpleCursorAdapter mySCA = new SimpleCursorAdapter(
				this, 
				R.layout.follow_layout,
				cursor,
				fromFieldNames, 
				toViewIDs,
				0);
		
		*/
	}
	private void populateListView() {
		ArrayAdapter<FollowObject> myAdapter = new MyListAdapter();
		ListView fList = (ListView) findViewById(R.layout.activity_following);
		fList.setAdapter(myAdapter);
		
	}
	
	private class MyListAdapter extends ArrayAdapter<FollowObject>{
		public MyListAdapter(){
			super(FollowersActivity.this, R.layout.follow_layout, followList);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//Make sure we have view to work with
			View itemView = convertView;
			if(itemView==null){
				itemView = getLayoutInflater().inflate(R.layout.follow_layout, parent, false);
			}
			FollowObject currentObject = followList.get(position);
			ImageView avatar = (ImageView)itemView.findViewById(R.id.itemLayoutAvatar);
			//TODO: set image
			//TODO: set onclick listener
			
			TextView username = (TextView)itemView.findViewById(R.id.itemLayoutUserName);
			username.setText(currentObject.getUsername());
			username.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent goToUserPage = new Intent(v.getContext(),
							UserHomeActivity.class);
					startActivityForResult(goToUserPage, 0);
					
				}
			});
			
			CheckBox following = (CheckBox)itemView.findViewById(R.id.itemLayoutFollowingCheckBox);
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
