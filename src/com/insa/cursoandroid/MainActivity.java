package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
	
	private EditText	edtSubject;
	private	EditText	edtMessage;
	private EditText	edtSendTo;
	private Button		btnSend;
	private int			i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		//Init Widgets
		edtSubject 	= (EditText)findViewById(R.id.edtSubject);
		edtSendTo 	= (EditText)findViewById(R.id.edtSendTo);
		edtMessage 	= (EditText)findViewById(R.id.edtMessage);
		btnSend		= (Button)findViewById(R.id.btnSend);
		
		btnSend.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				String subject	= edtSubject.getText().toString();
				String message	= edtMessage.getText().toString();
				String email	= edtSendTo.getText().toString();
				
				i = validateEmail(subject,message,email	);
				
				switch(i)
				{
				case 0:
					sendEmail(subject,message,email);
					break;
				case 1:
					toastShow("You have to fill subject.");
					edtSubject.setFocusable(true);
					break;
				case 2:
					toastShow("The message is empty. Please" +
							", write something.");
					edtMessage.setFocusable(true);
					break;
				case 3:
					toastShow("You don´t write a email.");
					edtSendTo.setFocusable(true);
					break;
					
				}
			}
		});
		
	}
	
	protected void toastShow(String messageOut)
	{
		Toast.makeText(	
				getBaseContext(), 
				messageOut, 
				Toast.LENGTH_LONG).show();
	}
	protected void sendEmail(String subject, String message, String email)
	{
		Intent sendEmail = new Intent(Intent.ACTION_SEND);
		sendEmail.setData(Uri.parse("mailto:"));
		
		sendEmail.putExtra(Intent.EXTRA_EMAIL, email);
		sendEmail.putExtra(Intent.EXTRA_SUBJECT, subject);
		sendEmail.putExtra(Intent.EXTRA_TEXT, message);
		sendEmail.setType("message/rfc822");
		
		startActivity(Intent.createChooser(sendEmail, "EMAIL"));
	}
	
	protected int validateEmail(	String subject, 
									String message, 
									String email)
	{
		if(subject.isEmpty()) 	return 1;
		if(message.isEmpty())	return 2;
		if(email.isEmpty())		return 3;
		
		return 0;
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
