package edu.rogers.criminalintent;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

/*
 * CrimeActivity will subclass FragmentActivity; FragmentActivity is a class from the support library.
 * FragmentActivity subclasses Activity and in order to add fragment support. Before Honeycomb, 
 * Activities did not know how to manage fragments, so this support class was created to add backward 
 * compatibility to fragments.
 */
public class CrimeActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crime);
	}

}
