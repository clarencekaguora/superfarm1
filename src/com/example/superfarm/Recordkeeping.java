package com.example.superfarm;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Recordkeeping extends Activity {

EditText productName,farmCode,budgetCost,productMonth;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recordkeeping);
		
		productName=(EditText) findViewById(R.id.txtproductname);
		farmCode=(EditText) findViewById(R.id.txtfarmcode);
		budgetCost=(EditText) findViewById(R.id.txtbudgetcost);
		productMonth=(EditText) findViewById(R.id.txtmonth);
		
		//if you want the  app to display your report/data b4 you start
		SQLiteHandler h=new SQLiteHandler(this);
		String res=h.getData("56565");//here 56565 ..means you are passing a code static code if don't have time to create a UI for a search form.
		Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
		
	}
	
	//button click
	public void Save(View v)
	{
		String product=productName.getText().toString();
		String f_code=farmCode.getText().toString();
		String b_cost=budgetCost.getText().toString();
		String p_month=productMonth.getText().toString();
		//SQLite DB
		SQLiteHandler h=new SQLiteHandler(this);
		h.SaveData(product, f_code, b_cost, p_month);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recordkeeping, menu);
		return true;
	}

}
