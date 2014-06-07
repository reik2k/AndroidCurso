package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	ToggleButton 	tglButton;
	CheckBox		chkBox;
	ImageView		img;
	RadioGroup		radOption;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tglButton 	= (ToggleButton)findViewById(R.id.toggleButton1);
		chkBox		= (CheckBox)findViewById(R.id.checkBox1);
		radOption	= (RadioGroup)findViewById(R.id.radGroup);
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
					RadioButton rad;
					if(isChecked)
					{
						Log.i("CheckBox","Imagen del Pollo");
						rad = (RadioButton)findViewById(R.id.radPollo);
						img.setImageResource(R.drawable.bad_chicken);
						rad.setChecked(true);
						
					}else
						{
							Log.i("CheckBox","Imagen del Android");
							rad = (RadioButton)findViewById(R.id.radAndroid);
							img.setImageResource(R.drawable.ic_launcher);
							rad.setChecked(true);
						}
				
				}
			});
		
		//RadioGroupListener
		radOption.setOnCheckedChangeListener(
			new RadioGroup.OnCheckedChangeListener() 
			{
			
				public void onCheckedChanged(	RadioGroup group, 
												int checkedId) 
				{
					RadioButton radPollo =	
							(RadioButton)findViewById(R.id.radPollo);
					RadioButton radAnd =	
							(RadioButton)findViewById(R.id.radAndroid);
					
					if(radPollo.isChecked())
					{
						Log.i("raOption","[Opcion1] Pollo");
						img.setImageResource(R.drawable.bad_chicken);
						chkBox.setChecked(true);
						
					}
					if(radAnd.isChecked())
					{
						Log.i("raOption","[Opcion2] Android");
						img.setImageResource(R.drawable.ic_launcher);
						chkBox.setChecked(false);
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
