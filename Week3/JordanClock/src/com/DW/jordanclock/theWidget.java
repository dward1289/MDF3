package com.DW.jordanclock;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;


public class theWidget extends AppWidgetProvider{
	 
	//Allows the widget to uodate
    public void onReceive(Context context, Intent intent)
    {
    String act=intent.getAction();
    if(AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(act))
    {
RemoteViews myView =new RemoteViews(context.getPackageName(), R.layout.thewidget);
                          
        AppWidgetManager.getInstance(context).updateAppWidget(intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS), myView);
    }
  }
    
}    


