package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Como crearemos el Layout a mano no es necesario
		//setContentView(R.layout.activity_main); 
		
		Log.d("onCreateState", "Estamos en el estado de Creación");
		
		//Parámetros para los controleas a crear
		LayoutParams params	=	new LayoutParams(	
										LayoutParams.WRAP_CONTENT,
										LayoutParams.WRAP_CONTENT);
		
		//Declaramos el layout
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		//Creamos un textview
		TextView txt = new TextView(this);
		txt.setText("Esto es un TextView creado a código.");
		txt.setLayoutParams(params);
		
		//Crear un botón
		Button btn = new Button(this);
		btn.setText("Botón creado a Código");
		btn.setLayoutParams(params);
		
		//Los añadimos al layout
		layout.addView(txt);
		layout.addView(btn);
		
		//Declaramos los parámetros del layout
		LinearLayout.LayoutParams paramsLayout = 
				new LinearLayout.LayoutParams(	LayoutParams.WRAP_CONTENT,
												LayoutParams.WRAP_CONTENT);
		
		//Los cramos el layout
		this.addContentView(layout, paramsLayout);	
	}
	
	@Override
	public void onStart()
	{
		Log.d("onStart","Estamos en el estado de Comienzo");
		super.onStart();
	}
	@Override
	public void onResume()
	{
		Log.d("onResume","Estamos en el estado de Volver");
		super.onResume();
		
	}
	@Override
	public void onPause()
	{
		Log.d("onPause","Estamos en el estado de Pausa");
		super.onPause();
	}
	@Override
	public void onStop()
	{
		Log.d("onStop","Estamos en el estado de Detener");
		super.onStop();
	}
	@Override
	public void onDestroy()
	{
		Log.d("onDestroy","Estamos en el estado de Eliminación");
		super.onDestroy();
	}
	@Override
	public void onRestart()
	{
		Log.d("onRestart","Estamos en el estado de Resetear");
		super.onRestart();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onSaveInstanceState(Bundle estado) 
	{
/*		estado.putString("ID", "Este valor se ha guardado tras la destrucción"
								+	"de la actividad.");*/
		super.onSaveInstanceState(estado);
	}
	
	@Override
	public void onRestoreInstanceState(Bundle estado) 
	{
		super.onRestoreInstanceState(estado);
		
/*		Toast.makeText(	getBaseContext(), 
						estado.getString("ID"), 
						Toast.LENGTH_SHORT).show();*/
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
