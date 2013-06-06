package com.example.panchangam;

public class PanchangamLookup {
	private static int hour, minute, dayOfWeek;
	
	public static LookupResult get(int hour, int minute, int dayOfWeek) {
		PanchangamLookup.hour = hour;
		PanchangamLookup.minute = minute;
		PanchangamLookup.dayOfWeek = dayOfWeek;
		return _computeResult();
	}
	
	public static LookupResult get(int hour, int minute) {
		PanchangamLookup.hour = hour;
		PanchangamLookup.minute = minute;
		return _computeResult();
	}
	
	public static LookupResult get(int dayOfWeek) {
		PanchangamLookup.dayOfWeek = dayOfWeek;
		return _computeResult();
	}
	
	private static LookupResult _computeResult() {
		if (PanchangamLookup.dayOfWeek > 3) {
		  return new LookupResult("Hello", "World");
		} else {
		  return new LookupResult("Seoul", "Gowtham");
		}
	}
}
