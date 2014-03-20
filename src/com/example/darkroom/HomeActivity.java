package com.example.darkroom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends Activity {
	private EditText equipmentText;
	private EditText styleText;
	private EditText websiteText;
	private EditText workText;
	
	private CheckBox forHire;
	private CheckBox reviewsAllowed;
	private CheckBox guestBookAllowed;
	private CheckBox commentsAllowed;
	
	private List<EditText> etList;
	private List<CheckBox> tvList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		equipmentText = (EditText)findViewById(R.id.homeEquipmentText);
		styleText = (EditText)findViewById(R.id.homeStyleText);
		websiteText = (EditText)findViewById(R.id.homeWebsiteText);
		workText = (EditText) findViewById(R.id.homeWorkInterestText);
		
		etList = new LinkedList<EditText>();
		etList.add(equipmentText);
		etList.add(styleText);
		etList.add(websiteText);
		etList.add(workText);
		
		for(EditText item : etList){
			setEditText(item);
		}
		
		forHire = (CheckBox)findViewById(R.id.homeForHireText);
		reviewsAllowed = (CheckBox)findViewById(R.id.homeAllowReviewsText);
		guestBookAllowed = (CheckBox)findViewById(R.id.homeAllowGuestbookText);
		commentsAllowed = (CheckBox)findViewById(R.id.homeAllowCommentsText);
		
		tvList = new LinkedList<CheckBox>();
		tvList.add(forHire);
		tvList.add(reviewsAllowed);
		tvList.add(guestBookAllowed);
		tvList.add(commentsAllowed);
		
		try {
			for(CheckBox textItem: tvList){
				setCheckBox(textItem);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setContentView(R.layout.activity_home);
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
	
	private void setCheckBox(CheckBox cb) throws SQLException {
		ResultSet rs;
		switch(cb.getId()){
		case R.id.homeForHireText:
			rs = DatabaseQueryer.connectToAndQueryDatabase("SELECT for_hire FROM users u WHERE "
					+ "u.username = " +MainActivity.getUserName());
			if(rs.getByte("for_hire") == 0) cb.setChecked(false);
			else cb.setChecked(true);
			break;
		//TODO: IMPLEMENT QUERYING OTHER FIELDS AS WELL
			//after the PHP gets implemented
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
