package com.insa.cursoandroid; 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.insa.cursoandroid.R;


public class MainActivity extends Activity {

	private EditText 	editFieldText;
	private Button 		btn;
	//private String		aux;
	private Bundle		bnd;
	private Intent 		intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		editFieldText 	= 	(EditText)findViewById(R.id.editText1);
		btn 			= 	(Button)findViewById(R.id.button1);
		
		editFieldText.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				editFieldText.setText("");
				
			}
		});
		btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
				intent 	= new Intent(	MainActivity.this,
										FrmActivityDestino.class);
				bnd 	= new Bundle();
				
				bnd.putString("name","nombre: "	+	
										editFieldText.getText().toString());
				intent.putExtras(bnd);
				
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
