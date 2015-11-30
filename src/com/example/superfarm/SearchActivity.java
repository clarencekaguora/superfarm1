package com.example.superfarm;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends Activity {
//This Activity is for searching by farm code
	EditText searchbycode;
	TextView tvresults;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		//find the edit text
		searchbycode=(EditText) findViewById(R.id.searchbycode);
		tvresults=(TextView) findViewById(R.id.txtresults);
		
	}
	//Search button click
	public void Search(View v)
	{
		//get text
		String f_code=searchbycode.getText().toString();
		//here we pass the entered farm code to SQLite Handler
		SQLiteHandler h=new SQLiteHandler(this);
		String res=h.getData(f_code);
		//display Result in a Toast
		//Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
		//display Results in a TextView
		tvresults.setText(res);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

}
