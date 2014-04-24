package com.example.darkroom;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/**
 * This class "should be done", if the autoincrement on the userid works properly on the backend
 * 
 * 
 *
 */
public class RegisterActivity extends Activity {
	private Button registerButton;
	private EditText pass;
	private EditText passConfirm;
	private EditText eMail;
	

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 
		
		pass = (EditText) findViewById(R.id.registerPassText);
		passConfirm = (EditText)findViewById(R.id.registerPassConfirmText);
		eMail = (EditText)findViewById(R.id.registerEmailText);
		
		registerButton = (Button)findViewById(R.id.registerButtonRegister);
		registerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//int max = 0;
				String passwordConfirmed = passConfirm.getText().toString();
				String password = pass.getText().toString();
				String email = eMail.getText().toString();
			
				if(!passwordConfirmed.equals(password)){
					Toast.makeText(getBaseContext(), "Error: Passwords Don't Match", Toast.LENGTH_LONG).show();
					return;
				}
				
				String result = "";
				InputStream isr = null;
				try {
					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httppost = new HttpPost(
							"http://54.201.1.107/php/register.php");
					List<NameValuePair> params = new ArrayList<NameValuePair>(3);
					params.add(new BasicNameValuePair("email", email));
					params.add(new BasicNameValuePair("pass", password));
					//params.add(new BasicNameValuePair("max", String.valueOf(max)));
					

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

				
				try {
					if (result.equals("false")) {
						Toast.makeText(getBaseContext(), "Error: The E-mail Address is Already Registered!",Toast.LENGTH_LONG).show();
						
					} else {
						Intent goToHomePage = new Intent(v.getContext(),
								SettingsActivity.class);
						startActivityForResult(goToHomePage, 0);
					}

				} catch (Exception e) {
					
					Log.e("log_tag", "Error Parsing Data " + e.toString());
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}
	
}
