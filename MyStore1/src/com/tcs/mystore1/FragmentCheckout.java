package com.tcs.mystore1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentCheckout extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_checkout, container, false);
      
        final EditText name = (EditText) rootView.findViewById(R.id.editText2);
        Button orderBtn = (Button) rootView.findViewById(R.id.nextOrder);
        
        
		orderBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			    
				 String s1 = name.getText().toString();
			        
			     Bundle bun = new Bundle();
			     bun.putString("name", s1);
			  
                 FragmentManager fm = getActivity().getSupportFragmentManager();
                 FragmentTransaction ft = fm.beginTransaction();
                 
                 Fragment frag =  new FragmentSuccess();
                 
                 frag.setArguments(bun);
                 
                 ft.replace(R.id.activity_main_content_fragment, frag);
                 ft.commit();
				
			}
		});
        
        return rootView;
    }
}
