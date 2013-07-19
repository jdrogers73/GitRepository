package edu.rogers.thekillersbattleborntour;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.os.Bundle;

public class ConcertsActivity extends Activity
{
	private GoogleMap mMap;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_concerts);
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
