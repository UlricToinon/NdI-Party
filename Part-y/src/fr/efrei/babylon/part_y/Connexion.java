package fr.efrei.babylon.part_y;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.apache.http.HttpResponse;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Connexion extends Activity implements View.OnClickListener {

	private static final String TAG_LOGIN = "user";
	private static final String TAG_PASSWORD = "pass";
	private static final String URL = "http://part-y.plugus.fr/web/app.php/api/login";
	
	 EditText login;
     EditText mdp;
    
    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	if( Build.VERSION.SDK_INT >= 9){
    	    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    	    StrictMode.setThreadPolicy(policy); 
    	}
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        
        Button connexion = (Button)findViewById(R.id.Connexion);
        
        login = (EditText)findViewById(R.id.Login);
        mdp = (EditText)findViewById(R.id.MotDePasse);
        
        if (login.getText().length() == 0){
        	Toast.makeText(this, "Veuillez entrer un login" , Toast.LENGTH_LONG);
        	return;
        }
        
        // Appelle de l'URL
        
        if (mdp.getText().length() == 0){
        	Toast.makeText(this, "Veuille entrer un mot de passe" , Toast.LENGTH_LONG);
        	return;
        }
        
        final HashMap<String, String> params = new HashMap<String, String>();
        params.put(TAG_LOGIN, login.getText().toString());
        params.put(TAG_PASSWORD, mdp.getText().toString());
        
        connexion.setOnClickListener(this);
        
   }
    
	@Override
	public void onClick(View v) {
		Con(v);
		
	}
	
    public void Con(View v){
    	try {
            
            //sEditText connref = (EditText)findViewById(R.id.ConnRef);

			Http requete = new Http(URL + "?user=" + login.getText().toString() + "&pass=" + mdp.getText().toString());
			HttpResponse httpResponse = requete.get();
			String statut = "" + httpResponse.getStatusLine().getStatusCode();
			Log.w("STATUTS HTTP", statut );
			
			if(httpResponse.getStatusLine().getStatusCode() == 200){
					Intent intent = new Intent(this, MenuActivity.class);
					startActivity(intent);
			}
			
		} catch (MalformedURLException e) {
			//Toast.makeText(this, "Un problème est survenu", Toast.LENGTH_LONG);
			Log.w("Erreur URL", "URL Mal formé");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

    
}
