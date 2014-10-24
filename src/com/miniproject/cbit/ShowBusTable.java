package com.miniproject.cbit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ShowBusTable extends Activity {

	private String URL = "file:///android_asset/list routes/list routes.htm";
	private WebView wv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_bus_table);
		
		Intent intent = getIntent();
		wv  = (WebView) findViewById(R.id.show_table);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.loadUrl(URL);
		wv.setWebViewClient(new WebViewClient());
		wv.getSettings().setBuiltInZoomControls(true);

		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
    // Check if the key event was the Back button and if there's history
		if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) {
	        wv.goBack();
	        return true;
		}
	    // If it wasn't the Back key or there's no web page history, bubble up to the default
	    // system behavior (probably exit the activity)
	    return super.onKeyDown(keyCode, event);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.show_syllabus, menu);
		return true;
	}
	
	
	
}
