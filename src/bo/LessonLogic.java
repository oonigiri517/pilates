package bo;
import java.util.Calendar;

import model.Lesson;
public class LessonLogic {

	public Lesson showSchedule(Calendar calendar){
		Calendar today=Calendar.getInstance();
		int M=today.get(Calendar.MONTH);
		int D=today.get(Calendar.DATE);
		Lesson le= new Lesson();
return le;
	}

}
