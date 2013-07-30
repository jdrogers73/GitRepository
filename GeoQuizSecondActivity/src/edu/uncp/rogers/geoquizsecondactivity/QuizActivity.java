package edu.uncp.rogers.geoquizsecondactivity;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import edu.uncp.rogers.geoquizsecondactivity.R;

public class QuizActivity extends Activity 
{
	//user answers "true" by using this button
	private Button mTrueButton;
	
	//user answers "false" by using this button
	private Button mFalseButton;
	
	//user generates next question by using this button
	private Button mNextButton;
	
	//user can go to the Cheat screen using this button
	private Button mCheatButton;
	
	//used to display the question
	private TextView mQuestionTextView;
	
	//version used to compile app
	private TextView mVersion;
	
	//Will identify the activity in the system log 
	private static final String TAG = "QuizActivity";
	
	//used to store an extra value in a Bundle
	private static final String KEY_INDEX = "index";
	
	//After user sees the answer by using the cheat feature, the user is labeled a cheater;
	//This string will be used as a key to preserve the cheater status on device rotation by saving the
	//cheater status to the savedInstanceState object. 
	private final String KEY_IS_CHEATER = "edu.rogers.geoquizsecondactivity.key_is_cheater";
	
	//stores true is the user cheated on the question or false otherwise.
	private static boolean mIsCheater = false;
	
	//creates T/F questions and the answers; uses the TrueFalse class
	private TrueFalse[] mQuestionBank = new TrueFalse[]
	{
			new TrueFalse(R.string.question_oceans, true),
			new TrueFalse(R.string.question_mideast, false),
			new TrueFalse(R.string.question_africa, false),
			new TrueFalse(R.string.question_americas, true),
			new TrueFalse(R.string.question_asia, true),
	};
	
	//questions are saved in an array; this variable saves the index of the current question
	private int mCurrentIndex = 0;
	
	
	@TargetApi(11)
	@Override
	//override onCreate
	/*OnCreate - will create the user interface defined in activity_quiz
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * 
	 * Bundle savedInstanceState - the state of the activity before onDestroy() is called
	 */
	protected void onCreate(Bundle savedInstanceState) 
    {
        //call to the Activity class to create the View Hierarchy for this activity
		super.onCreate(savedInstanceState);
		
		//note the current progress of the program in the Log at level Debug
        Log.d(TAG, "onCreate() called");
        
        //Inflate the activity_quiz layout
        setContentView(R.layout.activity_quiz);
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2)
        {
        	ActionBar actionBar = getActionBar();
        	actionBar.setSubtitle("Bodies of Water");
        }
        //set reference to the TextView object
        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        
        mVersion = (TextView)findViewById(R.id.textView_version);
        mVersion.setText("Android API Level " + Build.VERSION.SDK_INT);
        mVersion.setPadding(0, 15, 0, 15);
        mVersion.setTextColor(0xff888888);
        
        
        //set reference to the button that will display the word True
        mTrueButton = (Button)findViewById(R.id.true_button);
        
        //setup button to respond to click
        mTrueButton.setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick (View v)
        	{
        		//Call the check answer method to compare the users click to the answer stored in the
        		//question bank array
        		//Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        		checkAnswer(true);
        	}
        });
        
        //set reference to the false button; Android will look for a child view in the View tree bearing the given ID.
        //If the view is not found, null will be returned.
        //Android then returns the View and the View object is then converted into a Button object
        mFalseButton = (Button)findViewById(R.id.false_button);
        
      //setup button to respond to click
        mFalseButton.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View v)
        	{
        		//Call the check answer method to compare the users click to the answer stored in the
        		//question bank array
        		//Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        		checkAnswer(false);
        	}
        });
        
        mNextButton = (Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View v)
        	{
        		//calculate the index of the question to be displayed
        		mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
        		//reset mIsCheater since cheating status exists for only the question cheated
        		mIsCheater = false;
        		//retrieve the latest question
        		updateQuestion();
        	}
        });
        
        mCheatButton=(Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() 
        {	
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(QuizActivity.this, CheatActivity.class);
				boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
				i.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE, answerIsTrue);
				//startActivity(i);
				startActivityForResult(i,0);
			}
		});
        
        if(savedInstanceState != null)
        {
        	mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);
        	//mIsCheater = savedInstanceState.getBoolean(KEY_IS_CHEATER);
        }
        
        updateQuestion();
    }
	
	private void updateQuestion()
	{
		//Log.d(TAG,"Updating question text for question #" + mCurrentIndex, new Exception());
		
		//get the index of the current question
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		
		//display the question on the screen by updating the TextView object
		mQuestionTextView.setText(question);
	}
	
	private void checkAnswer(boolean userPressedTrue)
	{
		
		//get answer to current question
		boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
		
		//R file ID of string matching outcome of answer
		int messageResID = 0;
		
		//if user cheated, display cheating message
		if(mIsCheater)
		{
			messageResID = R.string.judgment_toast;
		}
		//if user guessed correctly print correct to screen; else print false
		else
		{
			if (userPressedTrue == answerIsTrue)
			{
				messageResID = R.string.correct_toast;
			}
			else
			{
				messageResID = R.string.incorrect_toast;
			}
		}
		
		//create the toast and show it.
		Toast.makeText(this, messageResID, Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if (data == null)
			return;
		mIsCheater = data.getBooleanExtra(CheatActivity.EXTRA_ANSWER_SHOWN, false);
	}
    
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
    	super.onSaveInstanceState(savedInstanceState);
    	Log.i(TAG,"onSaveInstanceState");
    	savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    	//savedInstanceState.putBoolean(KEY_IS_CHEATER, mIsCheater);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }
}
