package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 

		Log.d("onCreateState", "Estamos en el estado de Creación");
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
