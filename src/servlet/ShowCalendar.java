package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowCalendar")
public class ShowCalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar MC=Calendar.getInstance();
		int Y=MC.get(Calendar.YEAR);
		int M=MC.get(Calendar.MONTH);
		MC.set(Y,M,1);
		int D=MC.get(Calendar.DAY_OF_WEEK);//曜日を取得
		int LDM = MC.getActualMaximum(Calendar.DATE);//月の最終日を取得


	}

}
