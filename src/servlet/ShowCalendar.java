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
		Calendar today=Calendar.getInstance();
		int Y=today.get(Calendar.YEAR);
		int M=today.get(Calendar.MONTH);
		int D=today.get(Calendar.DATE);
		today.set(Y,M,1);
	}

}
