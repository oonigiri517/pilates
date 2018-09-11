package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditLesson")
public class EditLesson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String submit = request.getParameter("submit");

		//フォワード

				String forwardPath = "";
				if(submit.equals("追加")) {
					forwardPath="form.jsp";
				}else if(submit.equals("削除")) {
					forwardPath="/WEB-INF/jsp/cancel.jsp";
				}else if(submit.equals("基本枠追加")){
					forwardPath="login.jsp";
				}

				RequestDispatcher dispatcher =
						request.getRequestDispatcher(forwardPath);
						dispatcher.forward(request, response);
			}
	}

