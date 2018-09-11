package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Lesson;
import model.SQL;

public class LessonDAO {
	SQL sqlUrl = new SQL();
	final String DRIVER_NAME = sqlUrl.getDRIVER_NAME();
	final String JDBC_URL = sqlUrl.getJDBC_URL_y();
	final String DB_USER = sqlUrl.getDB_USER();
	final String DB_PASS = sqlUrl.getDB_PASS();
	Connection conn = null;

	public boolean check(Lesson lesson) {

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS);

			// 同一時間に同一アドレスの予約有無を確認
			String sql = "SELECT *,count(date) FROM lesson where date=? group by date";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, lesson.getDate().replace("/","-"));
			pStmt.setString(2, lesson.getTime());

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {// rs.next()⇒1行目があればfalseを返すメソッド
				return false;
			} else {// rs.next()⇒1行目がなければtrueを返すメソッド
				return true;
			}

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

	public boolean insert(Lesson lesson) {
		boolean result = false;
		int firstSQLResult = 0;// 帰ってきた件数チェック(0件なら入ってない)
		// JDBCドライバ読込み
		try {
			Class.forName(DRIVER_NAME);
			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// INSERT文の準備
			String sql = "insert into lesson (date,time)" + "value(?,?)";
			PreparedStatement pStmt1 = conn.prepareStatement(sql);
			pStmt1.setString(1, lesson.getDate());
			pStmt1.setString(2, lesson.getTime());

			firstSQLResult = pStmt1.executeUpdate();// 成功時は必ず1、失敗時は0

			// 重複レコードを削除する
			sql = "DELETE FROM lesson WHERE" + " id NOT IN (SELECT min_id from "
					+ "(SELECT MIN(id) min_id FROM lesson GROUP BY date,time) tmp)";
			PreparedStatement pStmt2 = conn.prepareStatement(sql);
			pStmt2.executeUpdate();

			// 1回目がfalse、2回目がtrueのときも通っちゃうからダメ
			if (firstSQLResult > 0) {
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

	public boolean delete(Lesson lesson) {
		boolean result = false;
		int firstSQLResult = 0;// 帰ってきた件数チェック(0件なら入ってない)
		// JDBCドライバ読込み
		try {
			Class.forName(DRIVER_NAME);
			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// DELETE文の準備
			String sql = "delete from lesson where date = ? and time=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, lesson.getDate());
			pStmt.setString(2, lesson.getTime());
			firstSQLResult = pStmt.executeUpdate();// 成功時は必ず1、失敗時は0

			// 1回目がfalse、2回目がtrueのときも通っちゃうからダメ
			if (firstSQLResult > 0) {
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

	public String[] findDay(String day) {

		Connection conn = null;

		String[] FDL = new String[] { "無し", "無し" };
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "SELECT date,time FROM lesson WHERE date=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, day);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int I = 0;

				String time = rs.getString("time");
				FDL[I] = time;
				I = I + 1;
			}
			return FDL;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

}