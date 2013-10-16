package com.DevonaWard.java2_project1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class developerInfo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.devinfo);

		//MadGeek info
		TextView theText = (TextView) findViewById(R.id.devInfoTxt);
		String theInfo = "Developer: Devona Ward \n MadGeek strives to not only be the best, but to satisfy the needs of mobile device users.";

		theText.setText(theInfo);
	}

}
