package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	TextView	txt;
	static	final String NEW_LINE = "\n"; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 

		setExample();
	}
	
	private void setExample()
	{
		String 	strScreen;
		String 	strAux;
		int		number;
		int		result;
		
		txt = (TextView)findViewById(R.id.txtResult);
		
		strAux 	= "125";
		number 	= 10;
		
		result = Integer.parseInt(strAux) + number;
		
		strScreen	=	number + result + NEW_LINE;
		strScreen	+= 	strAux + result	+ NEW_LINE;
		
		if(number + result > 130)
		{
			number ++;
		}else
		{
			number--;
		}
		
		strScreen += number;
		
		txt.setText(strScreen);
		
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
