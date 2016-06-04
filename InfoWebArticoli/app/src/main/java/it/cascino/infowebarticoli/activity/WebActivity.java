package it.cascino.infowebarticoli.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

import it.cascino.infowebarticoli.R;
import it.cascino.infowebarticoli.model.Articoli;
import it.cascino.infowebarticoli.model.Barcode;
import it.cascino.infowebarticoli.model.ClientWSRest;

public class WebActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);

		Intent intentWebActivity = getIntent();
		if(intentWebActivity != null){
			String utente = intentWebActivity.getStringExtra("utente");
			String codiceArticolo = intentWebActivity.getStringExtra("codArt");
			String codiceBarre = intentWebActivity.getStringExtra("codBar");
			WebView webView = (WebView)findViewById(R.id.webview);
			WebSettings webSettings = webView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			webView.loadUrl("http://10.0.21.32/Cascino-web/faces/mostraInfoArticolo.xhtml?codArt="+codiceArticolo);

			ClientWSRest clientWSRest = new ClientWSRest();
			try{
				// controllare barcode sia massino 13
				String response = clientWSRest.run("http://10.0.21.174:8080/WsRestDb/wsrestdb/bcodeserv/8006023219643");
				Gson gSon = new Gson();
				Type listType = new TypeToken<ArrayList<Barcode>>(){}.getType();
				List<Barcode> articoliLsDaSalv = gSon.fromJson(response, listType);
				return;
			}catch(IOException e){
				e.printStackTrace();
			}
		}

	}
}
