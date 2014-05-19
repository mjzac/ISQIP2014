package com.perleybrook.isqip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SourceActivity extends Activity implements OnClickListener{

	Button passData;
	EditText data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.source_activity);
		passData = (Button) findViewById(R.id.launchDisplay);
		data = (EditText) findViewById(R.id.sourceField);
		passData.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String x = data.getText().toString();
		Intent i  = new Intent(SourceActivity.this, DisplayActivity.class);
		i.putExtra("passedValue", x);
		startActivity(i);
		
	}

}
