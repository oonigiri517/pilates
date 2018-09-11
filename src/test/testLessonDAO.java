package test;

import dao.LessonDAO;
import model.Lesson;

public class testLessonDAO {
	public static void main(String[] args) {
		Lesson lesson=new Lesson("2018/08/28","10:00");
		testLessonDAO tdao = new testLessonDAO();

		boolean result = tdao.lessonLogic(lesson);
		if (result) {
			System.out.println("ok");
		} else {
			System.out.println("ng");
		}
	}

	public boolean lessonLogic(Lesson lesson){
		LessonDAO lso=new LessonDAO();
		return lso.insert(lesson);
	}
}