package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText	edt;
	private Button		btnNavegador;
	private Button		btnMarcar;
	private Button		btnContactos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		//Seleccionamos el Botón al iniciar la activity
		btnNavegador = (Button)findViewById(R.id.btnNavegar);
		btnMarcar = (Button)findViewById(R.id.btnMarcar);
		btnContactos = (Button)findViewById(R.id.btnContactos);
		
		edt	= (EditText)findViewById(R.id.editText1);
		
		//Declaramos un listener para manejar el boton
		btnNavegador.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) 
			{
				call_Intent(btnNavegador);
			}
		});
		
		//Declaramos un listener para manejar el boton
		btnMarcar.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) 
			{
				call_Intent(btnMarcar);
			}
		});
		
		//Declaramos un listener para manejar el boton
		btnContactos.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) 
			{
				call_Intent(btnContactos);
			}
		});
	}
	protected void call_Intent(View view)
	{
		Intent i 	= null;
		String text = edt.getText().toString();
		
		switch(view.getId())
		{
		case R.id.btnNavegar:
			
			if(!text.isEmpty())
			{
				text = "http://" + text;
				i = new Intent(Intent.ACTION_VIEW,Uri.parse(text));
				startActivityForResult(i, 1);
			}else
				{
					Toast.makeText( getBaseContext(), 
									"No Destination", 
									Toast.LENGTH_SHORT).show();
				}
			break;
		case R.id.btnMarcar:
			if(!text.isEmpty())
			{
				text = "tel:" + text;
				i = new Intent(Intent.ACTION_VIEW,Uri.parse(text));
				startActivityForResult(i, 2);
			}else
				{
					Toast.makeText( getBaseContext(), 
									"No Telephone", 
									Toast.LENGTH_SHORT).show();
				}
			break;
		case R.id.btnContactos:
			i = new Intent(	Intent.ACTION_VIEW,
							Uri.parse("content://contacts/people/"));
			startActivityForResult(i, 3);
			break;
		}
		
		
	}
	public void onActivityResult(int requestCode,int resultCode, Intent data)
	{

		if(resultCode == Activity.RESULT_CANCELED)
		{
			switch (requestCode) {
			case 1:
				Toast.makeText(	getBaseContext(), 
								"Internet Back", 
								Toast.LENGTH_SHORT).show();
				break;
			case 2:
				Toast.makeText(	getBaseContext(), 
								"Call Back", 
								Toast.LENGTH_SHORT).show();
				break;
			default:
				Toast.makeText(	getBaseContext(), 
								"Contact Guide Back", 
								Toast.LENGTH_SHORT).show();
				break;
			}
			edt.setText("");
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
