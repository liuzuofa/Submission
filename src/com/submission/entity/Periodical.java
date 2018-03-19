package com.submission.entity;

public class Periodical {
	
	private int id;
	private String year;
	private String month;
	private String state;
	public Periodical(String year, String month, String state) {
		super();
		this.year = year;
		this.month = month;
		this.state = state;
	}
	public Periodical(int id, String year, String month, String state) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
}
