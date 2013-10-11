/*
 * Project	PictureThis
 * 
 * Package	com.DevonaWard.picturethis
 * 
 * @author Devona Ward
 * 
 * Date: Oct 10, 2013
 */
package com.DevonaWard.picturethis;




import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends Activity {

	private static final int PHOTO_CODE = 100;
	
	Bitmap photo;
	String pictureName;
	
	
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
            photo = (Bitmap) data.getExtras().get("data");            
            ImageView iv = (ImageView)findViewById(R.id.imageView);
            iv.setImageBitmap(photo);     
		}
	}
	
	//Saves photo and photo name, displays notification to notify user of the saved photo
	public void saveButton(View view){
		
		EditText picTxt = (EditText)findViewById(R.id.picName);
		pictureName = picTxt.getText().toString();
		
		MediaStore.Images.Media.insertImage(getContentResolver(), photo, pictureName , "PictureThis");

		//prepare intent which is triggered if the notification is selected
		Intent intent = new Intent(this, Notification.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

		//Notification sound
		Uri theSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		
		//Vibration pattern found at: http://stackoverflow.com/questions/12114917/notification-setfullscreenactivity
		long[] vibration = { 0, 500, 250, 500 };
		
		// build notification
		Notification notification  = new Notification.Builder(this)
		
		        .setContentTitle("PictureThis")
		        .setContentText("Your photo "+pictureName+" has been saved.")
		        .setSmallIcon(R.drawable.ic_launcher)
		        .setContentIntent(pendingIntent)
		        .setSound(theSound)
		        .setVibrate(vibration)
		        .setAutoCancel(true)
		        .build();
		    
		  
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		//Display notification
		notificationManager.notify(0, notification);
		
		//Refreshes app
		finish();
		startActivity(getIntent());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
