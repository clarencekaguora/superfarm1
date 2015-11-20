package com.example.superfarm;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class FarmHub extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_farm_hub);
		
		TextView data = (TextView) findViewById(R.id.tvwInformation);
		//Consult TextFileReader.java to read our 'sample.txt'
		TextFilesReader tf = new TextFilesReader(this);
		String response = null;
		try {
			response = tf.readTxt("sample.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//call a method to get response
		data.setText(response);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.farm_hub, menu);
		return true;
	}

}
