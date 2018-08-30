package bo;

import dao.DataDAO;
import model.Lesson;
import model.MailData;
import model.ReserveData;

public class MailDataLogic {

	public MailData rsvData(Lesson lesson, ReserveData rData) {

		DataDAO dataDAO = new DataDAO();
		MailData mailData = new MailData();
		return mailData=dataDAO.findNum(lesson, rData);
	}
}
