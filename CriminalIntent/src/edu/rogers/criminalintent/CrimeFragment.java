package edu.rogers.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
/*
 * Crime Fragment is a controller object in this schema. Its role is to do the work of displaying and updating
 * the information displayed. It will communicate with model and view objects.
 */

public class CrimeFragment extends Fragment 
{
	//crime object
	private Crime mCrime;
	
	//field to enter a title for the crime the user is reporting
	private EditText mTitleField;
	
	/*
	 * Note that onCreate is public whereas an activity onCreate is protected. The reason for the difference
	 * is that a fragment may be called by more than one activity so it must be public. Also, notice that
	 * the layout is not being inflated.
	 * (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		mCrime = new Crime();
	}
	
	/*
	 * This method inflates the view.
	 * LayoutInflator - explicit call to the 
	 * (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, 
	 * android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.fragment_crime, parent, false);
		
		/*
		 * The Activity.FindViewById is a convenience class. The View.findViewById is not a convenience class.
		 * With a convenience class you don't have to instantiate a class to get hold of one method since 
		 * it is provided for convenience by an object you already have; couples together classes, main purpose 
		 * is to call a method from another class
		 */
		mTitleField = (EditText)v.findViewById(R.id.crime_title);
		
		/*
		 * respond to changes in text;
		 * CharSequence c - user's input
		 * start -
		 * before - 
		 * after - 
		 */
		mTitleField.addTextChangedListener(new TextWatcher()
		{
			public void onTextChanged(CharSequence c, int start, int before, int count)
			{
				mCrime.setmTitle(c.toString());
			}
			
			public void beforeTextChanged(CharSequence c, int start, int count, int after)
			{
				//This space intentionally left blank
			}
			
			public void afterTextChanged(Editable c)
			{
				//This one too
			}
		});
		
		return v;
	}
	
	
}
