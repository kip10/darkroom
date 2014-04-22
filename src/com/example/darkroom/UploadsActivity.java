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

import com.example.listObjects.UploadObject;

public class UploadsActivity extends Activity{
	private Button backButton;
	private ListView list;
	private List<UploadObject> uploadList = new ArrayList<UploadObject>(70);
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uploads);
	
		backButton = (Button)findViewById(R.id.uploadBackButton);
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToUserPage = new Intent(v.getContext(),
						UserHomeActivity.class);
				startActivityForResult(goToUserPage, 0);
				
			}
		});
		
		list = (ListView)findViewById(R.id.uploadList);
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
		int[] toViewIDs = new int[]{R.id.uploadLayoutUserName};
		
		//create adapter to map one element of db to element of ui
		SimpleCursorAdapter mySCA = new SimpleCursorAdapter(
				this, 
				R.layout.upload_layout,
				cursor,
				fromFieldNames, 
				toViewIDs,
				0);
		
		*/
	}
	private void populateListView() {
		ArrayAdapter<UploadObject> myAdapter = new MyListAdapter();
		ListView uList = (ListView) findViewById(R.layout.activity_uploads);
		uList.setAdapter(myAdapter);
		
	}
	
	private class MyListAdapter extends ArrayAdapter<UploadObject>{
		public MyListAdapter(){
			super(UploadsActivity.this, R.layout.upload_layout, uploadList);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//Make sure we have view to work with
			View itemView = convertView;
			if(itemView==null){
				itemView = getLayoutInflater().inflate(R.layout.upload_layout, parent, false);
			}
			UploadObject currentObject = uploadList.get(position);
			ImageView image = (ImageView)itemView.findViewById(R.id.uploadLayoutImage);
			//TODO: set image
			//TODO: set onclick listener
			
			TextView username = (TextView)itemView.findViewById(R.id.uploadLayoutUser);
			username.setText(currentObject.getUsername());
			username.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent goToUserPage = new Intent(v.getContext(),
							UserHomeActivity.class);
					startActivityForResult(goToUserPage, 0);
					
				}
			});
			
			CheckBox following = (CheckBox)itemView.findViewById(R.id.uploadLayoutFollowing);
			following.setChecked(currentObject.isFollowing());
			following.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});
			
			TextView rating = (TextView)itemView.findViewById(R.id.uploadLayoutRating);
			rating.setText(currentObject.getRating());
			rating.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent goToRating = new Intent(v.getContext(),
							RatingActivity.class);
					startActivityForResult(goToRating, 0);
					
				}
			});
			
			TextView title = (TextView)itemView.findViewById(R.id.uploadLayoutTitle);
			title.setText(currentObject.getTitle());
			
			return itemView;
		}
	}
}
