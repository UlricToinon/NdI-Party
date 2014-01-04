package fr.efrei.babylon.part_y;

import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.sax.TextElementListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreerActivity extends Activity {
	
	private static final String TAG_NBPERS = "nbpers";
	private static final String TAG_AGEMOY = "agemoy";
	private static final String TAG_THEME = "theme";
	private static final String URL = "theme";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_creer);
		
		EditText nbPers = (EditText) findViewById(R.id.valueNbPersonne);
		EditText ageMoy = (EditText) findViewById(R.id.valueAgeMoy);
		TextView theme = (TextView) findViewById(R.id.valueTheme);
		Button buttonTheme = (Button) findViewById(R.id.Theme);
		
		buttonTheme.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.w("TEST", "TEST");
				Intent intent = new Intent(CreerActivity.this, ThemeActivity.class);
				startActivity(intent);

			}
		});
		
		 final HashMap<String, String> params = new HashMap<String, String>();
	        params.put(TAG_NBPERS, nbPers.getText().toString());
	        params.put(TAG_AGEMOY, ageMoy.getText().toString());
	        params.put(TAG_THEME, theme.getText().toString());
		
	}

	

}
