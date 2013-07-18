//declares the package to which this class belongs; important for enforcing packagePrivate 
//and protected permissions
package edu.rogers.mapv2;

//In order to access or extend a class, the class must be listed here (except java.lang.Object)
//Whitespace: every character is part of a statement or a structure and is allowed or not based
//upon the language's rules (grammar and syntax)
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//it is not necessary in Android to have a class or function named main.
//the main designation is handled in the manifest file
//Main Activity extends Activity which means Main can access Activity's non-private fields and methods
//(states and behaviors).
//Because it is an activity, it has a life cycle managed by the OS. It contains Views but is not
//itself a view.
public class MainActivity extends Activity 
{
	//create button object
	Button mMapButton;
	
	//Override means I am creating a method with the same name and parameter list as in the parent
	//Names are case-sensitive in Java. Method names begin lowercase and use camel case for all
	//words after the first. Lowercase is not required. It is a convention as is beginning class
	//names with an uppercase letter. Class names must match the file name before ".java"
	
	/*The compiler's troubleshooting algorithm offers solutions based upon error characteristics
	 * which may or may not be a solution to the actual problem
	 * 
	 * @ is an annotation type and is used to generate a java doc. 
	 * Can override any super method provide the name and parameter list match.
	 * Will generate an error if the method does not match a parent's method signature which is 
	 * its return type, name parameter list types and order. Access Modifier does not matter.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		//super refers to any class from which this class inherits
		//onCreate is a stage in the activity life cycle and is part of the
		//visible life cycle and the entire life cycle, but not the foreground life cycle
		//The savedInstanceState is the Bundle of the last save for this activity provided
		//the activity has been saved.
		super.onCreate(savedInstanceState);
		//inflate the layout - build it on the screen based on its configuration file in the layout
		//folder which is in the res folder.
		setContentView(R.layout.activity_main);
		
		//findViewById returns a View object which must then be cast down to a Button in order to
		//access members specific to Button
		mMapButton = (Button)findViewById(R.id.button_map);
		mMapButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(MainActivity.this, MapActivity.class);
				startActivity(i);
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
