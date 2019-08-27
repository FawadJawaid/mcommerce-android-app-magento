package com.tcs.mystore1;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

@SuppressLint("NewApi")
public class LoginDialogFragment extends DialogFragment {
	
	ImageButton crossButton;
	Button login;
	@SuppressLint("NewApi")
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Dialog dialog = new Dialog(getActivity());
		dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		dialog.setContentView(R.layout.dialogfragment_login);
		
		dialog.show();
		
		crossButton = (ImageButton) dialog.findViewById(R.id.crossimgBtn);
		
		crossButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// mListener.setOnSubmitListener(mEditText.getText().toString());
				dismiss();
			}
		});
		
		login = (Button) dialog.findViewById(R.id.logbtn);
		login.setOnClickListener(new OnClickListener() {
			
			EditText Value1 = (EditText)dialog.findViewById(R.id.usernameText);
			EditText Value2 = (EditText)dialog.findViewById(R.id.editText1);
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*Intent EmployeeMenuIntent = new Intent(getActivity(),
						EMenuActivity.class);
				startActivity(EmployeeMenuIntent);*/
				
				String s4 = Value1.getText().toString().trim();
				String s5 = Value2.getText().toString().trim();
				
				if((Boolean)(SignupActivity.s1).equals(s4) && (Boolean)(SignupActivity.st).equals(s5) )
				{
				Intent intent = new Intent(getActivity(), EMenuActivity.class);
				startActivity(intent);
				}
				else
				{
					Toast.makeText(getActivity().getApplicationContext(), "Not a valid ID/Password. Create your ID by Signing Up!" , Toast.LENGTH_LONG).show();
				}
				
			}
		});
		return dialog;
	}

}
