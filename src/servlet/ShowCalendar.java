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

		/*Calendar MC=Calendar.getInstance();
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
	    RequestDispatcher disp = request.getRequestDispatcher("/showCalender.jsp");
		disp.forward(request, response);*/
		CalSchedule SLL=(CalSchedule) session.getAttribute("SLL");
		Schedule[] SLM=getSLM();



		System.out.println("<!DOCTYPE html>"+"<html>"+"<style type="text/css">"
		+"p {width: 100%;}"+"p.example { line-height: 50%;}"
		+"</style>"+
		<body>
			<%
				Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int day = 1;
				cal.set(year,month,day);
				int weekday = cal.get(Calendar.DAY_OF_WEEK) - 1;
				int maxDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			%>
			<%=year%>
			<%=month + 1%>
		<table border='1'>
		<tr>
			<%
			String[] week = { "Sun", "mon", "Tue", "Wed", "Thu", "Fri", "Sta" };
			%>
			<%for (int i = 0; i < 7; i++) { %>
				<td bgcolor="blue" align="center"><font color="white"><%=week[i]%></font></td>
			<% } %><tr>
			<%for (int i = 0; i < weekday; i++) { %>
				<td></td>
			<% } %>
			<%for(int d=1;d<=maxDate;d++){ %>
				<% if((d+weekday-1)%7==0){%>
				</tr><tr>
				<%} %>
			<td align="center"><%=d%><br /><table>
			<%for(int i=1;i<=4;i++){%>
				<tr><td>
		<%
		Schedule SSL=SLM[d-1];
		String[] SL=getSchedule();
		int sll = SL.length;
		switch(sll){

		case 3:
			System.out.print(SL[2]);
			break ;
		case 4:if(SL[3]=="満員"){ System.out.print( SL[2]+"<br>"+ SL[3]);}else{
			System.out.print("<form action="/servlet/Form" method="get">");
			System.out.print("<input type="button" name="LT" value="<%=SL[2]%>"> SL[3]");
			System.out.print("</form> ");}
			break;
			case 6:
			if(SL[3]=="満員"){System.out.print("SL[2]<br>SL[3]")}else{
			System.out.print('<form action="/servlet/Form" method="get">');
			System.out.print("<input type="button" name="LT" value="<%=SL[2]%>"> SL[3]");
			System.out.print("</form> ")}
			if(SL[5]=="満員"){System.out.print(SL[4]+"<br>"+SL[5]);}else{
			System.out.print('<form action="/servlet/Form" method="get">');
			System.out.print('<input type="button" name="LT" value="<%=SL[4]%>"> SL[5]')
			System.out.print('</form> ');}
			break;}
			default : break ;


		}



			}




}
}
