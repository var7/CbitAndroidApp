package com.miniproject.cbit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ShowAttendance extends Activity {
	
	private String URL = "http://cbit.winnou.net/";
	private String rollno, password;
	private WebView w;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_attendance);
		
		//Get the roll no and pswd from the login screen
		Intent intent = getIntent();
		rollno = (intent.getStringExtra(MainActivity.ROLL_NUMBER));
		password = intent.getStringExtra(MainActivity.PASSWORD);
		
		//Initialize webview
		w = (WebView) findViewById(R.id.winnou);
		w.loadUrl(URL);
		w.getSettings().setJavaScriptEnabled(true);
		w.getSettings().setDomStorageEnabled(true);
		w.setWebViewClient(new WebViewClient() {
			//override onPageFinished to input login details
		    public void onPageFinished(WebView w, String url) {
		        String user = rollno;
		        String pwd = password;
		        w.loadUrl("javascript:document.querySelector('input[name=username]').value='"+user+"';document.querySelector('input[name=passwd]').value='"+pwd+"';document.getElementById('form-login').submit();");
		    }
		  
		});
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    // Check if the key event was the Back button and if there's history
			if ((keyCode == KeyEvent.KEYCODE_BACK) && w.canGoBack()) {
		        w.goBack();
		        return true;
			}
		    // If it wasn't the Back key or there's no web page history, bubble up to the default
		    // system behavior (probably exit the activity)
		    return super.onKeyDown(keyCode, event);
		}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_attendance, menu);
		return true;
	}

}
