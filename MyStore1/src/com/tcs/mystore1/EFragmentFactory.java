package com.tcs.mystore1;

import android.support.v4.app.Fragment;

public class EFragmentFactory {
	
	public EFragmentFactory() {
		
	}
	
	public Fragment createFragment(String selectedItem) {
		
		    Fragment fragment = null;
	       
	        if(selectedItem.compareTo("Home") == 0) {
	            fragment = new FragmentHome();
	        } else if(selectedItem.compareTo("My Cart") == 0) {
	            fragment = new FragmentCart();
	        } 
	        
	        return fragment;
		}
		
}

