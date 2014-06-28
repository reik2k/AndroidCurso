package com.insa.cursoandroid; 

import com.insa.cursoandroid.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	TextView				txt;
	static	final String 	NEW_LINE 	= "\n"; 
	static	String			result 		= new String();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		txt = (TextView)findViewById(R.id.txtResult);
		
		result = "EJEMPLO1" + NEW_LINE;
		result += "-----------------------------" + NEW_LINE;
		
		result += setExample1();
		
		result += NEW_LINE + "EJEMPLO2" + NEW_LINE;
		result += "-----------------------------" + NEW_LINE;
		
		result += setExample2();
		
		result += NEW_LINE + "EJEMPLO3" + NEW_LINE;
		result += "-----------------------------" + NEW_LINE;
		
		result += setExample3();
		
		result += NEW_LINE + "EJEMPLO4" + NEW_LINE;
		result += "-----------------------------" + NEW_LINE;
		
		result += setExample4();
		
		txt.setText(result);
	}
	
	private String setExample4()
	{
		String str = new String();
		
		str = "expedición";
		 
		return 	"str = "+ str 								+ NEW_LINE+
				"lenght(str): "+ str.length() 				+ NEW_LINE +
				"idexOf(x,str.lenght): " + str.indexOf("x", str.length()) 
															+ NEW_LINE + 
				"replace(x-->s): " + str.replace("x", "s") 	+ NEW_LINE + 
				"replace(s-->x): " + str.replace("s", "x") 	+ NEW_LINE + 
				"idexOf(d,4): " + str.indexOf("d", 4)		+ NEW_LINE +
				"charAt(4): " + str.charAt(4) 				+ NEW_LINE +
				"";
	}
	
	private String setExample3()
	{
		Character chr = new Character('a');
		
		return 	"CharValue: " 		+ chr.charValue() 	+ NEW_LINE +
				"9 isDigit: "		+ chr.isDigit('9') 	+ NEW_LINE +
				"C isLetter: "		+ chr.isLetter('C') + NEW_LINE +
				"c isLoweCase: "	+ chr.isLowerCase('c');
	}
	private String setExample2()
	{
		String numBinary		=	"101111";
		String numOctal			=	"57";
		String numHexadecimal	=	"2F";
		String numDecimal		=	"47";
		
		String	resultExample1	=	"";
		
		resultExample1	+= 	Integer.parseInt(numBinary,2)		+	NEW_LINE;
		resultExample1	+= 	Integer.parseInt(numOctal,8)		+	NEW_LINE;
		resultExample1	+= 	Integer.parseInt(numHexadecimal,16)	+	NEW_LINE;
		resultExample1	+= 	Integer.parseInt(numDecimal,10)		+	NEW_LINE;
		
		return resultExample1;
	}
	private String setExample1()
	{
		String 	strScreen;
		Integer	num1	= 	new Integer("22");
		Integer num2	= 	new Integer("100");
		int		n1		= 	num1.intValue();
		int		n2		= 	num2.intValue();
		
		strScreen = "La suma de num1 ("+n1+") + num2 ("+n2+") "+
					"es igual a " + (n1+n2)+NEW_LINE;
		
		strScreen += "Como la suma es: "+(n1+n2);
		
		if(n1+n2>130)
		{
			strScreen += " y es mayor a 130";
			n1++;
		}else
		{
			strScreen += " y es menor a 130";
			n1--;
		}
		
		strScreen += ", entonces n1 = " + n1 + NEW_LINE;
		
		return strScreen;
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
