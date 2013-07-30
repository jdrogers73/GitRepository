package edu.rogers.thekillersbattleborntour;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	private Button mConcertsButton;
	private Button mTwitterButton;
	private Button mVideosButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		mConcertsButton = (Button) findViewById(R.id.button_map);
		mConcertsButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(MainActivity.this, ConcertsActivity.class));
			}
		});
		
		mTwitterButton = (Button) findViewById(R.id.button_twitter);
		mTwitterButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(MainActivity.this, TwitterActivity.class));
			}
		});
		
		mVideosButton = (Button) findViewById(R.id.button_videos);
		mVideosButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(MainActivity.this, VideoListActivity.class));
			}
		});
		
	}
	
	public void onClick(View view)
	{
		startActivity(new Intent("android.intent.action.VideosActivity"));
	}
}
