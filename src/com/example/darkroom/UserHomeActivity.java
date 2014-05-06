package com.example.darkroom;

import java.net.URI;
import java.net.URISyntaxException;

import com.example.backend.DatabaseQueryer;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Need to upload the avatar, about text, etc. from the database from this page.
 * @author Eric
 *
 */
public class UserHomeActivity extends Activity {
	private Button followersButton;
	private Button followingButton;
	private Button uploadsButton;
	private Button menuButton;
	
	private CheckBox followCheckBox;
	
	private TextView userName;
	private TextView aboutText;
	
	private ImageView avatar;
	//Field variables set from elsewhere to 
	private static String username;
	
	private static String getUsername(){
		return username;
	}
	public static void setUsername(String name){
		username=name;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_home);
		
		followCheckBox = (CheckBox)findViewById(R.id.userHomeFollowCheck);
		followCheckBox.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(getUsername().equals(MainActivity.getUserName())){
					// can't follow self
					String message = "Error: Can't follow self";
					Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
					followCheckBox.setChecked(false); 
					//make assumption that checkbox won't be checked if your home page
				}
				else{
					//TODO: php script for following
				}
			}
		});
		userName = (TextView)findViewById(R.id.userHomeUsername);
		userName.setText(getUsername());
		aboutText = (TextView)findViewById(R.id.userHomeAboutTextView);
		aboutText.setText(DatabaseQueryer.getData("getAboutText"));
		
		
		avatar = (ImageView)findViewById(R.id.userHomeAvatar);
		Uri avi = Uri.parse(DatabaseQueryer.getData("getAvatar"));
		avatar.setImageURI(avi);

		followingButton = (Button)findViewById(R.id.userHomeFollowingButton);
		followingButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToFollowingPage = new Intent(v.getContext(),
						FollowingActivity.class);
				startActivityForResult(goToFollowingPage, 0);
				
			}
		});
		
		followersButton = (Button)findViewById(R.id.userHomeFollowersButton);
		followersButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToFollowersPage = new Intent(v.getContext(),
						FollowersActivity.class);
				startActivityForResult(goToFollowersPage, 0);
				
			}
		});
		
		uploadsButton = (Button)findViewById(R.id.userHomeUploadsButton);
		uploadsButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToUploadsPage = new Intent(v.getContext(),
						UploadsActivity.class);
				startActivityForResult(goToUploadsPage, 0);
				
			}
		});
		
		menuButton = (Button)findViewById(R.id.userHomeMenuButton);
		menuButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToMenuPage = new Intent(v.getContext(),
						MenuActivity.class);
				startActivityForResult(goToMenuPage, 0);
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_home, menu);
		return true;
	}

}
