package model;

import java.io.Serializable;

public class Schedule implements Serializable {
	String[] Schedule;

	public Schedule() {}

	public Schedule(String[] schedule) {
		super();
		Schedule = schedule;
	}

	public String[] getSchedule() {
		return Schedule;
	}

	public void setSchedule(String[] schedule) {
		Schedule = schedule;
	}


}
