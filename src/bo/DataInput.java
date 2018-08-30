package bo;

import dao.DataDAO;
import model.Lesson;
import model.ReserveData;

public class DataInput {

	public boolean InputData(Lesson lesson,ReserveData rData){
		DataDAO dataDAO=new DataDAO();
		return dataDAO.insert(lesson, rData);
	}

}
