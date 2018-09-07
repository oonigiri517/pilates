package model;

import java.io.Serializable;

public class Cancel implements Serializable {
	private String number;
	private String date;
	private String mail;
	private String time;

	public Cancel(){}
	public Cancel(String number,String date,String mail) {
		this.number = number;
		this.date = date;
		this.mail = mail;
		this.time = time;
	}
	public String getNumber() {
		return number;
	}
	public String getDate() {
		return date;
	}
	public String getMail() {
		return mail;
	}
	public String getTime() {
		return time;
	}


}
