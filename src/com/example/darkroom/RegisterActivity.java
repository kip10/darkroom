package com.example.darkroom;

import java.sql.ResultSet;
import java.sql.SQLException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity {
	private Button registerButton;
	private EditText uName;
	private EditText pass;
	private EditText eMail;
	private TextView statusText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		uName = (EditText) findViewById(R.id.registerUserText);
		pass = (EditText)findViewById(R.id.registerPasswordText);
		eMail = (EditText)findViewById(R.id.registerEmailText);
	
		registerButton = (Button)findViewById(R.id.registerButtonRegister);
		registerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = uName.getText().toString();
				String password = pass.getText().toString();
				String email = eMail.getText().toString();
			
				try {
					ResultSet users = DatabaseQueryer
							.connectToAndQueryDatabase("SELECT * FROM users u WHERE u.username = "
									+ name  );
					if(users.getMetaData().getColumnCount() > 0) {
						statusText.setText("Username already exists. Pick a new one.");
					}
					else{
						DatabaseQueryer.connectToAndUpdateDatabase("INSERT INTO Users(email, username, password)"
								+ "VALUES('" +email+ "', '"+ name+ "', '"+password + ");");
						MainActivity.setUserName(name);
						Intent goToRegPage = new Intent(v.getContext(),
								RegisterActivity.class);
						startActivityForResult(goToRegPage, 0);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
