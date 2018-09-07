package test;

import java.util.Calendar;

import bo.LessonLogic;
import model.Schedule;

public class tescal {

	public static void main(String[] args) {
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
	        if (day<9) {
	          System.out.print(" ");
	        }
	        //1日の開始位置を決める(スペース表示)
	        if (colweek<WD-1 && rowweek==0) {
	          System.out.print("  ");
	        //日数表示
	        }else if(day<LDM) {
	        	Calendar MC2=Calendar.getInstance();
	    		//int Y2=MC2.get(Calendar.YEAR);
	    		//int M2=MC2.get(Calendar.MONTH);
	    		//MC2.add(day,1);
	    		//MC2.set(Calendar.DATE,day);
	          //System.out.print((day+1)+" ");
	        	Schedule S=LLogic.showSchedule(day+1);
	        	//SL[day]=S;
	        	for(String n:S.getSchedule()){
	        		System.out.println(n);
	        	}
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
