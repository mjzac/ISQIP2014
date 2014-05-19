package com.perleybrook.isqip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceLauncher extends Activity implements OnClickListener{

	Button startButton, stopButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_layout);
		startButton = (Button) findViewById(R.id.startButton);
		stopButton = (Button) findViewById(R.id.stopButton);
		startButton.setOnClickListener(this);
		stopButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i;
		switch(arg0.getId()){
			case R.id.startButton:
				i = new Intent(ServiceLauncher.this,MyService.class);
				startService(i);
				
				break;
			
			case R.id.stopButton:
				i = new Intent(ServiceLauncher.this, MyService.class);
				stopService(i);
				
				break;
		}
		
	}

}
