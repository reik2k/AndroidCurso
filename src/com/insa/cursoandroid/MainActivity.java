package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 

		
	}
	public void call2intent(View view)
	{
		Intent i = null;
		
		switch(view.getId())
		{
		case R.id.btnNavigator:
			i = new Intent(	Intent.ACTION_VIEW, 
							Uri.parse("http://www.google.es"));
			startActivity(i);
			
			break;
		case R.id.btnCall:
			i = new Intent(	Intent.ACTION_CALL, 
					Uri.parse("tel: (+34) 675666114"));
			startActivity(i);
			break;
		case R.id.btnCallContact:
			i = new Intent(	Intent.ACTION_VIEW, 
					Uri.parse("content://contacts/people"));
			startActivity(i);
			break;
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
