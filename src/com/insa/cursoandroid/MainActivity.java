package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText			edt;
	private Button				btn;
	private	int					obj;
	private	CharSequence[]		list	=	{"Soltero","Casado","Otro"};
	private	String				aux;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		
		
		
		//Seleccionamos el Botón al iniciar la activity
		btn = (Button)findViewById(R.id.btnAction);
		edt	= (EditText)findViewById(R.id.edtResult);
		
		edt.setText("");
		//Declaramos un listener para manejar el boton
		btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) 
			{
				showDialog(0);
			}
		});
	}
	protected Dialog onCreateDialog(int id)
	{
		switch (id) 
		{
		case 0:
			return new AlertDialog.Builder(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("Selecciona un Item")
			.setPositiveButton("Accept", new DialogInterface.OnClickListener() 
			{
				public void onClick(DialogInterface dialog, int which) 
				{
					edt.setText(aux);
					dialog.cancel();
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() 
			{
				
				public void onClick(DialogInterface dialog, int which) 
				{
					Toast.makeText(	getBaseContext(), 
									"cancel", 
									Toast.LENGTH_SHORT).show();
					
				}
			})
			.setSingleChoiceItems(list, obj, 
					new DialogInterface.OnClickListener() 
				{
				
					public void onClick(DialogInterface dialog, int which) 
					{
						aux = list[which].toString();
					}
			})
			.create();

		default:
			break;
		}
		return null;
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
