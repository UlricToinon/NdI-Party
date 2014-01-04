package fr.efrei.babylon.part_y;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		Button creer = (Button) findViewById(R.id.Creer);
		Button calendrier = (Button) findViewById(R.id.Calendrier);
		Button gerer = (Button) findViewById(R.id.Gerer);
		Button parametre = (Button) findViewById(R.id.Parametre);

		creer.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.w("TEST", "TEST");
				Intent intent = new Intent(MenuActivity.this, CreerActivity.class);
				startActivity(intent);

			}
		});

		calendrier.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuActivity.this, CalendrierActivity.class);
				startActivity(intent);

			}
		});
		
		gerer.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuActivity.this, GererActivity.class);
				startActivity(intent);

			}
		});
		
		parametre.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuActivity.this, ParametreActivity.class);
				startActivity(intent);

			}
		});
	}

}
