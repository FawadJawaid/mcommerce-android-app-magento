package com.tcs.mystore1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends Activity {

	public static String s1 = new String();
	public static String st = new String();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		
		Button b3 = (Button) findViewById(R.id.save);
		b3.setOnClickListener(new View.OnClickListener() {
			
			EditText Value = (EditText)findViewById(R.id.editText1);
			EditText Value2 = (EditText)findViewById(R.id.editText2);
			EditText Value3 = (EditText)findViewById(R.id.editText3);
			@Override
			public void onClick(View v) {
		     s1 = Value.getText().toString().trim();
		     st = Value2.getText().toString().trim();
		     
		     String s2 = Value2.getText().toString().trim();
		     String s3 = Value3.getText().toString().trim();
		     
		     if(s2.equals(s3))
		     {
		    	 Toast.makeText(getApplicationContext(), "Both Passwords matched ID created.", Toast.LENGTH_LONG).show();
		     }
		     else{
		    	 Toast.makeText(getApplicationContext(), "Try Again Passwords doesn't match.", Toast.LENGTH_LONG).show();
		     }
			}
		});
		
		Button b4 = (Button) findViewById(R.id.back);
		b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplication(), LoginActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.signup, menu);
		return true;
	}
}
