package com.example.toolstester;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ToolTester extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tool_tester);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tool_tester, menu);
		return true;
	}

}
