package test;

import java.util.Calendar;

import bo.LessonLogic;
import model.Schedule;

public class tescal {

	public static void /*showC()*/main(String[] args) {
		Calendar MC=Calendar.getInstance();
		int Y=MC.get(Calendar.YEAR);
		int M=MC.get(Calendar.MONTH);
		MC.set(Y,M,1);
		int WD=MC.get(Calendar.DAY_OF_WEEK);//曜日を取得
		MC.add(Calendar.MONTH,1);
		MC.add(Calendar.DATE,-1);
		int LDM = MC.get(Calendar.DATE);//月の最終日を取得
		int day=0;
		//Schedule[] SL=new Schedule[LDM];

		LessonLogic LLogic=new LessonLogic();
	    for (int rowweek=0; rowweek<6; rowweek++) {
	      for (int colweek=0; colweek<7; colweek++) {
	        //9日以下はスペースを追加

	        	Schedule S=LLogic.showSchedule(day+1);

	        	for(String n:S.getSchedule()){
	        		System.out.println(n);
	        	day++;
	        }
	      }
	      //改行をmaxdate以上は行わない
	      if (day<LDM) {
	      	System.out.print("\n");
	      }
	    }


	}

}
