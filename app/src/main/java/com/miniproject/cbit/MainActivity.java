package com.miniproject.cbit;

//import com.google.android.gms.ads.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;


public class MainActivity extends Activity {
	
	public final static String BRANCH = "com.miniproject.cbit.BRANCH";
	public final static String YEAR = "com.miniproject.cbit.YEAR";
	public final static String ROLL_NUMBER = "com.miniproject.cbit.ROLLNUMBER";
	public final static String PASSWORD = "com.miniprojext.cbit.PASSWORD";
	public final static String ROUTE_NUMBER = "com.miniproject.cbit.ROUTENUMBER";
	private static final String PREF_PASSWORD = "com.miniproject.cbit.PREFPASSWORD";
	private static final String PREF_USERNAME = "com.miniproject.cbit.PREFUSERNAME";
	private static final String PREFS_NAME = "com.miniproject.cbit.PREF";
	final Context context = this;
	private Spinner spinner1, spinner2, spinner3;
	private CheckBox rememberme;
	private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    private PopupWindow popupMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        loginPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        
        //remember checked then
    	rememberme = (CheckBox) findViewById(R.id.rememberme);


        // new code popupInit();

        
        //button for attendance
        Button login_button = (Button) findViewById(R.id.button_login);
        login_button.setOnClickListener(new OnClickListener(){
        	
        	@Override
        	public void onClick(View arg1) {
        		
        		Intent i = new Intent(context, ShowAttendance.class);
        		saveLogin = loginPreferences.getBoolean("saveLogin", false);
        		EditText e1 = (EditText) findViewById(R.id.rollnumber_input);
            	String rollno = e1.getText().toString();
            	EditText e2 = (EditText) findViewById(R.id.password_input);
            	String pwd = e2.getText().toString();

            	if (saveLogin == true) {
                    e1.setText(loginPreferences.getString(PREF_USERNAME, ""));
                    e2.setText(loginPreferences.getString(PREF_PASSWORD, ""));
                    rememberme.setChecked(true);
                }
            	if (rememberme.isChecked()) {
                    loginPrefsEditor.putBoolean("saveLogin", true);
                    loginPrefsEditor.putString(PREF_USERNAME, rollno);
                    loginPrefsEditor.putString(PREF_PASSWORD, pwd);
                    loginPrefsEditor.commit();
                } else {
                    loginPrefsEditor.clear();
                    loginPrefsEditor.commit();
                }
            	//System.out.println(rollno + pwd);
            	if(!rollno.equals("null") && !pwd.equals("null"))
                {
                    i.putExtra(ROLL_NUMBER, rollno);
                    i.putExtra(PASSWORD, pwd);
                    startActivity(i);
                }
                else
                {
                    //have to add code
                }
        	}
        });
        
        //button for busroutes
       /* Button busroute_button = (Button) findViewById(R.id.button_busroute);
        busroute_button.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View arg2) {
        		
        		Intent b = new Intent(context, BusRoute.class);
        		String routeno = (spinner3.getSelectedItem().toString());
        		b.putExtra(ROUTE_NUMBER, routeno);
        		startActivity(b);
        		
        	}
        });
        */
        //Bus table route
        Button bustable_button = (Button) findViewById(R.id.button_bustable);
        bustable_button.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View arg3) {
        		
        		Intent bt = new Intent(context, ShowBusTable.class);
        		startActivity(bt);
        		
        	}
        });
        
     // Look up the AdView as a resource and load a request.
       // AdView adView = (AdView)this.findViewById(R.id.adView);
        //AdRequest adRequest = new AdRequest.Builder().build();
        //adView.loadAd(adRequest);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

   /* new code to be added
    public void popupInit() {
        popupMessage = new PopupWindow(layoutOfPopup, LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        popupMessage.setContentView(layoutOfPopup);
    }
*/

   //set Spinner for Bus Routes
    
    /*public void setSpinner3() {
    	ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
    	R.array.busroutes_array, android.R.layout.simple_spinner_item);
    	adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner3.setAdapter(adapter3);
    }*/
}


