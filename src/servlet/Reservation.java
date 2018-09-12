package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.ReservedLogic;
import model.Cancel;

@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String abc = request.getParameter("abc");
		HttpSession session = request.getSession();

		//フォワード
		String forwardPath = "";
		if(abc.equals("確認")) {
			String number = request.getParameter("number");
			String date = request.getParameter("date");
			String mail = request.getParameter("mail");

			//セッションスコープに保存
			Cancel cancel = new Cancel(number,date,mail);

			session.setAttribute("cancel", cancel);
			forwardPath ="/WEB-INF/jsp/cancelConfirm.jsp";

		}else if(abc.equals("キャンセル確定")) {
			Cancel cancel=(Cancel) session.getAttribute("cancel");
			ReservedLogic reservedLogic = new ReservedLogic();
			boolean result = reservedLogic.cancelLogic(cancel);
		    if(result) {
		    	String msg = "取り消し完了しました。";
				request.setAttribute("msg", msg);
		    }else {
		    	String msg = "該当する予約がありません。";
				request.setAttribute("msg", msg);
		    }
			forwardPath = "/WEB-INF/jsp/cancelConfirm.jsp";

		}else if(abc.equals("戻る")){
			forwardPath ="/WEB-INF/jsp/cancel.jsp";
		}
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forwardPath);
				dispatcher.forward(request, response);

	}

}
