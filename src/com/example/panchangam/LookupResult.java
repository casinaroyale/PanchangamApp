package com.example.panchangam;

public class LookupResult {
	private String twentyFourMin;
	private String oneHalfHour;
	public LookupResult(String twentyFourMin, String oneHalfHour) {
		super();
		this.twentyFourMin = twentyFourMin;
		this.oneHalfHour = oneHalfHour;
	}
	public String gettwentyFourMin() {
		return twentyFourMin;
	}
	public void settwentyFourMin(String twentyFourMin) {
		this.twentyFourMin = twentyFourMin;
	}
	public String getOneHalfHour() {
		return oneHalfHour;
	}
	public void setOneHalfHour(String oneHalfHour) {
		this.oneHalfHour = oneHalfHour;
	}
}
