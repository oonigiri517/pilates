package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String submit = request.getParameter("submit");

		//フォワード
		String forwardPath = "";
		if(submit.equals("レッスン日編集")) {
			forwardPath="/WEB-INF/jsp/adLesson.jsp";
		}else if(submit.equals("予約キャンセル")) {
			forwardPath="/WEB-INF/jsp/cancel.jsp";
		}else if(submit.equals("予約履歴")) {
			forwardPath="/WEB-INF/jsp/inquiry.jsp";
		}
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forwardPath);
				dispatcher.forward(request, response);
	}

}