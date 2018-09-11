package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Cancel;
import model.SQL;

public class CancelDAO {
	boolean result = false;
	SQL sqlUrl = new SQL();
	final String DRIVER_NAME = sqlUrl.getDRIVER_NAME();
	final String JDBC_URL = sqlUrl.getJDBC_URL_y();
	final String DB_USER = sqlUrl.getDB_USER();
	final String DB_PASS = sqlUrl.getDB_PASS();

	public boolean cancel(Cancel cancel) {
		boolean result=false;
		Connection conn = null;
		//JDBCドライバ読込み
		try {
			Class.forName(DRIVER_NAME);

			//データベースへ接続
			conn = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS);

			//UPDATE文の準備
			String sql = "UPDATE Reservation SET yes_or_no = 0 "
					+ "where number=? and date=? and mail=?";
//			PreparedStatement pStmt = conn.prepareStatement(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,Integer.parseInt(cancel.getNumber()));
			pStmt.setString(2, cancel.getDate());
			pStmt.setString(3, cancel.getMail());
			int rs = pStmt.executeUpdate();

			if (rs==1) {// rs.next()⇒1行目があればfalseを返すメソッド
				result=true;
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