package edu.rogers.thekillersbattleborntour;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class VideoListActivity extends Activity
{
	ImageButton imageButton;
	
	public static String videoURL = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.videos_layout);
	}
	
	public void playRunaways(View view)
	{
		videoURL = "http://www.youtube.com/embed/"+"MJKLKNmy4M8"+"?autoplay=1";
		startActivity(new Intent(this, VideoPlayActivity.class));
	}

	public void playMrBrightSide(View view)
	{
		videoURL = "http://www.youtube.com/embed/"+"fvJh6EcajNc"+"?autoplay=1";
		startActivity(new Intent(this, VideoPlayActivity.class));
	}
	
	public void playWhenYouWereYoung(View view)
	{
		videoURL = "http://www.youtube.com/embed/"+"9wVCt1tVT5w"+"?autoplay=1";
		startActivity(new Intent(this, VideoPlayActivity.class));
	}
	
	public void playReadMyMind(View view)
	{
		videoURL = "http://www.youtube.com/embed/"+"qRIWQ2i6wTE"+"?autoplay=1";
		startActivity(new Intent(this, VideoPlayActivity.class));
	}
	
	public void playSamsTown(View view)
	{
		videoURL = "http://www.youtube.com/embed/"+"VlGWbH4SK38"+"?autoplay=1";
		startActivity(new Intent(this, VideoPlayActivity.class));
	}
	
	public void playFleshAndBone(View view)
	{
		videoURL = "http://www.youtube.com/embed/"+"fhr2TUgSO9U"+"?autoplay=1";
		startActivity(new Intent(this, VideoPlayActivity.class));
	}
	
	public void playShadowPlay(View view)
	{
		videoURL = "http://www.youtube.com/embed/"+"X1m5rYkWqvI"+"?autoplay=1";
		startActivity(new Intent(this, VideoPlayActivity.class));
	}
	
	public void playTranquilize(View view)
	{
		videoURL = "http://www.youtube.com/embed/"+"3WzQujfoiMg"+"?autoplay=1";
		startActivity(new Intent(this, VideoPlayActivity.class));
	}
	
	public void playSomebodyToldMe(View view)
	{
		videoURL = "http://www.youtube.com/embed/"+"xWlq7xN12N8"+"?autoplay=1";
		startActivity(new Intent(this, VideoPlayActivity.class));
	}
	
	public void playHuman(View view)
	{
		videoURL = "http://www.youtube.com/embed/"+"NtKurb-DM2A"+"?autoplay=1";
		startActivity(new Intent(this, VideoPlayActivity.class));
	}
}
