package fr.efrei.babylon.part_y;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ThemeActivity extends Activity {
	
	private static final String URL = "";
	private static final String TAG_THEME = "themes";
	private static final String TAG_TITRE = "titre";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_theme);
		
		ListView listTheme = (ListView) findViewById(R.id.listTheme);
		
		JSONArray themes = null;
		ParseJSON jParser = new ParseJSON();
		
		
		JSONObject json = jParser.getJSONFromUrl(URL);
		
		try {
			themes = json.getJSONArray(TAG_THEME);
			String[] tabTheme = null;
			
			for (int i = 0; i < themes.length(); ++i){
				
				JSONObject o = themes.getJSONObject(i);
				
				String theme = o.getString(TAG_TITRE);
				tabTheme[i] = theme;
			}
			
			listTheme.setAdapter(new ArrayAdapter<String>(this, android.R.layout.activity_list_item,tabTheme));
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	
}
