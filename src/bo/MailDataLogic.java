package bo;

import dao.DataDAO;
import model.Lesson;
import model.MailData;
import model.ReserveData;

public class MailDataLogic {

	public boolean rsvData(Lesson lesson, ReserveData rData) {
		DataDAO dataDAO = new DataDAO();
		MailData mailData = null;
		SendMail sm=new SendMail();

		mailData=dataDAO.findNum(lesson, rData);
		boolean result=sm.send(mailData);

		return result;
	}
}
