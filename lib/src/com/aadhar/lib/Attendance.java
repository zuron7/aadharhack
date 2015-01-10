package com.aadhar.lib;

public class Attendance {
	private String studentId;
	private int year;
	private int week;
	private int day;
	private int period;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getWeek() {
		return week;
	}

	public Attendance(String studentId, int year, int week, int day, int period) {
		super();
		this.studentId = studentId;
		this.year = year;
		this.week = week;
		this.day = day;
		this.period = period;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}
}
