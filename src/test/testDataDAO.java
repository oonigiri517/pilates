package test;

import dao.DataDAO;
import model.Lesson;
import model.ReserveData;

public class testDataDAO {
	public static void main(String[] args) {
		testcheckOK();
		testInsertOK();
	}

	public static void testcheckOK(){
		Lesson lesson=new Lesson();
		ReserveData rData=new ReserveData();

		DataDAO dataDAO=new DataDAO();

		boolean result=dataDAO.check(lesson, rData);
		if(!result){
			System.out.println("成功");
		}else{
			System.out.println("失敗");
		}
	}

	public static void testInsertOK(){
		Lesson lesson=new Lesson();
		ReserveData rData=new ReserveData();

		DataDAO dataDAO=new DataDAO();

		boolean result=dataDAO.insert(lesson, rData);

		if(result){
			System.out.println("成功");
		}else{
			System.out.println("失敗");
		}
	}

}
