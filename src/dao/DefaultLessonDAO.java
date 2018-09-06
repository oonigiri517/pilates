package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import model.Lesson;

public class DefaultLessonDAO {

	public static void main(String[] args) {
		Lesson lesson = new Lesson("2018/9/15", "14:00");
		DefaultLessonDAO dld = new DefaultLessonDAO();
		dld.defaultInsert(lesson);
	}

	public boolean defaultInsert(Lesson lesson) {
		final String DRIVER_NAME = "com.mysql.jdbc.Driver";
		final String JDBC_URL = "jdbc:mysql://localhost/pilates?useSSL=false";
		final String DB_USER = "root";
		final String DB_PASS = "root";
		Connection conn = null;

		boolean result = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		// 現在時間
		Calendar nowCal = Calendar.getInstance();

		//期間入力フォームからとってきた日付
		String str = lesson.getDate();
		Calendar calEnd = new GregorianCalendar();

		// strの日をcalEndにセット
		try {
			calEnd.setTime(DateFormat.getDateInstance().parse(str.replace("-", "/")));
		} catch (ParseException e) {
			calEnd = null;
		}

		// モジュール化する？
//		String[] defaultLessonTimes = { "10:00", "14:00" };

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
//			int firstSQLResult = 0;// 帰ってきた件数チェック(0件なら入ってない)

			// lessonテーブルにデータを挿入
			String sql = "insert into lesson (date,time)value(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

//			while (nowCal.compareTo(calEnd) < 0) {
		        String now=sdf.format(nowCal.getTime());
//				int D = nowCal.get(Calendar.DAY_OF_WEEK);
//				if (D == 2 || D == 3 || D == 5 || D == 6) {
//					for (String time : defaultLessonTimes) {
						pStmt.setString(1, "2018年08月05日");
						pStmt.setString(2, "10:00");
//					}
//					nowCal.add(Calendar.DATE, 1);// 1日追加
//				}
//			}

//			firstSQLResult = pStmt.executeUpdate();// 成功時は必ず1、失敗時は0
//		// 1回目がfalse、2回目がtrueのときも通っちゃうからダメ
//		if (firstSQLResult > 0) {
//			result = true;
//		}
		return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
	}
}
