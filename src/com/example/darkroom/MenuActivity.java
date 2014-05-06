package com.example.darkroom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Class is complete, any button that is clicked will get sent to that activity,
 * and each page has a link back to the menu.
 * 
 *
 */
public class MenuActivity extends Activity {
	private Button settingsButton;
	private Button videoFeed;
	private Button photoFeed;
	private Button userHome;
	
	private TextView userText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		userText = (TextView)findViewById(R.id.menuUsername);
		userText.setText(MainActivity.getUserName());
		
		settingsButton = (Button)findViewById(R.id.menuSettings);
		settingsButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent goToSettingsPage = new Intent(view.getContext(),
						SettingsActivity.class);
				startActivityForResult(goToSettingsPage, 0);
			}
		});
		
		videoFeed = (Button)findViewById(R.id.menuVideoFeed);
		videoFeed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToVidPage = new Intent(v.getContext(),
						VideoFeedActivity.class);
				startActivityForResult(goToVidPage, 0);
				
			}
		});
		
		photoFeed = (Button)findViewById(R.id.menuPhotoFeed);
		photoFeed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent goToFeedPage = new Intent(view.getContext(),
						PhotoFeedActivity.class);
				startActivityForResult(goToFeedPage, 0);
				
			}
		});
		
		userHome = (Button)findViewById(R.id.menuUserPage);
		userHome.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				UserHomeActivity.setUsername(MainActivity.getUserName());
				Intent goTohomePage = new Intent(v.getContext(),
						UserHomeActivity.class);
				startActivityForResult(goTohomePage, 0);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}
