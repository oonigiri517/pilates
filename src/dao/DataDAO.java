package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Lesson;
import model.MailData;
import model.ReserveData;
import model.SQL;

public class DataDAO {
	SQL sqlUrl=new SQL();
	final String DRIVER_NAME = sqlUrl.getDRIVER_NAME();
	final String JDBC_URL = sqlUrl.getJDBC_URL_y();
	final String DB_USER = sqlUrl.getDB_USER();
	final String DB_PASS = sqlUrl.getDB_PASS();
	Connection conn = null;

	//予約内容重複チェック
	public boolean check(Lesson lesson, ReserveData rData) {

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS);

			// 同一時間に同一アドレスの予約有無を確認
			String sql = "SELECT*FROM reservation where date=? and time=? and mail=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, lesson.getDate().replace("/","-"));
			pStmt.setString(2, lesson.getTime());
			pStmt.setString(3, rData.getMail());

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

	//予約書き込み
	public boolean insert(Lesson lesson, ReserveData rData) {
		Connection conn = null;
		int firstSQLResult = 0;// 帰ってきた件数チェック(0件なら入ってない)
		boolean result = false;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// entrantテーブルにデータを挿入
			String sql = "insert into reservation (date,time,family_name,first_name,mail,tel,memo)"
					+ "value(?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, lesson.getDate().replace("/","-"));
			pStmt.setString(2, lesson.getTime());
			pStmt.setString(3, rData.getFamily_name());
			pStmt.setString(4, rData.getFirst_name());
			pStmt.setString(5, rData.getMail());
			pStmt.setString(6, rData.getTel());
			pStmt.setString(7, rData.getMemo());

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

	public MailData findNum(Lesson lesson, ReserveData rData) {
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			MailData mailData = new MailData();

			//
			String sql = "SELECT*FROM RESERVATION WHERE DATE=? AND TIME=? AND MAIL=? ORDER BY NUMBER DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, lesson.getDate().replace("/","-"));
			pStmt.setString(2, lesson.getTime());
			pStmt.setString(3, rData.getMail());

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {// rs.next()⇒1行目があればnullを返すメソッド
				String number = rs.getString("number");
				String date = rs.getString("date");
				String time = rs.getString("time");
				String family_name = rs.getString("family_name");
				String first_name = rs.getString("first_name");
				String mail = rs.getString("mail");

				mailData.setNumber(number);
				mailData.setDate(date);
				mailData.setTime(time);
				mailData.setFamily_name(family_name);
				mailData.setFirst_name(first_name);
				mailData.setMail(mail);
				return mailData;

			} else {// rs.next()⇒1行目がなければnullを返すメソッド
				return null;
			}

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
