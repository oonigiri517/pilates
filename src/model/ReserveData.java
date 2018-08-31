package model;

import java.io.Serializable;

public class ReserveData implements Serializable {
	private String family_name;
	private String first_name;
	private String mail;
	private String confMail;
	private String tel;
	private String memo;

	public ReserveData(){}
	public ReserveData(String family_name,String first_name,
			String mail,String confMail,String tel,String memo){
		this.family_name=family_name;
		this.first_name=first_name;
		this.mail=mail;
		this.confMail=confMail;
		this.tel=tel;
		this.memo=memo;
	}
	public ReserveData(String mail){
		this.mail=mail;
	}

	public String getFamily_name() {return family_name;}
	public String getFirst_name() {return first_name;}
	public String getMail() {return mail;}
	public String getConfMail() {return confMail;}
	public String getTel() {return tel;}
	public String getMemo() {return memo;}

}
