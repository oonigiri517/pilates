package model;

import java.io.Serializable;

public class Cancel implements Serializable {
	private String number;
	private String date;
	private String mail;

	public Cancel(){}
	public Cancel(String number,String date,String mail) {
		this.number = number;
		this.date = date;
		this.mail = mail;
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


}
