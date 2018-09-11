package bo;

import dao.LessonDAO;
import model.Lesson;

public class EditLogic {
	public static void main(String[] args) {
		Lesson lesson=new Lesson("2019/01/14","10:00");
		EditLogic el=new EditLogic();
		boolean result=el.checkLogic(lesson);
		if(result){
			System.out.println("OK");
		}else{
			System.out.println("NG");
		}
	}

	public boolean checkLogic(Lesson lesson) {
		LessonDAO lso = new LessonDAO();
		return lso.check(lesson);
	}

	public boolean insertLogic(Lesson lesson) {
		LessonDAO lso = new LessonDAO();
		return lso.insert(lesson);
	}

	public boolean deleteLogic(Lesson lesson) {
		LessonDAO lso = new LessonDAO();
		return lso.delete(lesson);
	}
}
