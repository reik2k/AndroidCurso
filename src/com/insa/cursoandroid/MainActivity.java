package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {
	private Button	btnWarning 	= null;
	private Button	btnQuestion	= null;
	
	private static final int WARNING_BOX 	= 1;
	private static final int QUESTION_BOX 	= 0;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		btnWarning = (Button) findViewById(R.id.btnWarning);
		btnQuestion = (Button) findViewById(R.id.btnDialog);
		
		btnWarning.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) 
			{
				showDialog(WARNING_BOX);
				
			}
		});
		btnQuestion.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) 
			{
				showDialog(QUESTION_BOX);
				
			}
		});
		
	}
	
	protected Dialog onCreateDialog(int id)
	{
		Dialog dialog = null;
		
		switch(id)
		{
		case QUESTION_BOX:
			{
				dialog = createQuestionDialog();
				break;
			}
		case WARNING_BOX:
			{
				dialog = createWarningDialog();
				break;
			}
		}
		return dialog;
	}
	
	private Dialog createWarningDialog()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		builder.setTitle("Information");
		builder.setMessage("This is a warning message, for example.");
		
		builder.setPositiveButton("Accept", new OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) 
			{
				// close the Dialog Alert
				dialog.cancel();
			}
		});
		return builder.create();
	}
	
	private Dialog createQuestionDialog()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		builder.setTitle("Confirmation");
		builder.setMessage("Would you like formating your Device?");
		
		builder.setNegativeButton("Cancel", new OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) 
			{
				Log.i("QUESTION","The user hasn't accepted the format action");
				// close the Dialog Alert
				dialog.cancel();
				
			}
		});		
		builder.setPositiveButton("Accept", new OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) 
			{
				Log.i("QUESTION","The user has accepted the format action");
				// close the Dialog Alert
				dialog.cancel();
			}
		});
		
		return builder.create();
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
