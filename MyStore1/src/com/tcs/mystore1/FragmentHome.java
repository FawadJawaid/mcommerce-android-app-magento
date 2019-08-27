package com.tcs.mystore1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.GridView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

public class FragmentHome extends Fragment {

	GridView grid;
    public String[] web = {
            "Maroon Net Dress",
            "Red Dress",
            "White Stripes Shirt",
            "Check Shirt",
            "Box Shirt"
    } ;
    
    public int[] imageId = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image2,
    };
 
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
 
        CustomGridView adapter = new CustomGridView(FragmentHome.this, web, imageId);
        grid=(GridView)findViewById(R.id.grid);
                grid.setAdapter(adapter);
                grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
 
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Toast.makeText(FragmentHome.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
 
                        
                        Bundle bun = new Bundle();
                        bun.putInt("selected_image", position);
                        getApplication().setArguments(bun);
                    }
                });
 
    }*/
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        
        CustomGridView adapter = new CustomGridView(getActivity(), web, imageId);
        grid=(GridView)rootView.findViewById(R.id.grid);
                grid.setAdapter(adapter);
                grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
 
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
 
                        
                        Bundle bun = new Bundle();
                        bun.putInt("selected_image", position);
                        
                        
                        
                        FragmentManager fm = getActivity().getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        
                        Fragment frag =  new FragmentProduct();
                        
                        frag.setArguments(bun);
                        
                        ft.replace(R.id.activity_main_content_fragment, frag);
                        ft.commit();
                    }
                });
 
        
        return rootView;
    }
}
