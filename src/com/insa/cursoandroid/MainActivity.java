package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
	EditText 	edtName;
	EditText 	edtRepeat;
	Button		btnSend;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		edtName 	= (EditText)findViewById(R.id.edtName);
		edtRepeat 	= (EditText)findViewById(R.id.edtRepeat);
		btnSend		= (Button)findViewById(R.id.btnSend);
		
		btnSend.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				String 	name 	= edtName.getText().toString();
				String 	repeat	= edtRepeat.getText().toString();
				
				if(!name.isEmpty()&&!repeat.isEmpty())
				{
					Bundle	b = new Bundle();
					Intent 	i = new Intent(	MainActivity.this,
											SecondActivity.class);
					
					b.putString("param1", name);
					b.putString("param2", repeat);
					
					i.putExtras(b);
					
					startActivity(i);
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
