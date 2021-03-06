package rogers.killersfanapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity 
{

	private Button mConcertMapButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		mConcertMapButton = (Button) findViewById(R.id.concertMapButton);
		mConcertMapButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//Intent intent = new Intent(MainActivity.class, ConcertMapActivity.class);
		//	this.startActivity(intent);
				startActivity(new Intent("android.intent.action.ConcertMapActivity"));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
