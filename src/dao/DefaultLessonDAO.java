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

import model.SQL;

public class DefaultLessonDAO {
	SQL sqlUrl = new SQL();
	final String DRIVER_NAME = sqlUrl.getDRIVER_NAME();
	final String JDBC_URL = sqlUrl.getJDBC_URL_y();
	final String DB_USER = sqlUrl.getDB_USER();
	final String DB_PASS = sqlUrl.getDB_PASS();
	Connection conn = null;

	public boolean defaultInsert(String strStart,String strEnd) {
		boolean result = false;

		Calendar start = new GregorianCalendar();
		Calendar end = new GregorianCalendar();

		// 期間入力フォームからとってきた日付カレンダー型に変換
		try {
			start.setTime(DateFormat.getDateInstance().parse(strStart.replace("-","/")));
			end.setTime(DateFormat.getDateInstance().parse(strEnd.replace("-","/")));
		} catch (ParseException e) {
			start=null;end = null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// モジュール化する？
		String[] defaultLessonTimes = { "10:00", "14:00" };
		System.out.println(sdf.format(start.getTime()));
		System.out.println(sdf.format(end.getTime()));

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// lessonテーブルにデータを挿入
			String sql = "insert into lesson (date,time)value(?,?)";
			int sqlResult=0;
			while (start.compareTo(end) < 0) {
				String now = sdf.format(start.getTime());
				int D = start.get(Calendar.DAY_OF_WEEK);
				if (D == 2 || D == 3 || D == 5 || D == 6) {
					for (String time : defaultLessonTimes) {
						PreparedStatement pStmt1 = conn.prepareStatement(sql);
						pStmt1.setString(1, now);
						pStmt1.setString(2, time);
						sqlResult=pStmt1.executeUpdate();
					}
				}
				start.add(Calendar.DATE, 1);// 1日追加
				System.out.println(now);
			}

			//重複レコードを削除する
			sql = "DELETE FROM lesson WHERE"
					+ " id NOT IN (SELECT min_id from "
					+ "(SELECT MIN(id) min_id FROM lesson GROUP BY date,time) tmp)";
			PreparedStatement pStmt2 = conn.prepareStatement(sql);
			pStmt2.executeUpdate();

			if (sqlResult > 0) {
				result = true;
			}
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
