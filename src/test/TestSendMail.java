package test;

import bo.SendMail;
import dao.DataDAO;
import model.Lesson;
import model.MailData;
import model.ReserveData;

public class TestSendMail {
	public static void main(String[] args) {
		Lesson lesson=new Lesson("2018/08/28","10:00");
		ReserveData rData=new ReserveData("山田","花子","yamada@mail.com","yamada@mail.com","090-0000-9999","test");

		DataDAO dataDAO = new DataDAO();

		MailData mailData=dataDAO.findNum(lesson, rData);

		testSendMail(mailData);
	}

	public static void testSendMail(MailData mailData){
		SendMail sendMail=new SendMail();
		boolean result = sendMail.send(mailData);
		if(result){
			System.out.println("成功");
		}else{
			System.out.println("失敗");
		}
	}
	public static MailData testFindNum(Lesson lesson, ReserveData rData){
		DataDAO dataDAO=new DataDAO();
		MailData mailData = null;

		mailData = dataDAO.findNum(lesson, rData);
		return mailData;
	}
}
