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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String page = request.getParameter("page");

		//フォワード
		String forwardPath = "";
		if(page.equals("l1")) {
			forwardPath="/WEB-INF/jsp/adLesson.jsp";
		}else if(page.equals("l2")) {
			forwardPath="/WEB-INF/jsp/cancel.jsp";
		}else if(page.equals("l3")) {
			forwardPath="/WEB-INF/jsp/inquiry.jsp";
		}
		//admin画面のボタンを押せば直るのでページ遷移不要
//		else if(page.equals("l4")) {
//			forwardPath="/WEB-INF/jsp/customer.jsp";
//		}
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forwardPath);
				dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}