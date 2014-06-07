package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends Activity {
	TextView		txtFontSize;
	ToggleButton	tglSetFontSize;
	Button			btnFontSize;
	EditText		edtFontSizeIn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtFontSize		=	(TextView)findViewById(R.id.textView1);
		tglSetFontSize	=	(ToggleButton)findViewById(R.id.tglButton);
		btnFontSize		=	(Button)findViewById(R.id.button1);
		edtFontSizeIn	=	(EditText)findViewById(R.id.editText1);
		
		//To create the listeners for the activity
		//TOGGLEBUTTON
		tglSetFontSize.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				if(tglSetFontSize.isChecked())
				{
					txtFontSize.setTextSize(30);
					Log.d("tglSetFontSize","Tamaño del EditText es 30");
				}else
					{
						txtFontSize.setTextSize(10);
						Log.d("tglSetFontSize","Tamaño del EditText es 30");
					}
				
			}
		});
		
		//BUTTON
		btnFontSize.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				if(tglSetFontSize.isChecked())
				{
					edtFontSizeIn.setTextSize(30);
					Log.d("btnFontSize","Tamaño del EditText es 30");
				}else
					{
						edtFontSizeIn.setTextSize(10);
						Log.d("btnFontSize","Tamaño del EditText es 10");
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
