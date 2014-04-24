package com.example.darkroom;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class VideoFeedActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_feed_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.video_feed, menu);
		return true;
	}

}
