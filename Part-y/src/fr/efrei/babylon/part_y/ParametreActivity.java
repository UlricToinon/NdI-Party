package fr.efrei.babylon.part_y;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ParametreActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parametre);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.parametre, menu);
		return true;
	}

}
