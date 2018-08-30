package bo;

import dao.DataDAO;
import model.Lesson;
import model.ReserveData;

public class DataCheck {
	public boolean check(Lesson lesson,ReserveData rData){
		DataDAO dataDAO=new DataDAO();
		return dataDAO.check(lesson, rData);
	}
}
