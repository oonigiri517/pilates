package bo;

public class ReservedLogic {

	private String number;
	private String date;
	private String mail;

	public ReservedLogic(String number,String date,String mail) {
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
