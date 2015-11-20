package com.example.superfarm;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends Activity {

	EditText editText1;
	CheckBox ckspraying,ckcropping,ckmarketing,ckplanning,ckpostmanagement;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		
		ckspraying=(CheckBox) findViewById(R.id.spraying);
		ckcropping=(CheckBox) findViewById(R.id.cropping);
		ckmarketing=(CheckBox) findViewById(R.id.marketing);
		ckplanning=(CheckBox) findViewById(R.id.planning);
		ckpostmanagement=(CheckBox) findViewById(R.id.postmanagement);
		editText1=(EditText) findViewById(R.id.editText1);
	}
	
	public void Tap2(View v)
	{
	  String selected="";	
		if(ckmarketing.isChecked())
		{
			selected+=ckmarketing.getText().toString();
		}
		
		if(ckspraying.isChecked())
		{
			selected+=ckspraying.getText().toString();
		}
		
		if(ckplanning.isChecked())
		{
			selected+=ckplanning.getText().toString();
		}
		if(ckpostmanagement.isChecked())
		{
			selected+=ckpostmanagement.getText().toString();
		}
		if(ckcropping.isChecked())
		{
			selected+=ckcropping.getText().toString();
		}
		
		String phone=editText1.getText().toString();
		
		
		SmsManager sms =SmsManager.getDefault();//this means it's deprecated.. but it's the only one available so just use it
		sms.sendTextMessage("0714424226", null, "The following were ordered:"+selected+phone, null, null);
		
	    Toast.makeText(this,"Message Sent",Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.order, menu);
		return true;
	}

}
