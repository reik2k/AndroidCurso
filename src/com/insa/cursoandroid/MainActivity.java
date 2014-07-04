package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.telephony.gsm.SmsMessage;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	private EditText	edtPhone;
	private	EditText	edtMessage;
	private Button		btnSend;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		//Init Widgets
		btnSend 	= (Button)findViewById(R.id.btnSend);
		edtPhone 	= (EditText)findViewById(R.id.edtPhone);
		edtMessage 	= (EditText)findViewById(R.id.edtMessage);
		
		btnSend.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				if(	validateSMS(	edtPhone.getText().toString(),
									edtMessage.getText().toString()))
				{
					sendSMS(	edtPhone.getText().toString(),
								edtMessage.getText().toString());
					
				}else
				{
					Toast.makeText(	getBaseContext(), 
									"You have to fill both fields", 
									Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
	}
	
	protected void sendSMS(String phone, String smsText)
	{
		SmsManager sms = SmsManager.getDefault();
		
		sms.sendTextMessage(phone, null, smsText, null, null);
		
	}
	
	protected boolean validateSMS(String phone, String sms)
	{
		Boolean response = false;
		
		if(phone.isEmpty() || sms.isEmpty() && sms.length() < 160)
		{
			return response;
		}
		
		return true;
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
