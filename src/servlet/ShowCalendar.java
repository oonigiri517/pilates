package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.LessonLogic;
import model.CalSchedule;
import model.Schedule;

@WebServlet("/ShowCalendar")
public class ShowCalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Calendar MC=Calendar.getInstance();
		int Y=MC.get(Calendar.YEAR);
		int M=MC.get(Calendar.MONTH);
		MC.set(Y,M,1);
		MC.add(Calendar.MONTH,1);
		MC.add(Calendar.DATE,-1);
		int LDM = MC.get(Calendar.DATE);//月の最終日を取得
		Schedule[] SL=new Schedule[LDM];

		LessonLogic LLogic=new LessonLogic();
	    for (int day=0;day<LDM;day++) {
	        	Schedule S=LLogic.showSchedule(day+1);
	        	SL[day]=S;
	        }
	    CalSchedule SLL=new CalSchedule();
	    HttpSession session=request.getSession();
	    session.setAttribute("SLL", SLL);
	    RequestDispatcher disp = request.getRequestDispatcher(/showCalender.jsp);
		disp.forward(request, response);


	      }




}
