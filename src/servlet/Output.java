package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OutPutDAO;

@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		OutPutDAO odao = new OutPutDAO() ;

		String csvData = odao.OutputCSV() ;

		//csvData = new String(csvData.getBytes("UTF-8"), "SHIFT-JIS");
		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd");
		String filename = simpleDataFormat.format(new Date()) + ".xlsx";
		//application/octet-stream
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	    response.setHeader("Content-Disposition"
	         , String.format("attachment; filename=\"%s\"", filename));
	         response.setCharacterEncoding("UTF-8");
	    //"attachment; filename=\"downloadFile.csv\""
	    OutputStream out = response.getOutputStream();
	    byte[] downloadData = csvData.getBytes();
	    out.write(downloadData);
	    out.close();

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
