package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cancel;

@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String number = request.getParameter("number");
		String date = request.getParameter("date");
		String mail = request.getParameter("mail");

		//セッションスコープに保存
		Cancel cancel = new Cancel(number,date,mail);
		HttpSession session = request.getSession();
		session.setAttribute("cancel", cancel);

		//フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/cancelConfirm.jsp");
				dispatcher.forward(request, response);

	}

}
