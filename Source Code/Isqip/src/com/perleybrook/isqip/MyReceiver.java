package com.perleybrook.isqip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Log.d("boot completed", "call received!");
		Toast.makeText(arg0, "Broadcast received!", Toast.LENGTH_LONG).show();
	}

}
