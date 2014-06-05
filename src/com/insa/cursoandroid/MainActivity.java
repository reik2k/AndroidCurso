package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
	EditText 	txt;
	Button 		btn;
	String		texto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 

		txt = (EditText)findViewById(R.id.texto);
		btn	= (Button)findViewById(R.id.btnIr);
		
		btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Bundle bundle 	= new Bundle();
				Intent i 		= new Intent( 	MainActivity.this,
												Pantalla2Activity.class);
				
				texto = txt.getText().toString();

				if (texto.isEmpty())
				{
					texto = "Texto inicial.";

				}
				
				bundle.putString( "param1", "Pantalla2: "+ texto);
				i.putExtras(bundle);
				startActivityForResult(i,0);
			}
		});
	}
	@Override
	protected void onActivityResult(int requestCode,int resultCode, Intent i)
	{
		super.onActivityResult(requestCode, resultCode, i);
		if(requestCode == 0 && resultCode == RESULT_OK)
		{
			texto = i.getExtras().getString("param2").toString();
			
			txt.setText("Datos devueltos: " + texto);
		}
		
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
