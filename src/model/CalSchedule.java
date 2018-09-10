package model;

import java.io.Serializable;

public class CalSchedule implements Serializable {
	Schedule[] SLM;

	public CalSchedule() {
		super();
	}

	public CalSchedule(Schedule[] sLM) {
		super();
		SLM = sLM;
	}

	public Schedule[] getSLM() {
		return SLM;
	}

	public void setSLM(Schedule[] sLM) {
		SLM = sLM;
	}

}
