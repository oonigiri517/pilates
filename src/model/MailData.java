package model;

import java.io.Serializable;

public class MailData implements Serializable {
	private String number;
	private String date;
	private String time;
	private String family_name;
	private String first_name;
	private String mail;

	public MailData(String number,String date,String time,String family_name,String first_name,String mail){
		this.number=number;
		this.date=date;
		this.time=time;
		this.family_name=family_name;
		this.first_name=first_name;
		this.mail=mail;
	}

	public MailData() {}

	public String getNumber() {return number;}
	public String getDate() {return date;}
	public String getTime() {return time;}
	public String getFamily_name() {return family_name;}
	public String getFirst_name() {return first_name;}
	public String getMail() {return mail;}

	public void setNumber(String number) {this.number = number;}
	public void setDate(String date) {this.date = date;}
	public void setTime(String time) {this.time = time;}
	public void setFamily_name(String family_name) {this.family_name = family_name;}
	public void setFirst_name(String first_name) {this.first_name = first_name;}
	public void setMail(String mail) {this.mail = mail;}

}
