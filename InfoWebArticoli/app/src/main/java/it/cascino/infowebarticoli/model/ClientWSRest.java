package it.cascino.infowebarticoli.model;

import android.os.AsyncTask;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ClientWSRest{
	OkHttpClient client = new OkHttpClient();

	public String run(String url) throws IOException {
		ConnectionAsyncTask connectionAsyncTask = new ConnectionAsyncTask();
		String response = "";
		try{
			response = connectionAsyncTask.execute(url).get();
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch(ExecutionException e){
			e.printStackTrace();
		}
		return response;
	}

	private class ConnectionAsyncTask extends AsyncTask<String, Void, String>{
		@Override
		protected String doInBackground(String... params){
			Request request = new Request.Builder().url(params[0]).build();

			Response response = null;
			String risp = "";
			try{
				response = client.newCall(request).execute();
				risp = response.body().string();
			}catch(IOException e){
				e.printStackTrace();
			}
			return risp;
		}

		@Override
		protected void onPostExecute(String result){
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute(){
			super.onPreExecute();
		}

		@Override
		protected void onProgressUpdate(Void... values){
		}
	}

}