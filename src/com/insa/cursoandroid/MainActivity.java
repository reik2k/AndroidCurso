package com.insa.cursoandroid; 

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.insa.cursoandroid.R;


public class MainActivity extends Activity {

	private Button 		btnNav,btnTel,btnMap,btnContact;
	private Intent 		intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		//Declaración de los botones del Activity Principal
		btnNav		= 	(Button)findViewById(R.id.btnNav);
		btnTel		= 	(Button)findViewById(R.id.btnTel);
		btnMap		= 	(Button)findViewById(R.id.btnMap);
		btnContact	= 	(Button)findViewById(R.id.btnContact);
		
		btnNav.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
				intent = new Intent(	Intent.ACTION_VIEW, 
						Uri.parse("http://www.google.es"));
				startActivity(intent);
			}
		});
		btnTel.setOnClickListener(new OnClickListener() {
					
			public void onClick(View v) 
			{
				intent = new Intent(	Intent.ACTION_CALL, 
										Uri.parse("675666114"));
				
				startActivity(intent);
			}
		});
		
		btnMap.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
				intent = new Intent(	Intent.ACTION_VIEW, 
						Uri.parse("geo:50.123,7.134?z=19"));
				startActivity(intent);
			}
		});
		btnContact.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
				intent = new Intent(	Intent.ACTION_VIEW, 
						Uri.parse("content://contacts/people"));
				startActivity(intent);
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
