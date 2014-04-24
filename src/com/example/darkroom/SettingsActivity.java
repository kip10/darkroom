package com.example.darkroom;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * each field in this class needs to be loaded for the proper settings from the user 
 * fromthe database.
 * 
 * Also need to set onclick listeners for the checkboxes, as well as some backend interaction
 * for the editTexts(not sure how that will work).
 * @author Eric
 *
 */
public class SettingsActivity extends Activity {
	private EditText equipmentText;
	private EditText styleText;
	private EditText websiteText;
	private EditText workText;
	private EditText aboutText;
	
	private CheckBox forHire;
	private CheckBox reviewsAllowed;
	private CheckBox guestBookAllowed;
	private CheckBox commentsAllowed;

	private Button menuButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		equipmentText = (EditText)findViewById(R.id.settingsEquipment);
		styleText = (EditText)findViewById(R.id.settingsStyle);
		websiteText = (EditText)findViewById(R.id.settingsWebsite);
		workText = (EditText) findViewById(R.id.settingsWorkInterest);
		aboutText = (EditText)findViewById(R.id.settingsAbout);
		
		forHire = (CheckBox)findViewById(R.id.settingsForHire);
		reviewsAllowed = (CheckBox)findViewById(R.id.settingsAllowReviews);
		
		menuButton = (Button)findViewById(R.id.settingsMenuButton); 
		menuButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToMenuPage = new Intent(v.getContext(),
						MenuActivity.class);
				startActivityForResult(goToMenuPage, 0);
				
			}
		});
		setContentView(R.layout.activity_settings);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
