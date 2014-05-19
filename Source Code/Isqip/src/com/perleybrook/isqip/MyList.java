package com.perleybrook.isqip;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyList extends ListActivity{

	String[] names = {"MainActivity","SecondActivity","ServiceLauncher","SourceActivity","SavingData", "JsonActivity"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(MyList.this,android.R.layout.simple_list_item_1,names));
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		//Toast.makeText(getApplicationContext(), names[position], Toast.LENGTH_LONG).show();
		
		Class launcher;
		try {
			launcher = Class.forName("com.perleybrook.isqip."+names[position]);
			Intent i = new Intent(MyList.this,launcher);
			startActivity(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			Toast.makeText(getApplicationContext(), "No class named "+ names[position], Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
		
	}
}
