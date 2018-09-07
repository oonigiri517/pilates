package model;

import java.io.Serializable;

public class CalSchedule implements Serializable {
	Schedule[] schedule;

	public CalSchedule() {
		super();
	}

	public CalSchedule(Schedule[] schedule) {
		super();
		this.schedule = schedule;
	}

	public Schedule[] getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule[] schedule) {
		this.schedule = schedule;
	}

}
