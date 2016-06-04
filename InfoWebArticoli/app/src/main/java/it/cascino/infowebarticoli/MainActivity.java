package it.cascino.infowebarticoli;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ExecutionException;

import it.cascino.infowebarticoli.activity.WebActivity;

public class MainActivity extends Activity{

	private String SHARED_PREF = "shared_pref_infoweb";
	private SharedPreferences sharedPreferences;

	private EditText utenteEditText;
	private EditText codiceArticoloEditText;
	private EditText codiceBarreEditText;

	private String utente = "";
	private String codiceArticolo = "";
	private String codiceBarre = "";

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sharedPreferences = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
		updatePreferencesData();

		utenteEditText = (EditText)findViewById(R.id.utente);
		utenteEditText.setText(utente);
		utenteEditText.addTextChangedListener(new TextWatcher(){
			public void afterTextChanged(Editable s){
				savePreferencesData();
			}

			public void beforeTextChanged(CharSequence s, int start, int count, int after){
			}

			public void onTextChanged(CharSequence s, int start, int before, int count){
			}
		});

		codiceArticoloEditText = (EditText)findViewById(R.id.codiceArticolo);
		codiceArticoloEditText.setText(codiceArticolo);
		codiceArticoloEditText.addTextChangedListener(new TextWatcher(){
			public void afterTextChanged(Editable s){
				codiceArticolo = s.toString();
			}

			public void beforeTextChanged(CharSequence s, int start, int count, int after){
			}

			public void onTextChanged(CharSequence s, int start, int before, int count){
			}
		});

		codiceBarreEditText = (EditText)findViewById(R.id.codiceBarre);
		codiceBarreEditText.setText(codiceBarre);
		codiceBarreEditText.addTextChangedListener(new TextWatcher(){
			public void afterTextChanged(Editable s){
				codiceBarre = StringUtils.upperCase(s.toString());
			}

			public void beforeTextChanged(CharSequence s, int start, int count, int after){
			}

			public void onTextChanged(CharSequence s, int start, int before, int count){
			}
		});

		Button apriUrlButton = (Button)findViewById(R.id.apriUrlButton);
		apriUrlButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intentWebActivity = new Intent(getApplicationContext(), WebActivity.class);
				intentWebActivity.putExtra("utente", utente);
				intentWebActivity.putExtra("codArt", codiceArticolo);
				intentWebActivity.putExtra("codBar", codiceBarre);
				startActivity(intentWebActivity);
			}
		});
	}

	public void savePreferencesData(){
		SharedPreferences.Editor editor = sharedPreferences.edit();
		if(utenteEditText != null){
			editor.putString("utente", utenteEditText.getText().toString());
		}
		editor.apply();
		updatePreferencesData();
	}

	private void updatePreferencesData(){
		if(sharedPreferences != null){
			utente = sharedPreferences.getString("utente", "nd");
		}
	}

}
