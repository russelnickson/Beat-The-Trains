package com.androidapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class widgets extends Activity {
    /** Called when the activity is first created. */
	static final double[] thiruvamyur_vb = new double[]{5.08, 5.38, 5.58, 6.18, 6.38, 6.58, 7.08, 7.18, 7.28, 7.43, 7.58, 8.13, 8.28, 8.38, 8.48,
		8.58, 9.08, 9.18, 9.28, 9.38, 9.48, 9.58, 10.08, 10.28, 10.48, 10.57, 11.07, 11.27, 11.47, 12.08,
		12.28, 12.48, 13.08, 13.28, 13.58, 14.28, 14.58, 15.28, 15.48, 16.18, 16.33, 16.48, 16.58, 17.08, 17.18,
		17.23, 17.33, 17.48, 17.58, 18.08, 18.18, 18.28, 18.38, 18.48, 18.58, 19.08, 19.18, 19.38, 19.58, 20.18,
		20.38, 20.58, 21.18, 21.43, 22.08, 22.38, 23.08,
		};
	static final double[] thiruvamyur_bv = new double[]{4.43,5.13,5.43,6.13,6.28,6.43,6.53,7.03,7.23,7.43,8.03,8.13,8.23,8.33,8.43,
		8.53,9.03,9.13,9.23,9.28,9.33,9.43,9.53,10.03,10.13,10.18,10.23,10.33,10.43,11.03,
		11.23,11.43,12.03,12.23,12.43,13.03,13.23,13.43,14.13,14.43,15.13,15.43,16.13,16.33,16.53,
		17.08,17.28,17.43,17.53,18.03,18.13,18.23,18.33,18.43,18.53,19.03,19.13,19.23,19.33,19.43,
		20.03,20.23,20.48,21.13,21.38,22.03,22.28
		
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
        while( value>thiruvamyur_vb[i] && i<120)
        {        	
        	i++;        	
        }
        
        int j = 0;
        while( value>thiruvamyur_bv[j] && j<120)
        {        	
        	j++;        	
        }

        final TextView upTime = (TextView) this.findViewById(R.id.train_upTime);
        final TextView downTime = (TextView) this.findViewById(R.id.train_downTime);
        upTime.setText(String.valueOf(thiruvamyur_vb[i]));
        downTime.setText(String.valueOf(thiruvamyur_bv[j]));
    }
}