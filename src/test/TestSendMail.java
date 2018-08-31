package test;

import dao.DataDAO;
import model.MailData;

public class TestSendMail {
	public static void main(String[] args) {


		testFindNum(lesson, rData);

	}

	public static void testFindNum(MailData mailData){
		DataDAO dataDAO=new DataDAO();
		MailData mailData = null;

		mailData = dataDAO.findNum(lesson, rData);

		if(mailData != null){
			System.out.println("成功");
		}else{
			System.out.println("失敗");
		}
	}

}
