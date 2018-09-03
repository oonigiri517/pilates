package dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import model.Lesson;

public class DefaultLessonDAO {
	// final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	// final String JDBC_URL = "jdbc:mysql://localhost/pilates";
	// final String DB_USER = "root";
	// final String DB_PASS = "root";
	// Connection conn = null;

	public static void main(String[] args) {
		Lesson lesson = new Lesson("2018/12/31", "14:00");
		DefaultLessonDAO dld = new DefaultLessonDAO();
		dld.defaultInsert(lesson);
	}

	public boolean defaultInsert(Lesson lesson) {
		// Connection conn = null;
		// int firstSQLResult = 0;// 帰ってきた件数チェック(0件なら入ってない)
		boolean result = false;
		// try {
		// Class.forName(DRIVER_NAME);
		// conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

		String str = "2018/09/10";
		Calendar calEnd = new GregorianCalendar();
		try {
			calEnd.setTime(DateFormat.getDateInstance().parse(str.replace("-", "/")));
		} catch (ParseException e) {
			calEnd = null;
		}
		// System.out.println(calEnd.get(Calendar.DATE));

		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);

		// cal.add(Calendar.DATE, 1);//1日追加
		System.out.print(calEnd.get(Calendar.YEAR) + "年");
		System.out.print(calEnd.get(Calendar.MONTH) + 1 + "月");
		System.out.print(calEnd.get(Calendar.DAY_OF_MONTH) + "日");
		int diff = calEnd.compareTo(cal);
		System.out.println(diff);
		while (true) {
			if (cal.compareTo(calEnd) < 0){
				for (int i = 1;; i++) {
					cal.add(Calendar.DATE, i);// 1日追加
					System.out.print(cal.get(Calendar.YEAR) + "年");
					System.out.print(cal.get(Calendar.MONTH) + 1 + "月");
					System.out.println(cal.get(Calendar.DAY_OF_MONTH) + "日");
				}
			}else{
				break;
			}
		}

		// // lessonテーブルにデータを挿入
		// String sql = "insert into lesson (date,time)"
		// + "value(?,?)";
		// PreparedStatement pStmt = conn.prepareStatement(sql);
		// pStmt.setString(1, ls.getDate());
		// pStmt.setString(2, ls.getTime());
		//
		// firstSQLResult = pStmt.executeUpdate();// 成功時は必ず1、失敗時は0
		//
		// // 1回目がfalse、2回目がtrueのときも通っちゃうからダメ
		// if (firstSQLResult > 0) {
		// result = true;
		// }
		//
		// //最後に重複レッスン枠を消す
		//
		return result;
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		// return false;
		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// return false;
		// } finally {
		// if (conn != null) {
		// try {
		// conn.close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// return false;
		// }
		// }
		// }
	}

}
