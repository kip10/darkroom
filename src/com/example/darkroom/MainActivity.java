package com.example.darkroom;

import java.sql.ResultSet;
import java.sql.SQLException;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
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

				try {
					ResultSet users = null;
					try {
						users = DatabaseQueryer
								.connectToAndQueryDatabase("SELECT * FROM users u WHERE u.username = "
										+ name + "AND u.password = " + pass);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (users.getMetaData().getColumnCount() != 1) {
						errorText.setText("Error: Incorrect Username/Password");
						
						passwordText.setText("");
					} else {
						userName = name;
						Intent goToHomePage = new Intent(v.getContext(),
								HomeActivity.class);
						startActivityForResult(goToHomePage, 0);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					// implement any other buttons needed
				} // end switch
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

	public static String getUserName(){
		return userName;
	}
	public static void setUserName(String name){
		userName = name;
	}
}
