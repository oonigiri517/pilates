package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.MailDataLogic;
import model.Lesson;
import model.ReserveData;

@WebServlet("/Mail")
public class Mail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		ReserveData rData=(ReserveData) session.getAttribute("reserveData");
		Lesson lesson=(Lesson) session.getAttribute("lesson");

		//データベースから予約番号・予約情報を取得
		MailDataLogic mdl =new MailDataLogic();
		boolean result=mdl.rsvData(lesson, rData);

		if(result){
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/reserved.jsp");
			disp.forward(request, response);
		}else{
			RequestDispatcher disp = request.getRequestDispatcher("form.jsp");
			disp.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
