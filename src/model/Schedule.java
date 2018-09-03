package model;

import java.io.Serializable;

public class Schedule implements Serializable {
	String[] schedule;

	public Schedule() {}

	public Schedule(String[] schedule) {
		super();
		this.schedule = schedule;
	}

	public String[] getSchedule() {
		return schedule;
	}

	public void setSchedule(String[] schedule) {
		this.schedule = schedule;
	}


}
