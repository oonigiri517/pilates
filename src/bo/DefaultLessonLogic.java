package bo;

import dao.DefaultLessonDAO;

public class DefaultLessonLogic {

	public boolean defaultLesson(String strStart,String strEnd){
		DefaultLessonDAO dld = new DefaultLessonDAO();
		return dld.defaultInsert(strStart,strEnd);
	}
}
