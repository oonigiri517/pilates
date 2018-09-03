package bo;
import java.util.Calendar;

import dao.LessonDAO;
import model.Schedule;
public class LessonLogic {
<<<<<<< HEAD
	public Lesson showSchedule(Calendar calendar){
while( ){
		Lesson le= new Lesson();
return le;
	}}
=======

	public Schedule showSchedule(Calendar calendar){
		calendar=Calendar.getInstance();
		int LY = calendar.get(Calendar.YEAR);
		int LM = calendar.get(Calendar.MONTH);
		int LD = calendar.get(Calendar.DATE);
		String sLM=String.valueOf(LM);
		String sLD=String.valueOf(LD);
		Calendar today=Calendar.getInstance();
		int Y=today.get(Calendar.YEAR);
		int M=today.get(Calendar.MONTH);
		int D=today.get(Calendar.DATE);
		today.set(Y,M,D);
		today.add(D,2);
		boolean N=calendar.after(today);
		String[] le= new String[4];
		if(N=false){
			le[1] = sLM;
			le[2]=sLD;
			le[3]="締切";
			le[4]="";


		}else{
			String DATE=sLM+"/"+sLD
			LessonDAO LDAO=new LessonDAO();
			LDAO.findDay(sLM,sLD);


		}
		Schedule sle=new Schedule(le);
return sle;
	}
>>>>>>> Branchテスト

}
