package com.example.superfarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class SQLiteHandler extends SQLiteOpenHelper {

	
	
	
protected Context context;
  public SQLiteHandler(final Context connection) {
		//create database and set version
  super(connection, "recordskeeping", null, 1);
  this.context = connection;
 
 }
 //create table
  String table ="details";
 @Override
 public void onCreate(SQLiteDatabase db) {
	 	db.execSQL("CREATE TABLE IF NOT EXISTS " +
    table +" (productName VARCHAR,farmCode INT(5),budgetCost INT(6), productMonth TEXT(8));");
	 	
	 	//if you want maybe to create another table you just write .."db.execSQL(...)"
 }
 
 public void SaveData(String product,String code,String cost,String month)
 {
	 SQLiteDatabase db =this.getWritableDatabase();
	 ContentValues col =new ContentValues();
	 col.put("productName", product); //key means the columns of that database..and value is the strings you've declared above
	 col.put("farmCode", code);
	 col.put("budgetCost", cost);
	 col.put("productMonth", month);
	 
	 long res =db.insert(table, null, col);
	 if(res<1)
	 {
		 Toast.makeText(context, "Error boy!", Toast.LENGTH_LONG).show();
	 }
	 else if(res>=1)
	 {
		 Toast.makeText(context, "success!", Toast.LENGTH_LONG).show();
	 }
	 else
	 {
		 Toast.makeText(context, "Something went wrong!", Toast.LENGTH_LONG).show();
	 }
		 
 }
 
 //not required for now
 @Override
 public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
   //db.execSQL("DROP TABLE IF EXIST o");
//  onCreate(db);
 }

 
 

 //this method retrieves data based on ID provided. takes in one parameter id
 public String getData(String code) {
     //allow database to be read
	 SQLiteDatabase db = this.getReadableDatabase();

	 //use select query to search data in table - save found record in a cursor
	 final Cursor c = db.rawQuery("SELECT productName, farmCode, budgetCost,productMonth FROM " +
	 			table +
	 			" where farmCode =  '"+code+"'", null);
	 
	 //count number of rows returned by the cursor
	 int count = c.getCount();
	 
	 //if its zero, no records found
    if(count == 0){
 	
 		Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();
 		c.close();
 	}
    //else retrieve the data from their columns
     String result = "";
     
     int pname = c.getColumnIndex("productName");
     int c_cost = c.getColumnIndex("budgetCost");
     int m_month = c.getColumnIndex("productMonth");
     //converts column indexes to Strings - as it loops all records
     for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
         result = result + "productName:"+c.getString(pname) + "budgetCost: " + c.getString(c_cost) + "productMonth: " + c.getString(m_month) + "\n";
  
     }
    //return a String with results
     return result;
    
 
}
 

}
 
