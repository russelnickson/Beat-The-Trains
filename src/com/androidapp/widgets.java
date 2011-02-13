package com.androidapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class widgets extends Activity {
    /** Called when the activity is first created. */
	static final double[] thiruvamyur_vb = new double[]{5.08, 5.38, 5.58, 6.18, 6.38, 6.58, 7.08, 7.18, 7.28, 7.43, 7.58, 8.13, 8.28, 8.38, 8.48,
		  
		};
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_timings);
        Bundle b = getIntent().getExtras(); 
        int h = b.getInt("hour", 0);
        int m = b.getInt("min", 0);
        double value = h + m * 0.01 ;
        int i = 0;
        while( value>thiruvamyur_vb[i] && i<8)
        {        	
        	i++;        	
        }
        i++;
        final TextView upTime = (TextView) this.findViewById(R.id.train_upTime);
        final TextView downTime = (TextView) this.findViewById(R.id.train_downTime);
        upTime.setText(String.valueOf(thiruvamyur_vb[i]));
        downTime.setText(String.valueOf(thiruvamyur_vb[i]));
    }
}