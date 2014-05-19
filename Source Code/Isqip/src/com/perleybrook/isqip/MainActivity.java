package com.perleybrook.isqip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText name,password;
	Button button,button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_custom_layout);
		name = (EditText) findViewById(R.id.editText1);
		password = (EditText) findViewById(R.id.editText2);
		button2  = (Button) findViewById(R.id.loginButton);
		
		//button.setOnClickListener(this);
		
		button2.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.loginButton:
			Log.d("button1", "clicked");
			String input = name.getText().toString();
			if (!(input.equals("admin") && password.getText().toString().equals("qwerty"))) {
				Toast.makeText(getApplicationContext(), "invalid credentials", Toast.LENGTH_LONG)
						.show();
			}else{
				Intent launcher = new Intent(MainActivity.this,SecondActivity.class);
				startActivity(launcher);
			}
			break;
		case R.id.button2:
			Toast.makeText(getApplicationContext(), "button 2 clicked", Toast.LENGTH_LONG)
			.show();
			Intent launcher = new Intent(MainActivity.this,SecondActivity.class);
			startActivity(launcher);
			break;
			
		}
		
	}

}
