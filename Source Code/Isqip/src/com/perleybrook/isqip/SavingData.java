package com.perleybrook.isqip;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SavingData extends Activity implements OnClickListener{

	EditText input;
	Button saveButton, loadDataButton;
	SharedPreferences manager;
	static String filename = "mySavedData";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.saving_data_layout);
		saveButton = (Button) findViewById(R.id.saveDataButton);
		loadDataButton = (Button) findViewById(R.id.loadDataButton);
		input =  (EditText) findViewById(R.id.textToBeSaved);
		saveButton.setOnClickListener(this);
		loadDataButton.setOnClickListener(this);
		manager = getSharedPreferences(filename, 0);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.saveDataButton:
			String text = input.getText().toString();
			Editor editor = manager.edit();
			editor.putString("savedData", text);
			editor.commit();
			break;
		case R.id.loadDataButton:
			String data = manager.getString("savedData", "default value!");
			Toast.makeText(SavingData.this, data, Toast.LENGTH_LONG).show();
			break;
		}
		
	}

}
