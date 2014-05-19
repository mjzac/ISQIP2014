package com.perleybrook.isqip;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class JsonActivity extends Activity{
	JSONObject object;
	ProgressDialog progress;
	TextView location, temperature, condition;
	String loc, temp, con;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.json_layout);
		location = (TextView) findViewById(R.id.location);
		temperature = (TextView) findViewById(R.id.temperature);
		condition = (TextView) findViewById(R.id.condition);
		
		FetchData data = new FetchData();
		data.execute("http://google.com");
	}
	
	public class FetchData extends AsyncTask<String, Integer,String>{

		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			
			progress = new ProgressDialog(JsonActivity.this);
			progress.setMessage("loading data. . ..");
			progress.setIndeterminate(true);
			progress.setCancelable(false);
			progress.show();
			
		}

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			
			String jsonString = "[{Location:Kottayam,Temperature:28, Condition:Haze},{Location:Alleppey,Temperature:29, Condition:Sunny}]";
			try {
				JSONArray array = new JSONArray(jsonString);
				for(int i=0;i<array.length();i++){
					Log.d("Location",array.getJSONObject(i).getString("Location"));
				}
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				jsonString = "{Location:Kottayam,Temperature:28, Condition:Haze}";
				object = new JSONObject(jsonString);
				loc = object.getString("Location");
				temp = object.getString("Temperature");
				con = object.getString("Condition");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				// Make the process 5 seconds long
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			location.setText(loc);
			temperature.setText(temp);
			condition.setText(con);
			progress.dismiss();
		}

		
	}

}
