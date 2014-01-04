package fr.efrei.babylon.part_y;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class CalendrierActivity extends Activity {

	private final static String URL = "http://part-y.plugus.fr/web/app.php/api/recipes";
	private final static String TAG_DASH = "dashboard";
	private final static String TAG_TITRE = "name";
	private final static String TAG_DATE = "date";
	private final static String TAG_DESC = "description";
	private final static String TAG_PRIX = "prix";

	private String image = "";
	private List<Dashboard> dashboards = new ArrayList<Dashboard>();
	private ListView dsListe;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendrier);
		
		dsListe = (ListView)findViewById(R.id.dsList);
		DashAdaptater adapter = new DashAdaptater(this, dashboards);
		
		dsListe.setAdapter(adapter);

	}


	private void remplirDashboard(){

		JSONArray themes = null;
		ParseJSON jParser = new ParseJSON();


		JSONObject json = jParser.getJSONFromUrl(URL);

		try {
			themes = json.getJSONArray(TAG_DASH);
			String[] tabTheme = null;

			for (int i = 0; i < themes.length(); ++i){

				JSONObject o = themes.getJSONObject(i);

				String titre = o.getString(TAG_DATE);
				//String date = o.getString(TAG_DESC);
				String description = o.getString(TAG_DESC);
				//String prix = o.getString(TAG_PRIX);
				
				dashboards.add(new Dashboard(titre, description));
			}
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
