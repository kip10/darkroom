package com.example.darkroom;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
/**
 * This class still needs the same type of work as the followers/followingActivtyClasses.
 * Populate the feedList from the database populating every field from the PhotoFeedObject, 
 * and then each widget that is found in the getView method can be set from there.
 * 
 * VideoFeedActivity uses the activity_following.xml layout, and uses the videoFeedLayout.xml
 * as the layout for each element in the list.
 * 
 * 
 *Note: may need to create a VideoFeedObject, ask Kyle if URI supports both photos and videos 
 *because I think that is what the type of the files will be.
 */
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
