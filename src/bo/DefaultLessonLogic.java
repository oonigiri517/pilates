package bo;

import dao.DefaultLessonDAO;
//import model.Lesson;

public class DefaultLessonLogic {
//	public static void main(String[] args) {
//		String strStart="2018/9/15";
//		String strEnd="2019/1/15";
////		Lesson lesson1 = new Lesson("2018/9/15");
////		Lesson lesson2 = new Lesson("2019/1/15");
//		DefaultLessonLogic dl = new DefaultLessonLogic();
//		boolean result=dl.defaultLesson(strStart, strEnd);
//		if(result){
//			System.out.println("ok");
//		}else{
//			System.out.println("ng");
//		}
//	}

	public boolean defaultLesson(String strStart,String strEnd){
		DefaultLessonDAO dld = new DefaultLessonDAO();
		return dld.defaultInsert(strStart,strEnd);
	}
}
