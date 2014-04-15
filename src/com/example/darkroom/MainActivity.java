package com.example.darkroom;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import org.json.JSONArray;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText userNameText;
	EditText passwordText;
	TextView errorText;
	Button loginButton;
	Button regButton;
	InputStream isr = null;

	private static String userName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		userNameText = (EditText) findViewById(R.id.userTextField);
		passwordText = (EditText) findViewById(R.id.passwordTextField);
		errorText = (TextView) findViewById(R.id.statusText);

		
		loginButton = (Button) findViewById(R.id.registerButtonRegister);
		loginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) { // go to next screen
				String name = userNameText.getText().toString();
				String pass = passwordText.getText().toString();

				String result = "";
				InputStream isr = null;
				try {
					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httppost = new HttpPost(
							"http://54.201.1.107/php/login.php"); 
					List<NameValuePair> params = new ArrayList<NameValuePair>(2);
					params.add(new BasicNameValuePair("email", "darkroom"));
					params.add(new BasicNameValuePair("pass", "darkroom"));
					
					httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
					HttpResponse response = httpclient.execute(httppost);
						
						
					HttpEntity entity = response.getEntity();
					isr = entity.getContent();
				} catch (Exception e) {
					Log.e("log_tag", "Error in http connection " + e.toString());
					
				}
				// convert response to string
				try {
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(
							isr, "iso-8859-1"), 8);
					StringBuilder sb = new StringBuilder();
					String line = reader.readLine();
					sb.append(line);
						result = sb.toString();
				} catch (Exception e) {
					Log.e("log_tag", "Error  converting result " + e.toString());
				}

					// parse json data
					try {
						if(result == "true"){
							Intent goToHomePage = new Intent(v.getContext(),
									HomeActivity.class);
							startActivityForResult(goToHomePage, 0);
						}
						else{
							errorText.setText("Error: Incorrect Username/Password");
						}

					} catch (Exception e) {
						// TODO: handle exception
						Log.e("log_tag", "Error Parsing Data " + e.toString());
					}

			}

		}); // end implementation for clicking on Login button

		regButton = (Button) findViewById(R.id.registerButton);
		regButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent goToRegPage = new Intent(view.getContext(),
						RegisterActivity.class);
				startActivityForResult(goToRegPage, 0);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String name) {
		userName = name;
	}

}
