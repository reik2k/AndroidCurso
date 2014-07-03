package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
	static	int	id_warning	= 1;
	
	private 	Button	btnStart;
	private 	Button	btnCancel;
	private		Button	btnUpdate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		int currentVersion = android.os.Build.VERSION.SDK_INT;
		
		//Boton para el Ejemplo de las Notificaciones
		Button btn = (Button)findViewById(R.id.bntWarning);
		
		btnStart 	= (Button)findViewById(R.id.btnStartNot);
		btnCancel 	= (Button)findViewById(R.id.btnCancelNot);
		btnUpdate 	= (Button)findViewById(R.id.btnUpdateNot);
		
		if(currentVersion < android.os.Build.VERSION_CODES.ECLAIR_MR1)
		{
			//Versión por debajo de la API 7 v2.1
			btn.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					showWarningOld();
					
				}
			});
		}else
			{
				//nuevos comandos
				btn.setOnClickListener(new View.OnClickListener() {
				
					public void onClick(View v) {
						showWarning();
						
					}
				});
				
				//Start Notfication
				btnStart.setOnClickListener(new View.OnClickListener() {
				
					public void onClick(View v) {
						
						showAlert();
					}
				});
				//Cancel Notfication
				btnCancel.setOnClickListener(new View.OnClickListener() {
				
					public void onClick(View v) {
						cancelAlert();
						
					}
				});
				//Update Notfication
				btnUpdate.setOnClickListener(new View.OnClickListener() {
				
					public void onClick(View v) {
						
						updateAlert();
					}
				});
			}
	}
	
	protected void showAlert()
	{}
	protected void cancelAlert()
	{}
	protected void updateAlert()
	{}
	
	private void showWarning()
	{
		Intent i = new Intent(this,Notificaciones.class);
		
		i.putExtra("id_aviso", id_warning);
		
		PendingIntent pndIntent = PendingIntent.getActivity(this, 0, i, 0);
		
		NotificationCompat.Builder new_notif = 
					new NotificationCompat.Builder(this)
					.setSmallIcon(R.drawable.bad_chicken)
					.setContentTitle("You have a Alert")
					.setContentIntent(pndIntent)
					.setAutoCancel(true);
		NotificationManager notif_manager = 
				(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		notif_manager.notify(0,new_notif.build());
		
			
	}
	private void showWarningOld()
	{
		Intent i = new Intent(this,Notificaciones.class);
		
		i.putExtra("id_aviso", id_warning);
		
		PendingIntent pndIntent = PendingIntent.getActivity(this, 0, i, 0);
		
		NotificationManager ntfMan 	= 	(NotificationManager) 
										getSystemService(NOTIFICATION_SERVICE);
		Notification not			=	new Notification(	
											R.drawable.bad_chicken,
											"The meeting is coming in five minutes.",
											System.currentTimeMillis());
		CharSequence sms	=	"System Warning";
		CharSequence sms2	= 	"The meeting with client is at 17:00.";
		
		not.setLatestEventInfo(this, sms, sms2, pndIntent);
		
		//espera 100ms, vibra 250ms, espera 100ms y vibra otros 500ms
		not.vibrate = new long[]{100,250,100,500};
		
		ntfMan.notify(id_warning,not);	
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
