/*
 * Project	GamerNews (Project-1)
 * 
 * Package	com.DevonaWard.gamernews
 * 
 * @author Devona Ward
 * 
 * Date: Oct 2, 2013
 */

package com.DevonaWard.gamernews;

import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {

	String searchSite;
	String textEntered;
	Spinner spinner;
	EditText userText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		userText = (EditText) findViewById(R.id.userEntry);
		spinner = (Spinner) findViewById(R.id.spinner);
		
		//onSelect for spinner
		spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			//Gets the selected site.
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				searchSite = parent.getItemAtPosition(pos).toString();				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	//Activate Search button onClick function.
	public void activateSearch(View view){
		
			//Gets text from EditText View.
		    textEntered = userText.getText().toString();
		    
		    if(searchSite.equals("GameSpot")){
			Uri search = Uri.parse("http://www.gamespot.com/search/?qs="+textEntered);
			Intent webIntent = new Intent(Intent.ACTION_VIEW, search);
			
			//Verifies intent
			PackageManager packageManager = getPackageManager();
			List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent, 0);
			boolean safeIntent = activities.size() > 0;
						  
			//Starts intent if safe.
			if (safeIntent) {
				startActivity(webIntent);
				}
		    }else{
		    	if(searchSite.equals("IGN")){
					Uri search = Uri.parse("http://www.ign.com/search?q="+textEntered);
					Intent webIntent = new Intent(Intent.ACTION_VIEW, search);
					
					PackageManager packageManager = getPackageManager();
					List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent, 0);
					boolean isIntentSafe = activities.size() > 0;
								  
					if (isIntentSafe) {
						startActivity(webIntent);
						}
		    	}
		    }	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
