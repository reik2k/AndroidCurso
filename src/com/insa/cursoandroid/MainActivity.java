package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 

		
	}
	@Override
	protected void onActivityResult(	int requestCode, 
										int resultCode, 
										Intent data) 
	{
		if(resultCode == Activity.RESULT_OK && requestCode == 0)
		{
			String result = data.toURI();
			Log.i("Camera", "Ha entrado");
			Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
		}
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
		case R.id.btnActionDial:
			i = new Intent(	Intent.ACTION_DIAL, 
					Uri.parse("tel: (+34) 675666114"));
			startActivity(i);
			break;
		case R.id.btnActionGeoView:
			i = new Intent(	Intent.ACTION_VIEW, 
					Uri.parse("geo:50.123,7.1434?z=19"));
			startActivity(i);
			break;
		case R.id.btnGeoQuery:
			i = new Intent(	Intent.ACTION_VIEW, 
					Uri.parse("geo:0,0?q=query"));
			startActivity(i);
			break;
		case R.id.btnCamera:
			i = new Intent(	"android.media.action.IMAGE_CAPTURE");
			Log.i("Camera","intentURI: "+i.toURI());
			startActivityForResult(i, 0);
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
