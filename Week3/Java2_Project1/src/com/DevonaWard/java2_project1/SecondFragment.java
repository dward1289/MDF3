package com.DevonaWard.java2_project1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class SecondFragment extends Fragment {
Bundle data;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		
		LinearLayout view = (LinearLayout)inflater.inflate(R.layout.second_activity, container,false);
	
		return view;
	};

}
