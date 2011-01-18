package com.androidapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class widgets extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_timings);
        final TextView textboxx = (TextView) this.findViewById(R.id.text);
        final EditText edit_textx = (EditText) this.findViewById(R.id.edit);
        final Button button= (Button) this.findViewById(R.id.btn);
        button.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        	if(v==button) {
        		textboxx.setText(edit_textx.getText());
        		
        	}
        	}
        });
    }
}