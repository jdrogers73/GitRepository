package edu.rogers.thekillersbattleborntour;

import java.io.File;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

@SuppressLint("SetJavaScriptEnabled")
public class VideoPlayActivity extends Activity 
{

    RelativeLayout relative;
    VideoView video;
    YouTubePlayer player;

    WebView youtubeArea;

    WebViewClient youtubePlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play_layout);
        relative = (RelativeLayout) findViewById(R.id.web);
        player = new YouTubePlayer();
        youtubePlayer = new WebViewClient();
        youtubeArea = (WebView) findViewById(R.id.webView1);

        youtubeArea.setWebChromeClient(player);
        youtubeArea.setWebViewClient(youtubePlayer);
        youtubeArea.getSettings().setJavaScriptEnabled(true);
        youtubeArea.getSettings().setDomStorageEnabled(true);

        youtubeArea.loadUrl(VideoListActivity.videoURL);
    }

    class YouTubePlayer extends WebChromeClient 
    {
    	@Override
        public void onShowCustomView(View view, CustomViewCallback callback) 
        {
            // TODO Auto-generated method stub
            super.onShowCustomView(view, callback);
            if (view instanceof FrameLayout) 
            {
                FrameLayout frame = (FrameLayout) view;
                if (frame.getFocusedChild() instanceof VideoView) 
                {
                    youtubeArea.setVisibility(View.GONE);
                    video = (VideoView) frame.getFocusedChild();
                    FrameLayout.LayoutParams par = new FrameLayout.LayoutParams(
                            LayoutParams.MATCH_PARENT,
                            LayoutParams.MATCH_PARENT);
                    par.gravity = Gravity.CENTER_HORIZONTAL;
                    video.setLayoutParams(par);
                    frame.removeView(video);
                    relative.addView(video);
                    
                    video.setOnCompletionListener(new OnCompletionListener() 
                    {
                    	@Override
                        public void onCompletion(MediaPlayer mp) 
                        {
                            Toast.makeText(VideoPlayActivity.this,
                                    "Video completed", Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                    video.setOnErrorListener(new OnErrorListener() 
                    {
                    	@Override
                        public boolean onError(MediaPlayer mp, int what, int extra) 
                    	{
                            Toast.makeText(VideoPlayActivity.this,
                                    "Encountered some error", Toast.LENGTH_LONG)
                                    .show();
                            return true;
                        }
                    });
                    video.start();
                }
            }
        }
    }
    
    @Override
    protected void onDestroy() 
    {
        android.os.Process.killProcess(android.os.Process.myPid());
        Editor editor = getSharedPreferences("clear_cache", Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
        super.onDestroy();
    }

    public static boolean deleteDir(File dir) 
    {
        if (dir != null && dir.isDirectory()) 
        {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) 
            {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) 
                {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}