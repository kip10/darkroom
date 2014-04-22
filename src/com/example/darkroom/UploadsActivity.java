package com.example.darkroom;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class UploadsActivity extends Activity{
	private Button backButton;
	private ListView list;
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
}
