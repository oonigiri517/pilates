package bo;

import dao.LessonDAO;
import model.Lesson;

public class EditLogic {

	public boolean checkLogic(Lesson lesson){
		LessonDAO lso=new LessonDAO();
		return lso.check(lesson);
	}

	public boolean insertLogic(Lesson lesson){
		LessonDAO lso=new LessonDAO();
		return lso.insert(lesson);
	}

	public boolean deleteLogic(Lesson lesson) {
		LessonDAO lso =new LessonDAO();
		return lso.delete(lesson);
	}
}
