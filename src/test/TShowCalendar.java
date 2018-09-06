package test;

import java.util.Calendar;

import bo.LessonLogic;
import model.Schedule;

public class TShowCalendar {

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
	        	MC.set(Y,M,day+1);
	        	LessonLogic LL=new LessonLogic();
	        	Schedule LT=LL.showSchedule(MC);
	        	String[] LTL=LT.getSchedule();
	        	for(int i=0;i<LTL.length;i++){
	        		System.out.println(LTL[i]);
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


