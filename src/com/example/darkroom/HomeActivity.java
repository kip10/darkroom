package com.example.darkroom;

import java.sql.ResultSet;
import java.sql.SQLException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends Activity {
	private EditText equipmentText;
	private EditText styleText;
	private EditText websiteText;
	private EditText workText;
	
	private TextView forHire;
	private TextView reviewsAllowed;
	private TextView guestBookAllowed;
	private TextView commentsAllowed;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		equipmentText = (EditText)findViewById(R.id.homeEquipmentText);
		styleText = (EditText)findViewById(R.id.homeStyleText);
		websiteText = (EditText)findViewById(R.id.homeWebsiteText);
		workText = (EditText) findViewById(R.id.homeWorkInterestText);
		setEditText(equipmentText);
		setEditText(styleText);
		setEditText(websiteText);
		setEditText(workText);
		
		forHire = (TextView)findViewById(R.id.homeForHireText);
		reviewsAllowed = (TextView)findViewById(R.id.homeAllowReviewsText);
		guestBookAllowed = (TextView)findViewById(R.id.homeAllowGuestbookText);
		commentsAllowed = (TextView)findViewById(R.id.homeAllowCommentsText);
		
		try {
			setTextView(forHire);
			setTextView(reviewsAllowed);
			setTextView(guestBookAllowed);
			setTextView(commentsAllowed);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setEditText(EditText et) {
		ResultSet rs;
		switch(et.getId()){
		case R.id.homeEquipmentText:
			try {
				rs = DatabaseQueryer.connectToAndQueryDatabase("SELECT equipment FROM users u WHERE"
						+ "u.username = " + MainActivity.getUserName());
				et.setText(rs.getString("equipment"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		//TODO: IMPLEMENT THE QUERYING FIELDS FOR THE OTHER EDITTEXTS
		
		}
	}
	
	private void setTextView(TextView tv) throws SQLException {
		ResultSet rs;
		switch(tv.getId()){
		case R.id.homeForHireText:
			rs = DatabaseQueryer.connectToAndQueryDatabase("SELECT for_hire FROM users u WHERE "
					+ "u.username = " +MainActivity.getUserName());
			if(rs.getByte("for_hire") == 0) tv.setText("No");
			else tv.setText("Yes");
			break;
		//TODO: IMPLEMENT QUERYING OTHER FIELDS AS WELL
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
