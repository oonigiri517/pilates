package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OutPutDAO;
import model.Lesson;

@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String page = request.getParameter("page");

		String forwardPath = "";

		if(page.equals("1")) {
			forwardPath="/WEB-INF/jsp/inquiry.jsp";

			String lesson1=request.getParameter("lesson1");
			String lesson2=request.getParameter("lesson2");

			Lesson les1=new Lesson();
			les1.setDate(lesson1);

			Lesson les2=new Lesson();
			les2.setDate(lesson2);

			request.setAttribute("lesson1", les1);
			request.setAttribute("lesson2", les2);




			RequestDispatcher dis=request.getRequestDispatcher("/WEB-INF/jsp/inquiry.jsp");
			dis.forward(request, response);


		}else if(page.equals("2")) {

		OutPutDAO odao = new OutPutDAO() ;

		String csvData = odao.OutputCSV() ;

		//csvData = new String(csvData.getBytes("UTF-8"), "SHIFT-JIS");
		//ファイル名生成
		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd");
		String filename = simpleDataFormat.format(new Date()) + ".csv";

		//application/octet-stream
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	    response.setHeader("Content-Disposition"
	         , String.format("attachment; filename=\"%s\"", filename));
	         response.setCharacterEncoding("UTF-8");
	    //"attachment; filename=\"downloadFile.csv\""
	    OutputStream out = response.getOutputStream();
	    byte[] downloadData = csvData.getBytes("SHIFT-JIS");
	    out.write(downloadData);
	    out.close();

	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
