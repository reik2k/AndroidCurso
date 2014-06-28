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
		Integer	num1	= 	new Integer("22");
		Integer num2	= 	new Integer("100");
		int		n1		= 	num1.intValue();
		int		n2		= 	num2.intValue();
		
		txt = (TextView)findViewById(R.id.txtResult);
		
		strScreen = "La suma de num1 ("+n1+") + num2 ("+n2+") "+
					"es igual a " + (n1+n2)+NEW_LINE;
		
		strScreen += "Como la suma es: "+(n1+n2);
		
		if(n1+n2>130)
		{
			strScreen += " y es mayor a 130";
			n1++;
		}else
		{
			strScreen += " y es menor a 130";
			n1--;
		}
		
		strScreen += ", entonces n1 = "+n1;
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
