package com.example.darkroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	private Button registerButton;
	private EditText uName;
	private EditText pass;
	private EditText eMail;
	private TextView statusText;
	
	Database dbUsers;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		uName = (EditText) findViewById(R.id.registerUserText);
		pass = (EditText)findViewById(R.id.registerPasswordText);
		eMail = (EditText)findViewById(R.id.registerEmailText);
	
		dbUsers = new Database(getBaseContext());
		dbUsers.open();
		
		registerButton = (Button)findViewById(R.id.registerButtonRegister);
		registerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String name = uName.getText().toString();
				String password = pass.getText().toString();
				String email = eMail.getText().toString();
			
				Cursor resultSet = dbUsers.queryUName(name);
				if(resultSet.getCount() !=0){		
					long id = dbUsers.insertData(name, email, password);
					Toast.makeText(getBaseContext(), "Data inserted",Toast.LENGTH_LONG).show();
					dbUsers.close();
				}
				else{
					//Toast.makeText(getBaseContext(), "already exists", Toast.LENGTH_LONG).show();
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
