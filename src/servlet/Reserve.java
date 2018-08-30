package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.DataCheck;
import bo.DataInput;
import model.Lesson;
import model.ReserveData;

@WebServlet("/Reserve")
public class Reserve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//栗栖のとあわせるまでこの形でやる！
		ReserveData rData=new ReserveData();
		Lesson lesson=new Lesson();

		DataCheck dc=new DataCheck();
		boolean result=dc.check(lesson, rData);

		if(result){
			DataInput di=new DataInput();
			di.InputData(lesson, rData);
			response.sendRedirect("/Pilates/Mail");
		}else{
//			RequestDispatcher disp=request.getRequestDispatcher("formConfirm.jsp");
//			disp.forward(request, response);
		}
	}

}
