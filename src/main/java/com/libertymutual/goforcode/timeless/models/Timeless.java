package com.libertymutual.goforcode.timeless.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

public class Timeless {

	private double mondayHours;
	private double tuesdayHours;
	private double wednesdayHours;
	private double thursdayHours;
	private double fridayHours;
	private double totalHours;
	private String date;
	
	public void setMondayHours(double mondayHours) {
		this.mondayHours += mondayHours; 
	}
	
	public double getMondayHours() {
		return mondayHours;
	}
	
	public void setTuesdayHours(double tuesdayHours) {
		this.tuesdayHours += tuesdayHours; 
	}
	
	public double getTuesdayHours() {
		return tuesdayHours;
	}

	public double getWednesdayHours() {
		return wednesdayHours;
	}

	public void setWednesdayHours(double wednesdayHours) {
		this.wednesdayHours = wednesdayHours;
	}

	public double getThursdayHours() {
		return thursdayHours;
	}

	public void setThursdayHours(double thursdayHours) {
		this.thursdayHours = thursdayHours;
	}

	public double getFridayHours() {
		return fridayHours;
	}

	public void setFridayHours(double fridayHours) {
		this.fridayHours = fridayHours;
	}
	
	public void calculateTotalHours() {
		totalHours += (mondayHours + tuesdayHours + wednesdayHours + thursdayHours + fridayHours);
	}

	public double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}

}
