package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.DataCheck;
import bo.DataInput;
import model.Lesson;
import model.ReserveData;

@WebServlet("/Reserve")
public class Reserve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ReserveData rData=(ReserveData) session.getAttribute("reserveData");
		Lesson lesson=(Lesson) session.getAttribute("lesson");

		DataCheck dc=new DataCheck();
		boolean result=dc.check(lesson, rData);

		if(result){
			DataInput di=new DataInput();
			di.InputData(lesson, rData);
			response.sendRedirect("/Pilates/Mail");
		}else{
			HashMap<String,String> emsRsv = new HashMap<String,String>();
			emsRsv.put("reserved","既にご予約をいただいております。"
					+ "<br>ご予約内容等お問い合わせは"
					+ "<br>relax.pilates123@gmail.comでお願いいたします。");
			request.setAttribute("emsRsv", emsRsv);
			//From.javaで予約が重複しているエラーを出す。。
			RequestDispatcher disp=request.getRequestDispatcher("/WEB-INF/jsp/formConfirm.jsp");
			disp.forward(request, response);
		}
	}
}
