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

					if(strStart.isEmpty()||strEnd.isEmpty()){
						String msg="日付を選択してください";
						request.setAttribute("msg", msg);
						forwardPath="/WEB-INF/jsp/adLesson.jsp";

					}else{

						Lesson start=new Lesson(strStart);
						Lesson end=new Lesson(strEnd);

						request.setAttribute("start", start);
						request.setAttribute("end", end);

						DefaultLessonLogic dll=new DefaultLessonLogic();
						boolean result=dll.defaultLesson(strStart, strEnd);

						if(result){
							String msg=strStart+"～"+strEnd+"の<br>基本レッスン枠を追加しました。";
							request.setAttribute("msg", msg);
							forwardPath="/WEB-INF/jsp/adLesson.jsp";
						}else{
							String msg="入力期間を確認してください";
							request.setAttribute("msg", msg);
							forwardPath="/WEB-INF/jsp/adLesson.jsp";
						}
					}

				}

				RequestDispatcher dispatcher =
						request.getRequestDispatcher(forwardPath);
						dispatcher.forward(request, response);
			}
	}

