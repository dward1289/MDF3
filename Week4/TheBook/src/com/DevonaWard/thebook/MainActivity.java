package com.DevonaWard.thebook;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {

	Context mContext;
	WebView webView;
	String transferInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		webView = (WebView) findViewById(R.id.webview);
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		//HTML file with JavaScript included.
		webView.loadUrl("file:///android_asset/theJSFile.html");
		webView.addJavascriptInterface(new theInterface(this), "MyAndroid");
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//Web interface class
	public class theInterface {
	    
		//Interface context
	    theInterface(Context c) {
	        mContext = c;
	    }

	   //Javascript function
	    @JavascriptInterface
	public void receiveJSValues(String info) {
		//Logs values from text views in HTML
		  Log.i("Received Value from JS: " , info);
		  transferInfo = info;
		  theLaunch();

		}
	}
	
	public void theLaunch(){
		Intent billIntent = new Intent(this, MadGeekBrowser.class);
		  billIntent.putExtra("theInfo",transferInfo);
		  startActivity(billIntent);
	}
}
