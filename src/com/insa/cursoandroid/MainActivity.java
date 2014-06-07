package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	ToggleButton 	tglButton;
	CheckBox		chkBox;
	ImageView		img;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tglButton 	= (ToggleButton)findViewById(R.id.toggleButton1);
		chkBox		= (CheckBox)findViewById(R.id.checkBox1);
		img			= (ImageView)findViewById(R.id.imgBadChiken);
		
		//ToggelButton Listener 
		tglButton.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				TextView	txt = (TextView)findViewById(R.id.textView1);
				
				if(tglButton.isChecked())
				{
					txt.setText("Botón Activado!");
				}else
				{
					txt.setText("Desactivado!!");
				}
				
			}
		});
		
		//CheckBox Lsitener
		
		chkBox.setOnCheckedChangeListener(
				new CheckBox.OnCheckedChangeListener()
				{

					public void onCheckedChanged(	CompoundButton buttonView,
													boolean isChecked) 
					{
						if(isChecked)
						{
							img.setImageResource(R.drawable.bad_chicken);
						}else
							{
								img.setImageResource(R.drawable.ic_launcher);
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
