package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends Activity {
	
	private CheckBox 	chk;
	private RadioButton	rdSingle;
	private RadioButton	rdMarried;
	private RadioButton	rdOther;
	private EditText	edtTextAge;
	private EditText	edtTextState;
	private Button		btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		//Seleccionamos el Botón al iniciar la activity
		btn = (Button)findViewById(R.id.btnLegalAge);
		
		//Declaramos un listener para manejar el boton
		btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) 
			{
				//Declaramos los widgets a utilizar
				chk 			= (CheckBox)findViewById(R.id.chkLegalAge);
				rdSingle		= (RadioButton)findViewById(R.id.radSingle);
				rdMarried		= (RadioButton)findViewById(R.id.radMarried);
				rdOther			= (RadioButton)findViewById(R.id.radOther);
				edtTextAge		= (EditText)findViewById(R.id.edtLegaAge);
				edtTextState 	= (EditText)findViewById(R.id.edtCivilState);
				
				//Borramos el contenido anterior de los TEXTview.
				edtTextAge.setText("");
				edtTextState.setText("");
				
				if(chk.isChecked())
				{
					edtTextAge.setText("Eres Mayor de Edad.");
				}else
					{
						edtTextAge.setText("NO Eres Mayor de Edad.");
					}
				
				if(rdMarried.isChecked())
				{
					edtTextState.setText("Estás Casado.");
				}
				
				if(rdSingle.isChecked())
				{
					edtTextState.setText("Estás Soltero");
				}
				if(rdOther.isChecked())
				{
					edtTextState.setText("Tu estado civil es indefinido");
				}
			}
		});
		
		
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
