package com.tcs.mystore1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class FragmentCart extends Fragment {
	
	GridView grid;
    public static String[] web = new String[50];
    
    public static int[] imageId = new int [50];
 
   
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);
        
        CustomGridView adapter = new CustomGridView(getActivity(), web, imageId);
        grid=(GridView)rootView.findViewById(R.id.grid);
                grid.setAdapter(adapter);
                grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
 
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
 
                        
                        FragmentManager fm = getActivity().getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        
                        Fragment frag =  new FragmentCheckout();
                        
                        ft.replace(R.id.activity_main_content_fragment, frag);
                        ft.commit();
                    }
                });
 
        
        return rootView;
    }

}
