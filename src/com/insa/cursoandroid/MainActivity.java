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
		String 	aux 			= "";
		int[] 	enteros 		= {1,2,4};
		int 	enterosBis[]	= new int[13];
		
		enterosBis[0]=1;
		enterosBis[1]=10;
		enterosBis[2]=100;

		Integer	integer[]	= {new Integer(5),new Integer(8)};
		
		String nombres[] = {"Abel","Pedro"};
		
		aux	+="Número de elementos de cada array: " + 	NEW_LINE;
		aux	+="De enteros: " + enteros.length 		+	NEW_LINE;
		aux	+="De enterosBis: " + enterosBis.length +	NEW_LINE;
		aux	+="De integer: " + integer.length 		+	NEW_LINE;
		aux	+="De nombre: " + nombres.length 		+	NEW_LINE;
		
		
//		for(int i = 0; i<13; i++)
//		{
//			enterosBis[i] = (i*2)/3;
//		}
		
		for(int i=0;i<enteros.length;i++)
			aux	+= enteros[i] 		+ NEW_LINE;
		for(int i=0;i<enterosBis.length;i++)
			aux	+= enterosBis[i] 	+ NEW_LINE;
		for(int i=0;i<integer.length;i++)
			aux+= integer[i] 		+ NEW_LINE;
		for(int i=0;i<nombres.length;i++)
			aux	+= nombres[i] 		+ NEW_LINE;
		
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
