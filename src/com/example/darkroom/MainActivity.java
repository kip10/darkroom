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

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import android.widget.Toast;
/**
 * MainActivity class should be completed unless something is changed on the backend with the 
 * log in process
 * 
 * You can see an example of how to use the php scripts to interact with the database here,
 * where i use the login.php script to do so.
 */
public class MainActivity extends Activity {
	EditText userEmail;
	EditText passwordText;
	TextView errorText;
	Button loginButton;
	Button regButton;
	InputStream isr = null;

	private static String userName;

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 
		
		userEmail = (EditText) findViewById(R.id.userTextField);
		passwordText = (EditText) findViewById(R.id.passwordTextField);
		errorText = (TextView) findViewById(R.id.statusText);

		loginButton = (Button) findViewById(R.id.registerButtonRegister);
		loginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) { // go to next screen
				String name = userEmail.getText().toString();
				String pass = passwordText.getText().toString();

				String result = "";
				InputStream isr = null;
				try {
					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httppost = new HttpPost(
							"http://54.201.1.107/php/loginTrue.php");
					List<NameValuePair> params = new ArrayList<NameValuePair>(2);
					params.add(new BasicNameValuePair("email", name));
					params.add(new BasicNameValuePair("pass", pass));

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
						userName = name;
						Intent goToMenuPage = new Intent(v.getContext(),
								MenuActivity.class);
						startActivityForResult(goToMenuPage, 0);
					} else {
						Toast.makeText(getBaseContext(), "Error, Incorrect Username/Password", Toast.LENGTH_LONG ).show();
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
