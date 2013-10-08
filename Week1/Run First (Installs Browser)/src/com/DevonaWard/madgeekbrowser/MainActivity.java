package com.DevonaWard.madgeekbrowser;

import java.net.URL;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends Activity {

	WebView webView;
	EditText urlTxt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Gets intent from previous activity
		Intent intent = getIntent();
        
       	Uri data = intent.getData();
      	URL url = null;
        
      	//Validate accurate data for activity
       	try {
       	 	url = new URL(data.getScheme(), data.getHost(),
                               data.getPath());
      	  } catch (Exception e) {
       	 	e.printStackTrace();
       	}
        
       	//Display URL in browser
      	webView = (WebView) findViewById(R.id.theBrowser);   
       	webView.loadUrl(url.toString());
       	
       	//Display URL in edit text.
       	urlTxt = (EditText) findViewById(R.id.theTxt);
       	urlTxt.setText(url.toString());
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
