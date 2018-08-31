package test;

import dao.DataDAO;
import model.Lesson;
import model.MailData;
import model.ReserveData;

public class testDataDAO {
	public static void main(String[] args) {
		Lesson lesson=new Lesson("20180828","10:00");
		ReserveData rData=new ReserveData("金本","泰平","kanemoto@mail.com","kanemoto@mail.com","090-0000-9999","test");

		testFindNum(lesson, rData);
		testcheckOK(lesson, rData);
		testInsertOK(lesson, rData);

	}

	public static void testFindNum(Lesson lesson, ReserveData rData){
		DataDAO dataDAO=new DataDAO();
		MailData mailData = null;

		mailData = dataDAO.findNum(lesson, rData);

		if(mailData != null){
			System.out.println("成功");
		}else{
			System.out.println("失敗");
		}
	}

	public static void testcheckOK(Lesson lesson, ReserveData rData){
		DataDAO dataDAO=new DataDAO();

		boolean result=dataDAO.check(lesson, rData);
		if(!result){
			System.out.println("成功");
		}else{
			System.out.println("失敗");
		}
	}

	public static void testInsertOK(Lesson lesson, ReserveData rData){
		DataDAO dataDAO=new DataDAO();

		boolean result=dataDAO.insert(lesson, rData);

		if(result){
			System.out.println("成功");
		}else{
			System.out.println("失敗");
		}
	}

}
