package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.DefaultLessonLogic;
import model.Lesson;

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

					String strStart=request.getParameter("start");
					String strEnd=request.getParameter("end");
//					System.out.println(strStart);
//					System.out.println(strEnd);

					Lesson start=new Lesson();
					Lesson end=new Lesson();

//					start.setDate(strStart);
//					end.setDate(strEnd);

					request.setAttribute("start", start);
					request.setAttribute("end", end);

//					System.out.println(start);
//					System.out.println(end);

					DefaultLessonLogic dll=new DefaultLessonLogic();
					boolean result=dll.defaultLesson(strStart, strEnd);

					if(result){
						String msg=strStart+"～"+strEnd+"の基本レッスン枠を追加しました。";
						request.setAttribute("msg", msg);
						forwardPath="/WEB-INF/jsp/adLesson.jsp";
					}else{
						forwardPath="/WEB-INF/jsp/adLesson.jsp";
					}
				}

				RequestDispatcher dispatcher =
						request.getRequestDispatcher(forwardPath);
						dispatcher.forward(request, response);
			}
	}

