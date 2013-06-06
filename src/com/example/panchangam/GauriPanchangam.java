package com.example.panchangam;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class GauriPanchangam extends Activity {

	private TimePicker timePicker;
	private Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gauri_panchangam);
		timePicker = (TimePicker) findViewById(R.id.time_picker);
		spinner = (Spinner) findViewById(R.id.day_picker);

		initLayout();
		setupHandlers();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gauri_panchangam, menu);
		return true;
	}
	
	private void initLayout() {
		Calendar c = Calendar.getInstance();

		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		timePicker.setCurrentHour(hour);
		timePicker.setCurrentMinute(minute);
		
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		spinner.setSelection(dayOfWeek - 1, true);
		
		LookupResult result = PanchangamLookup.get(hour, minute, dayOfWeek);
		TextView twentyFourMin = (TextView) findViewById(R.id.twenty_four_min);
		TextView oneHalfHour = (TextView) findViewById(R.id.one_half_hour);
		twentyFourMin.setText(result.gettwentyFourMin());
		oneHalfHour.setText(result.getOneHalfHour());
	}
	
	private void setupHandlers() {
	    timePicker.setOnTimeChangedListener(new CustomOnTimeChangedListener());
	    spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}
	
	private class CustomOnItemSelectedListener implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int pos,
				long arg3) {
			LookupResult result = PanchangamLookup.get(pos + 1);
			TextView twentyFourMin = (TextView) findViewById(R.id.twenty_four_min);
			TextView oneHalfHour = (TextView) findViewById(R.id.one_half_hour);
			twentyFourMin.setText(result.gettwentyFourMin());
			oneHalfHour.setText(result.getOneHalfHour());
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class CustomOnTimeChangedListener implements TimePicker.OnTimeChangedListener {

		@Override
		public void onTimeChanged(TimePicker view, int hour, int minute) {
			LookupResult result = PanchangamLookup.get(hour, minute);
			TextView twentyFourMin = (TextView) findViewById(R.id.twenty_four_min);
			TextView oneHalfHour = (TextView) findViewById(R.id.one_half_hour);
			twentyFourMin.setText(result.gettwentyFourMin());
			oneHalfHour.setText(result.getOneHalfHour());
		}
	}

}
