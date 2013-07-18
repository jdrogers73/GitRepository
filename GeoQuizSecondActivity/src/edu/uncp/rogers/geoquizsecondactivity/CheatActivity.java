package edu.uncp.rogers.geoquizsecondactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CheatActivity extends Activity
{
	private Button mShowAnswerButton;
	public static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true";
	public static final String EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz.answer_shown";
	private final String KEY_ANSWER_SHOWN = "com.rogers.geoquizsecondactivity.answer_shown";
	private final String KEY_ANSWER_IS_TRUE = "com.rogers.geoquizsecondactivity.answer_is_true";
	private static final String TAG = "QuizActivity";
	private boolean mAnswerIsTrue;
	private TextView mAnswerTextView;
	private boolean mShowAnswerPressed;
	
	private void setAnswerShownResult(boolean isAnswerShown)
	{
		mShowAnswerPressed = isAnswerShown;
		Intent data = new Intent();
		data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
		setResult(RESULT_OK, data);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		
		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
		//mShowAnswerPressed = savedInstanceState.getBoolean(EXTRA_ANSWER_SHOWN);
		
		mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
		
		//Chapter 5 challenge 1: I added the if/else to preserve record of Show Answer being pressed. 
		if(savedInstanceState != null)
		{
			setAnswerShownResult(true);
			
			//Preserve the displayed answer in the event of orientation change
			if (savedInstanceState.getBoolean(KEY_ANSWER_IS_TRUE))
			{
				mAnswerTextView.setText(R.string.true_button);
			}
			else
			{
				mAnswerTextView.setText(R.string.false_button);
			}
		}
		else
		{
			setAnswerShownResult(false);
		}
		
		mShowAnswerButton = (Button) findViewById(R.id.show_answer_button);
		mShowAnswerButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if(mAnswerIsTrue)
				{
					mAnswerTextView.setText(R.string.true_button);
				}
				else
				{
					mAnswerTextView.setText(R.string.false_button);
				}
				setAnswerShownResult(true);
			}
		});
	}
	
	@Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
    	super.onSaveInstanceState(savedInstanceState);
    	Log.i(TAG,"onSaveInstanceState");
    	savedInstanceState.putBoolean(KEY_ANSWER_SHOWN, mShowAnswerPressed);
    	savedInstanceState.putBoolean(KEY_ANSWER_IS_TRUE, mAnswerIsTrue);
    }
	
}