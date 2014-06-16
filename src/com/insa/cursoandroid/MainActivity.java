package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {
	Button			btn;
	CharSequence[]	items 			= 	{"Zamora", "León", "Salamanca"};
	boolean[]		itemsChecked	=	new boolean[items.length];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		btn = (Button) findViewById(R.id.btnDialog);
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) 
			{
				showDialog(0);
				
			}
		});
		
	}
	
	protected Dialog onCreateDialog(int id)
	{
		switch(0)
		{
		case 0:
			{
				return new AlertDialog.Builder(this)
							.setIcon(R.drawable.ic_launcher)
							.setTitle("Titulo")
							.setPositiveButton("Accept", 
								new DialogInterface.OnClickListener() 
								{
									
									public void onClick(DialogInterface dialog, 
														int which) 
									{
										Toast.makeText(
												getBaseContext(),
												"You have just pushed"
												+ "Accept Button", 
												Toast.LENGTH_SHORT).show();
										
									}
								})
							.setNegativeButton("Cancel", 
								new DialogInterface.OnClickListener() {
									
									public void onClick(DialogInterface dialog, 
														int which) 
									{
										Toast.makeText(
												getBaseContext(),
												"You have just pushed it"
												+ "Cancel Button",  
												Toast.LENGTH_SHORT).show();
										
									}
								})
								.setMultiChoiceItems(items, itemsChecked, 
									new DialogInterface
									.OnMultiChoiceClickListener() 
									{
										
										public void onClick(
												DialogInterface dialog, 
												int which, 
												boolean isChecked) 
										{
											Toast.makeText(
													getBaseContext(),
													items[which] 
													+ (isChecked ?
													" is Selected":
													" is not Selected"),  
													Toast.LENGTH_SHORT).show();
											
										}
									})
							.create();
			}
		}
		return null;
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
