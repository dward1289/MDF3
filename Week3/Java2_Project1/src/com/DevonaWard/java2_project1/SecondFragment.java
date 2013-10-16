package com.DevonaWard.java2_project1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondFragment extends Fragment {
Bundle data;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		
		LinearLayout view = (LinearLayout)inflater.inflate(R.layout.second_activity, container,false);
	
		//Kobe Info
		TextView kTxt = (TextView) view.findViewById(R.id.kobeTxt);
		String kName = getResources().getString(R.string.kname);
		String kTeam = getResources().getString(R.string.kteam);
		String kMVP = getResources().getString(R.string.kmvp);
		
		kTxt.setText(kName +"\n"+ kTeam +"\n"+ kMVP);
		
		//Derrick Info
		TextView dTxt = (TextView) view.findViewById(R.id.derrickTxt);
		String dName = getResources().getString(R.string.dname);
		String dTeam = getResources().getString(R.string.dteam);
		String dMVP = getResources().getString(R.string.dmvp);
		
		dTxt.setText(dName +"\n"+ dTeam +"\n"+ dMVP);
		
		//Lebron Info
		TextView lTxt = (TextView) view.findViewById(R.id.lebronTxt);
		String lName = getResources().getString(R.string.lname);
		String lTeam = getResources().getString(R.string.lteam);
		String lMVP = getResources().getString(R.string.lmvp);
		
		lTxt.setText(lName +"\n"+ lTeam +"\n"+ lMVP);
	
		return view;
	};

}
