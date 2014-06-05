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
import android.widget.TextView;

public class Pantalla2Activity extends Activity {
	
	Button 		btnVolver;
	EditText 	txtVolver;
	Bundle 		bundle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pantalla2);
		
		btnVolver 	= (Button)findViewById(R.id.bntVolver);
		txtVolver 	= (EditText)findViewById(R.id.editText2);
		
		bundle = getIntent().getExtras();
		
		txtVolver.setText(bundle.getString("param1"));
		
		btnVolver.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
				Intent i = getIntent();
				
				bundle.putString("param2", "Pantalla1: "
						+ txtVolver.getText().toString());
				
				i.putExtras(bundle);
				
				setResult(RESULT_OK,i);
				finish();
				
			}
		});
		
		
		/*if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pantalla2, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_pantalla2,
					container, false);
			return rootView;
		}
	}*/

}
