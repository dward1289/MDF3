package com.DevonaWard.thebook;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.EditText;


public class MadGeekBrowser extends Activity {
	
	WebView webView;
	EditText urlTxt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.theblist);		
		
		//Gets intent from previous activity
				Intent intent = getIntent();
		        
		       	String data = intent.getExtras().getString("theInfo");
		      	
		        
		       	//Display URL in browser
		      	webView = (WebView) findViewById(R.id.theBrowser);
		      	webView.setInitialScale(90);
		       	webView.loadUrl(data);
		       	
		       	//Display URL in edit text.
		       	urlTxt = (EditText) findViewById(R.id.theTxt);
		       	urlTxt.setText(data);
		       	
		       	//Stop keyboard from showing automatically.
		       	//Credit: http://stackoverflow.com/questions/9732761/how-to-avoid-automatically-appear-android-keyboard-when-activity-start
		       	getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

			}

			//OnClick for back button
			public void backButton(View view){
				if(webView.canGoBack()){
					webView.goBack();
				}
			}
			
			//OnClick for go button
			public void goButton(View view){
				webView.loadUrl(urlTxt.getText().toString());
			}
			
			//OnClick for refresh button
			public void refreshButton(View view){
				webView.reload();
			}
			
			//OnClick for forward button
			public void forwardButton(View view){
				if(webView.canGoForward()){
					webView.goForward();
				}
			}
			
			//OnClick for stop button
			public void stopButton(View view){
				webView.stopLoading();
			}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
