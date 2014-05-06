package com.example.darkroom;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * each field in this class needs to be loaded for the proper settings from the user 
 * from the database.
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
	private TextView username;
	private TextView pass;
	
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
		
		pass = (TextView)findViewById(R.string.password);
		
		forHire = (CheckBox)findViewById(R.id.settingsForHire);
		reviewsAllowed = (CheckBox)findViewById(R.id.settingsAllowReviews);
		
		String name = MainActivity.getUserName();
		String password = pass.getText().toString();

		String result = "";
		InputStream isr = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(
					"http://54.201.1.107/php/settings.php");
			List<NameValuePair> params = new ArrayList<NameValuePair>(2);
			params.add(new BasicNameValuePair("email", name));
			params.add(new BasicNameValuePair("pass", password));

			httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			HttpResponse response = httpclient.execute(httppost);

			HttpEntity entity = response.getEntity();
			isr = entity.getContent();
		} catch (Exception e) {
			Log.e("log_tag", "Error in http connection " + e.toString());

		}
		// convert response to string
		try {

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(isr, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			sb.append(line);
			result = sb.toString();
		} catch (Exception e) {
			Log.e("log_tag", "Error  converting result " + e.toString());
		}

		// parse json data
		try {
			if (result.equalsIgnoreCase("true")) {
				//Figure out settings data and apply it to views
				
			} else {
				Toast.makeText(getBaseContext(), "Error, Incorrect Username/Password", Toast.LENGTH_LONG ).show();
			}

		} catch (Exception e) {
			// TODO: handle exception
			Log.e("log_tag", "Error Parsing Data " + e.toString());
		}
		
		
		
		
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
