package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import com.insa.cursoandroid.NavegadorActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	static EditText txt_protocolo;
	static Button 	btn_Navegar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 

		txt_protocolo = (EditText)findViewById(R.id.txtNavegar); 
		btn_Navegar = (Button)findViewById(R.id.btnNav);
		
		btn_Navegar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this,NavegadorActivity.class);
				
				Bundle b = new Bundle();
				
				b.putString("param1",txt_protocolo.getText().toString());
				
				i.putExtras(b);
				startActivity(i);
				
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
