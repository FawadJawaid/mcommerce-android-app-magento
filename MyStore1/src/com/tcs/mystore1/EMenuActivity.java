package com.tcs.mystore1;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


@SuppressLint("NewApi")
public class EMenuActivity extends FragmentActivity {

	// The MainLayout which will hold both the sliding menu and our main content
    // Main content will holds our Fragment respectively
    EMenuLayout mainLayout;
    
    private ArrayList<EMenuItem> navDrawerItems;
	private EMenuListAdapter adapter;
	
	
	ImageButton logOutBtn;
	TextView logOutBtnTitle;
	String token;
    
    // ListView menu
    private ListView lvMenu;
    private String[] lvMenuItems;
    private TypedArray menuIcons;
    
    // Menu button
    ImageButton btMenu;
    
    // Title according to fragment
    TextView tvTitle;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Inflate the mainLayout
        mainLayout = (EMenuLayout)this.getLayoutInflater().inflate(R.layout.activity_emenu, null);
        setContentView(mainLayout);
        
        // Init menu
        
        lvMenuItems = getResources().getStringArray(R.array.emenu_items);
        
		menuIcons = getResources()
				.obtainTypedArray(R.array.enav_drawer_icons);
        
        lvMenu = (ListView) findViewById(R.id.activity_main_menu_listview);
        
        //Intent i = getIntent();
        Intent gameOverintent = getIntent();
        int value = gameOverintent.getIntExtra("gameover", 0);
        
        //token = gameOverintent.getStringExtra("ACCESS");
        
        //Log.v("TOKEN IN MENU", token);
        
        navDrawerItems = new ArrayList<EMenuItem>();

		// adding nav drawer items to array
		// Home
        navDrawerItems.add(new EMenuItem(lvMenuItems[0],0));
		// My Cart
        navDrawerItems.add(new EMenuItem(lvMenuItems[1], 0));
		
		// Recycle the typed array
		menuIcons.recycle();
        
        /*lvMenu.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lvMenuItems));*/
		
		adapter = new EMenuListAdapter(getApplicationContext(),
				navDrawerItems);
		lvMenu.setAdapter(adapter);

        lvMenu.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onMenuItemClick(parent, view, position, id);
            }
            
        });
        
      
        
        // Get menu button
        btMenu = (ImageButton) findViewById(R.id.activity_main_content_button_menu);
        btMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show/hide the menu
                toggleMenu(v);
            }
        });
        
        logOutBtn = (ImageButton) findViewById(R.id.logoutbtn);
        logOutBtnTitle = (TextView) findViewById(R.id.logouttitle);
        //Typeface typeFace=Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/MondaRegular.ttf");
	    //logOutBtnTitle.setTypeface(typeFace);
        logOutBtnTitle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onClickLogout();
				
			}
		});
        
       
        // Get title textview
        //tvTitle = (TextView) findViewById(R.id.activity_main_content_title);
        
        // Add FragmentMenu as the initial fragment       
        FragmentManager fm = EMenuActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        
        Fragment fragment = new FragmentHome();
        
        /*if(token!=null){
        Bundle args = new Bundle();
		args.putString("Access Token", token);
		fragment.setArguments(args);}*/
        
        ft.replace(R.id.activity_main_content_fragment, fragment);
        ft.commit();
        
        //Intent gameOverintent = getIntent();
        //int value = gameOverintent.getIntExtra("gameover", 0);
        
   
        /*if(getIntent().getIntExtra("reschedule", 0)==10) {      	
        	FragmentTransaction ft1 = fm .beginTransaction();
            Fragment fragment1 = new FragmentCallMeeting();
            ft1.replace(R.id.activity_main_content_fragment, fragment1);
            ft1.commit();        	
        }*/
        	
    }
    
    private void  onClickLogout() {
    	Intent homeIntent= new Intent(Intent.ACTION_MAIN);
    	homeIntent.addCategory(Intent.CATEGORY_HOME);
    	homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	startActivity(homeIntent);
    }

 
    public void toggleMenu(View v){
        mainLayout.toggleMenu();
    }
    
    // Perform action when a menu item is clicked
    private void onMenuItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = lvMenuItems[position];
        //String currentItem = tvTitle.getText().toString();
        
        // Do nothing if selectedItem is currentItem
        /*if(selectedItem.compareTo(currentItem) == 0) {
            mainLayout.toggleMenu();
            return;
        }*/
            
        FragmentManager fm = EMenuActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;
        
        EFragmentFactory fac = new EFragmentFactory();     //Simple Factory Method Pattern
        fragment = fac.createFragment(selectedItem);     

        if(fragment != null) {
            // Replace current fragment by this new one
            ft.replace(R.id.activity_main_content_fragment, fragment);
            ft.commit();
            
        }
        
        // Hide menu anyway
        mainLayout.toggleMenu();
    }
    
    
    @SuppressLint("NewApi")
	@Override
    public void onBackPressed() {
    	//To get the current fragment
    	Fragment myFragment = (Fragment)  getSupportFragmentManager().findFragmentByTag("HOME_FRAGMENT");
    	
        if (mainLayout.isMenuShown()) {
            mainLayout.toggleMenu();
        }
        else if(myFragment!=null && myFragment.isVisible())
        {        	
        	// Do Nothing
        }
        else {
            //super.onBackPressed();
        	
        	 FragmentManager fm = EMenuActivity.this.getSupportFragmentManager();
             FragmentTransaction ft = fm.beginTransaction();
             
             FragmentHome fragment = new FragmentHome();
             ft.replace(R.id.activity_main_content_fragment, fragment, "HOME_FRAGMENT");
             ft.commit();
		
        }
    }

}

