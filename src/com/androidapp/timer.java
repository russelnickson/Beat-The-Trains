package com.androidapp;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class timer extends Activity {
    /** Called when the activity is first created. */
	static final String[] COUNTRIES = new String[] {
		  "Velacherry", "Perungudi", "Tharamani", "Thiruvanmiyur", "Indira Nagar",
		  "Kasthurba Nagar", "Kotturpuram", "Greenways Road", "Mandaveli", "Thirumayilai",
		  "Light House", "Chepak", "Chintadripet", "Park Town",
		  "Chennai Fort", "Chennai Beach"
		};
	private TextView mDateDisplay;
	private Button mPickDate;
	private int mYear;
	private int mMonth;
	private int mDay;
    static final int DATE_DIALOG_ID = 0;
    private void updateDisplayDate() {
        mDateDisplay.setText(
            new StringBuilder()
                    // Month is 0 based so add 1
                    .append(mMonth + 1).append("-")
                    .append(mDay).append("-")
                    .append(mYear).append(" "));
    }
    private DatePickerDialog.OnDateSetListener mDateSetListener =
        new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, 
                                  int monthOfYear, int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                updateDisplayDate();
            }
        };
        
    private TextView mTimeDisplay;
    private Button mPickTime;
    private int mHour;
    private int mMinute;
    static final int TIME_DIALOG_ID = 1;
    
    private void updateDisplayTime() {
        mTimeDisplay.setText(
            new StringBuilder()
                    .append(pad(mHour)).append(":")
                    .append(pad(mMinute)));
    }

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
 // the callback received when the user "sets" the time in the dialog
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
        new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mHour = hourOfDay;
                mMinute = minute;
                updateDisplayTime();
            }
        };
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	 // capture our View elements
        mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
        mPickDate = (Button) findViewById(R.id.pickDate);

        // add a click listener to the button
        mPickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        // get the current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // display the current date (this method is below)
        updateDisplayDate();
        
     // capture our View elements
        mTimeDisplay = (TextView) findViewById(R.id.timeDisplay);
        mPickTime = (Button) findViewById(R.id.pickTime);

        // add a click listener to the button
        mPickTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });

        // get the current time
        final Calendar ct = Calendar.getInstance();
        mHour = ct.get(Calendar.HOUR_OF_DAY);
        mMinute = ct.get(Calendar.MINUTE);

        // display the current date
        updateDisplayTime();
        
	    Spinner spinner = (Spinner) findViewById(R.id.spinner);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this, R.array.day_array, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner.setAdapter(adapter);
	    
	    AutoCompleteTextView textView1 = (AutoCompleteTextView) findViewById(R.id.autocomplete_country);
	    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.list_item, COUNTRIES);
	    textView1.setAdapter(adapter1);
	    
	    final Button button= (Button) this.findViewById(R.id.btn);
        button.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        	if(v==button) {
        		Intent myIntent = new Intent(timer.this, widgets.class);
    		    timer.this.startActivity(myIntent);        		
        	}
        	}
        });
	}
	@Override
	protected Dialog onCreateDialog(int id) {
	    if (id == DATE_DIALOG_ID) 
	    	return new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay);
	    else
	    	return new TimePickerDialog(this, mTimeSetListener, mHour, mMinute, false);
	}
		public class MyOnItemSelectedListener implements OnItemSelectedListener {

	    public void onItemSelected(AdapterView<?> parent,View view, int pos, long id) {
	    	Toast.makeText(parent.getContext(), "The planet is " +
	    	parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
		}

	    @SuppressWarnings("unchecked")
		public void onNothingSelected(AdapterView parent) {
	    }
	}
}
