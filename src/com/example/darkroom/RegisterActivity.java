package com.example.darkroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
					//ResultSet users = DatabaseQueryer
					//		.connectToAndQueryDatabase("SELECT * FROM users u WHERE u.username = "
					//				+ name  );
					//Class.forName("com.mysql.jdbc.Driver");
					connectToAndUpdateDatabase("INSERT INTO `users`(`username`, `email`, `password`) "
							+ "VALUES ('"+name+"','"+email+"','"+password+"')");
					MainActivity.setUserName(name);
					//Intent goToRegPage = new Intent(v.getContext(),
							//RegisterActivity.class);
					//startActivityForResult(goToRegPage, 0);
					/*
					if(users.getMetaData().getColumnCount() > 0) {
						statusText.setText("Username already exists. Pick a new one.");
					}
					else{
						DatabaseQueryer.connectToAndUpdateDatabase("INSERT INTO `users`(`username`, `email`, `password`) "
								+ "VALUES ('"+name+"','"+email+"','"+password+"')");
						MainActivity.setUserName(name);
						Intent goToRegPage = new Intent(v.getContext(),
								RegisterActivity.class);
						startActivityForResult(goToRegPage, 0);
					}
					*/
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
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
	
	private static String hostName = "localhost";
	private static Integer portNumber = 3306;
	private static String dbName = "dr0";
	private static String userName = "root";
	private static String password = "newpwd";
	
	public static ResultSet connectToAndQueryDatabase(String query) throws SQLException, Exception {
		//Class.forName("com.mysql.jdbc.Driver");
		
		Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dr0", "root", "newpwd");
		PreparedStatement stmt = dbConn.prepareStatement(query);
		return stmt.executeQuery(query);
	}

	public static void connectToAndUpdateDatabase(String statement) throws SQLException, Exception {
		//Class.forName("com.mysql.jdbc.Driver");
		
		Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dr0", "root", "newpwd");
		PreparedStatement stmt = dbConn.prepareStatement(statement);
		stmt.executeUpdate(statement);
	}

}
