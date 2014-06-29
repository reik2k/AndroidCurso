package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 

		Log.d("onCreateState", "Estamos en el estado de Creación");
		
		detectDisplay();
		
	}
	
	private void detectDisplay()
	{
		WindowManager wm 	= getWindowManager();
		
		Display d 			= wm.getDefaultDisplay();
		EditText edt1		=(EditText)findViewById(R.id.editText1);
		EditText edt2		=(EditText)findViewById(R.id.editText2);
		
		if(d.getWidth() < d.getHeight())
		{
			edt2.setText("");
			edt1.setText("Vertical");
		}else
			{
				edt1.setText("");
				edt2.setText("Horizontal");
			}
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
		
		detectDisplay();
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
		estado.putString("ID", "Este valor se ha guardado tras la destrucción"
								+	"de la actividad.");
		super.onSaveInstanceState(estado);
	}
	
	@Override
	public void onRestoreInstanceState(Bundle estado) 
	{
		super.onRestoreInstanceState(estado);
		
		Toast.makeText(	getBaseContext(), 
						estado.getString("ID"), 
						Toast.LENGTH_SHORT).show();
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
