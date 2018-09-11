package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.DefaultLessonLogic;
import bo.EditLogic;
import model.Lesson;

@WebServlet("/EditLesson")
public class EditLesson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String submit = request.getParameter("submit");
		boolean result = false;
		if (submit.equals("追加") || submit.equals("削除")) {
			String strLesson = request.getParameter("lesson");
			String strTime = request.getParameter("time");

			Lesson lesson = new Lesson(strLesson, strTime);

			request.setAttribute("lesson", lesson);

			EditLogic ed = new EditLogic();
			// 日付が未選択だったら
			if (strLesson.isEmpty() || strTime.isEmpty()) {
				String msg = "日時を選択してください";
				request.setAttribute("msg", msg);

			} else {

				if (submit.equals("追加")) {
					result = ed.checkLogic(lesson);
					if (result) {
						result = ed.insertLogic(lesson);
						if (result) {
							String msg = strLesson + " " + strTime + "の<br>レッスン枠を追加しました。";
							request.setAttribute("msg", msg);
						}
					} else {
						String msg = "既に2件のレッスン枠が登録済みです。<br>" + "レッスン枠を削除してから追加してください。";
						request.setAttribute("msg", msg);
					}

				} else if (submit.equals("削除")) {
					result = ed.deleteLogic(lesson);
					if (result) {
						String msg = strLesson + " " + strTime + "の<br>レッスン枠を削除しました。";
						request.setAttribute("msg", msg);
					} else {
						String msg = "該当レッスン枠がありません";
						request.setAttribute("msg", msg);
					}
				}
			}
		} else if (submit.equals("基本枠追加")) {

			String strStart = request.getParameter("start");
			String strEnd = request.getParameter("end");

			if (strStart.isEmpty() || strEnd.isEmpty()) {
				String msg = "期間を選択してください";
				request.setAttribute("msg", msg);
			} else {
				Lesson start = new Lesson(strStart);
				Lesson end = new Lesson(strEnd);

				request.setAttribute("start", start);
				request.setAttribute("end", end);

				DefaultLessonLogic dll = new DefaultLessonLogic();
				result = dll.defaultLesson(strStart, strEnd);

				if (result) {
					String msg = strStart + "～" + strEnd + "の<br>基本レッスン枠を追加しました。";
					request.setAttribute("msg", msg);
				} else {
					String msg = "入力期間を確認してください";
					request.setAttribute("msg", msg);
				}
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/adLesson.jsp");
		dispatcher.forward(request, response);
	}
}
