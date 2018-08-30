package model;

import java.io.Serializable;

public class Lesson implements Serializable {
	String date;
	String time;
	public Lesson() {
		super();
	}
	public Lesson(String date, String time) {
		super();
		this.date = date;
		this.time = time;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}

}
