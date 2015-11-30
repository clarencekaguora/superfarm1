package com.example.superfarm;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    //Click Listener
    
    public void Tap(View v)
    {
    	switch(v.getId())
    	{
    		case R.id.btnFarmHub:
    			
    			//do here
    			Intent x = new Intent(this,FarmHub.class);
    			startActivity(x);
    			
    		break;
    		
    		case R.id.btnFarmBook:
    			
    			//do here
    			Intent y = new Intent(this,FarmBook.class);
    			startActivity(y);
    			
    		break;
    
    		case R.id.btnHealth:
    			//do here
    			Intent a=new Intent(this,SearchActivity.class);
    			startActivity(a);
    		break;
    	    
    		case R.id.btnBuy:
    			//do here
    			Intent z = new Intent(this,Recordkeeping.class);
    			startActivity(z);
    		break;
    		
    	    
    		case R.id.btnSell:
    			//do here
    			Intent b=new Intent(this,SmsProvider.class);
    			startActivity(b);
    		break;

    	}	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
