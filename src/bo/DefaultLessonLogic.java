package bo;

import dao.DefaultLessonDAO;
import model.Lesson;

public class DefaultLessonLogic {
	public static void main(String[] args) {
		Lesson lesson = new Lesson("2018/9/15", "14:00");
		DefaultLessonDAO dld = new DefaultLessonDAO();
		dld.defaultInsert(lesson);
	}
}
