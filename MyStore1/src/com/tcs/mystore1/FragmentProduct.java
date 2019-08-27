package com.tcs.mystore1;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentProduct extends Fragment {
	
	 int i;
	 FragmentHome fh = new FragmentHome();
	 
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
	        View rootView = inflater.inflate(R.layout.fragment_product, container, false);
	      
	        ImageView productImage = (ImageView) rootView.findViewById(R.id.productimageView);
	        TextView productName = (TextView) rootView.findViewById(R.id.productnameView);
	        Button addToCartBtn = (Button) rootView.findViewById(R.id.addcartButton);
	        
	        //FragmentHome fh = new FragmentHome();
	        
	        Bundle bundle = this.getArguments();
	        final int position = bundle.getInt("selected_image");
	        
	        Drawable image  =getResources().getDrawable(fh.imageId[position]);
	        productImage.setImageDrawable(image);
	        productName.setText(fh.web[position]);
	        
	        
	        
			addToCartBtn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
				    
					
					FragmentCart fc = new FragmentCart();
					
					if(Global.cart_Count==0)
					{
						FragmentCart.imageId[0] = fh.imageId[position];
						FragmentCart.web[0] = fh.web[position];
					}
					else if(Global.cart_Count==1)
					{
						FragmentCart.imageId[1] = fh.imageId[position];
						FragmentCart.web[1] = fh.web[position];
					}
					else if(Global.cart_Count==2)
					{
						FragmentCart.imageId[2] = fh.imageId[position];
						FragmentCart.web[3] = fh.web[position];
					}
					else if(Global.cart_Count==3)
					{
						FragmentCart.imageId[3] = fh.imageId[position];
						FragmentCart.web[3] = fh.web[position];
					}
					
					
					/*while(i>=0) {
						fc.imageId[i] = fh.imageId[position];
						fc.web[i] = fh.web[position];
					}
					
					i++;*/
					//count = i;
					Global.cart_Count++;
					
					Toast.makeText(getActivity(), ""+fh.web[position]+ " added to Cart.", Toast.LENGTH_LONG).show();
				}
			});
	        
	        return rootView;
	    }

}
