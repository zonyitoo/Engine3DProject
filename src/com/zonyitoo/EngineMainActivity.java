package com.zonyitoo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EngineMainActivity extends Activity {
    Button boxtest;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        boxtest = (Button) findViewById(R.id.button_testbox);
        boxtest.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(EngineMainActivity.this, ExampleScrollingBox.class));
				
			}
        	
        });
    }
}