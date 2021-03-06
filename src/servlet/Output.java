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
import dao.OutputDAO2;
import model.Lesson;

@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	//
	// }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String submit = request.getParameter("submit");

		if (submit.equals("出力")) {
			String lesson1 = request.getParameter("lesson1");
			String lesson2 = request.getParameter("lesson2");
			if (lesson1.isEmpty() || lesson2.isEmpty()) {
		    	String msg = "期間を選択してください";
				request.setAttribute("msg", msg);
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("/WEB-INF/jsp/inquiry.jsp");
						dispatcher.forward(request, response);
			} else {
				Lesson les1 = new Lesson();
				Lesson les2 = new Lesson();

				les1.setDate(lesson1);
				les2.setDate(lesson2);

				request.setAttribute("les1", les1);
				request.setAttribute("les2", les2);

				OutputDAO2 out2 = new OutputDAO2();
				String csvData = out2.OutputCSV(lesson1, lesson2);

				// csvData = new String(csvData.getBytes("UTF-8"), "SHIFT-JIS");
				// ファイル名生成
				SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd");
				String filename = simpleDataFormat.format(new Date()) + "reservation.csv";

				// application/octet-stream
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", filename));
				response.setCharacterEncoding("UTF-8");
				// "attachment; filename=\"downloadFile.csv\""
				OutputStream out = response.getOutputStream();
				byte[] downloadData = csvData.getBytes("SHIFT-JIS");
				out.write(downloadData);
				out.close();
			}

		} else if (submit.equals("顧客一覧")) {
			OutPutDAO odao = new OutPutDAO();

			String csvData = odao.OutputCSV();

			// csvData = new String(csvData.getBytes("UTF-8"), "SHIFT-JIS");
			// ファイル名生成
			SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd");
			String filename = simpleDataFormat.format(new Date()) + "customer.csv";

			// application/octet-stream
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", filename));
			response.setCharacterEncoding("UTF-8");
			// "attachment; filename=\"downloadFile.csv\""
			OutputStream out = response.getOutputStream();
			byte[] downloadData = csvData.getBytes("SHIFT-JIS");
			out.write(downloadData);
			out.close();
		}

	}

}
