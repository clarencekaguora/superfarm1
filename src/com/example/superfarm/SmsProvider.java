package com.example.superfarm;

import com.example.superfarm.R.string;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class SmsProvider extends Activity {

TextView msg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms_provider);
		
		msg=(TextView) findViewById(R.id.tvmessages);
		Uri uri=Uri.parse("content://sms/inbox");
		Cursor c =getContentResolver().query(uri, null, ACCOUNT_SERVICE, null, null); //note when you put a null in the a/c service it fetches all your inbox. 
		if(c.getCount()<1)
		{
			Toast.makeText(this, "Inbox Empty", Toast.LENGTH_LONG).show();
		}
		else
		{
			String sms="";
			int x =c.getColumnIndex("body");
			while(c.moveToNext())
			{
				sms +="From: "+c.getString(2)+"Message: "+c.getString(x)+"\n\n";
				
			}
			msg.setText(sms);
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sms, menu);
		return true;
	}

}
