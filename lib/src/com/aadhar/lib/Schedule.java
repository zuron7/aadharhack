package com.aadhar.lib;

public class Schedule {
	private int day;
	private int period;
	private int subject;

	public Schedule(int day, int period, int subject) {
		super();
		this.day = day;
		this.period = period;
		this.subject = subject;
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

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}
}
