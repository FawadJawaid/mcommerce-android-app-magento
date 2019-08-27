package com.tcs.mystore1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity {

	Button loginBtn, signupBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initUI();
	}

    void initUI(){
    	setContentView(R.layout.activity_login);
    	
    	loginBtn = (Button) findViewById(R.id.loginbutton);
    	signupBtn = (Button) findViewById(R.id.signupbutton);
    	
    	loginBtn.setOnClickListener(loginBtnListener);
		signupBtn.setOnClickListener(signupBtnListener);
    }
	
    OnClickListener loginBtnListener = new OnClickListener() {

		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {

			   LoginDialogFragment fragment1 = new LoginDialogFragment();
			    
			    android.app.FragmentManager fm = getFragmentManager();
			    fragment1.show(fm, "");
			    
			    /*Intent intent = new Intent(getApplicationContext(), EMenuActivity.class);
				startActivity(intent);*/

		}
	};
	
	
	OnClickListener signupBtnListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
        
			Intent signupIntent = new Intent(getApplicationContext(),
					SignupActivity.class);
			startActivity(signupIntent);
		}
	};
    
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
