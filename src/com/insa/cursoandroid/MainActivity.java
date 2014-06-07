package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends Activity {

	RadioGroup	rad;
	CheckBox	chk;
	EditText	edt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		rad	=	(RadioGroup)findViewById(R.id.radGroup);
		chk	=	(CheckBox)findViewById(R.id.chkBox);
		edt	=	(EditText)findViewById(R.id.edtTexto);
		
		//CHECKBOX listener
		chk.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){

			public void onCheckedChanged(	CompoundButton buttonView,
											boolean isChecked) 
			{
				if(isChecked)
				{
					edt.setTextSize(60);
				}else
					{
						edt.setTextSize(30);
					}
			}
		});
		
		//RADIOGROUP listener
		rad.setOnCheckedChangeListener(
			new RadioGroup.OnCheckedChangeListener() 
			{
			
				public void onCheckedChanged(	RadioGroup group, 
												int checkedId) 
				{
					RadioButton opc = (RadioButton)findViewById(checkedId);
					
					edt.setBackgroundColor(setColor(opc.getText().toString()));
					
					
				}
			});
		
	}
	
	private int setColor(String opc)
	{
		Log.i("setColor","START The color is: "+opc);
		
		if(opc.contains("Verde"))
		{
			return Color.GREEN;
		}
		if(opc.contains("Azul"))
		{
			return Color.BLUE;
		}else
			{
			return Color.RED;
			}
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
