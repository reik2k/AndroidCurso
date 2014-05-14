package com.insa.cursoandroid; 

import com.insa.androidcurso.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

	private EditText 	editFieldText;
	private Button 		btn;
	private TextView 	txtView;
	private String		aux;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		editFieldText 	= 	(EditText)findViewById(R.id.editText1);
		btn 			= 	(Button)findViewById(R.id.button1);
		txtView 		= 	(TextView)findViewById(R.id.textView1);
		
		editFieldText.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				editFieldText.setText("");
				txtView.setText("Tu nombre es: ");
				
			}
		});
		btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
				aux = (String) txtView.getText();
				txtView.setText( aux +" "+ editFieldText.getText());
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
