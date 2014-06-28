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
		
		//Declaramos y construimos un array 2D
		//Tiene dos elementos que son arrays como los anteriores
		String[] [] miFamilia=new String[2][];
		
		//Iniciamos el array:
		miFamilia[0]=new String[2];
		miFamilia[1]=new String[4];
		
		//Inicializamos los arrays de primera dimensión
		miFamilia[0][0]="Jesus";
		miFamilia[0][1]="Miguel";
		
		//la segunda dimensión:
		miFamilia[1][0]="Encarna";
		miFamilia[1][1]="Lola";
		miFamilia[1][2]="Manuel";
		miFamilia[1][3]="Antonio";
		
		aux += "Longitud del Array Bidimensional"	+ NEW_LINE;
		aux	+= "Grupo 1: " + miFamilia[0].length 	+ NEW_LINE;
		aux	+= "Grupo 2: " + miFamilia[1].length 	+ NEW_LINE;
		
		aux += "Mostramos sus elementos"			+ NEW_LINE
				+ "GRUPO 1" + NEW_LINE;
		for(int i = 0;i<miFamilia[0].length;i++)
		{
			aux += "Elemento[0]["+i+"]: "+miFamilia[0][i] + NEW_LINE;
		}
		
		aux += "GRUPO 2" + NEW_LINE;
		
		for(int i = 0;i<miFamilia[1].length;i++)
		{
			aux += "Elemento[1]["+i+"]: "+miFamilia[1][i] + NEW_LINE;
		}
		
		String miFam[] []=	{{"Jesus","Miguel"},
                			{"Encarna","Lola", "Manuel","Antonio"}};
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
