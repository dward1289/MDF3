package com.DevonaWard.picturethis;


import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity {

	private static final int PHOTO_CODE = 100;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		 
		
		
	}

	//Capture photo
	public void capturePicture(View view){
		Intent cameraIntent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(cameraIntent, PHOTO_CODE);
	}
	

	//Displays photo after capture has been completed
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == PHOTO_CODE) { 
            Bitmap photo = (Bitmap) data.getExtras().get("data");            
            ImageView iv = (ImageView)findViewById(R.id.imageView);
            iv.setImageBitmap(photo);     
		}
	}
	
	//Saves photo and photo name, displays notification to notify user of the saved photo
	public void saveButton(View view){
		//prepare intent which is triggered if the notification is selected
		Intent intent = new Intent(this, Notification.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

		// build notification
		Notification notification  = new Notification.Builder(this)
		        .setContentTitle("PictureThis")
		        .setContentText("Your photo has been saved.")
		        .setSmallIcon(R.drawable.ic_launcher)
		        .setContentIntent(pendingIntent)
		        .setWhen(0)
		        .setAutoCancel(true)
		        .build();
		    
		  
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		//Display notification
		notificationManager.notify(0, notification);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
