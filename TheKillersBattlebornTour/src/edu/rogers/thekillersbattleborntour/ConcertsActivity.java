package edu.rogers.thekillersbattleborntour;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class ConcertsActivity extends Activity
{
	
	//don't have to worry about compatibility problems if I change the name when marked private
	private GoogleMap mMap;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_concerts);
		
/* 
 * Fragment is closely tied to the Activity it is in, and can not be used apart from one.  Though
 * Fragment defines its own lifecycle, that lifecycle is dependent on its
 * activity: if the activity is stopped, no fragments inside of it can be
 * started; when the activity is destroyed, all fragments will be destroyed.
 */

		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		
		mMap.addMarker(new MarkerOptions()
        .position(new LatLng(38.826825,-77.309622))
        .title("The Killers, December 18, 2012"));
		
		
	}
}

//Markers should autoupdate as new concerts are performed.
//Markers should pull up setlist and all relevant YouTube videos
//Turn markers on and off by criteria
//custom markers for each tour
//date
//start time
//festival
//process JSON file
