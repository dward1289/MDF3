package com.DevonaWard.mgbrowser;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//OnClick to call the intent
	 public void callIt(View view) {
	    	Intent intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://sports-ak.espn.go.com/nba/"));
	    	
	    	startActivity(intent);
	    }

}
