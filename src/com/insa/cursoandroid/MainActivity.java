package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity {
	static	TextView		txt;
	static	String			result 		= new String();
	static  final String 	NEW_LINE 	= new String("\n");
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 

		//Decalramos el TEXTVIEW para sacar los resultados del ejemplo.
		txt = (TextView)findViewById(R.id.txtResult);
		
		result = "EJEMPLO1: ARRAYS" + NEW_LINE;
		result += "-----------------------------" + NEW_LINE;
		
		result += setExample1();
		
		txt.setText(result);
	}
	
	private String setExample1()
	{
		String aux 	= "";
		
		
		return aux;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true; 
		}
		return super.onOptionsItemSelected(item);
	}

}
