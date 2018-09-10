package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.ReservedLogic;
import model.Cancel;

public class CancelDAO {
	public boolean cancel(Cancel cancel){
		boolean result = false;
		Connection conn = null;
		List<ReservedLogic> empList = new ArrayList<ReservedLogic>();

	try {
		//JDBCドライバ読込み
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//データベースへ接続
		conn = DriverManager.getConnection("JDBC_URL,DB_USER,DB_PASS");

		//UPDATE文の準備
		String sql = "UPDATE INTO Reservation(yes_or_no) VALUES(0)";
		PreparedStatement pStmt =conn.prepareStatement(sql);

		//UPDATE文の「?」に使用する値を設定しSQLを完成
		pStmt.setInt(1, 0);
		return result;
	} catch (SQLException e) {
		e.printStackTrace();
		return result;
	} finally {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return result;
			}
		}
	}
	}
}