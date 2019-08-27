package com.tcs.mystore1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentSuccess extends Fragment {
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_success, container, false);
      
        TextView name = (TextView) rootView.findViewById(R.id.maintextView);
        
        Bundle bundle = this.getArguments();
        final String customerName = bundle.getString("name");
        
        name.setText(customerName);
        
        return rootView;
    }

}
