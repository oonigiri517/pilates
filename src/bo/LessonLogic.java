package bo;
import java.util.Calendar;

import model.Lesson;
public class LessonLogic {

	public Lesson showSchedule(Calendar calendar){
		calendar=Calendar.getInstance();
		Calendar today=Calendar.getInstance();
		int Y=today.get(Calendar.YEAR);
		int M=today.get(Calendar.MONTH);
		int D=today.get(Calendar.DATE);
		today.set(Y,M,D);
		today.add(D,2);
		boolean N=calendar.after(today);
		Lesson le= new Lesson();
return le;
	}

}
