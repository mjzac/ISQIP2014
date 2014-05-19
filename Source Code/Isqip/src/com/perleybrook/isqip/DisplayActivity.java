package com.perleybrook.isqip;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class DisplayActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_layout);
		String value  = getIntent().getStringExtra("passedValue");
		Toast.makeText(DisplayActivity.this, value, Toast.LENGTH_LONG).show();
	}

}
