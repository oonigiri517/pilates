package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bo.ReservedLogic;

public class CancelDAO {
	public List<ReservedLogic> findAll(){
		
		Connection conn = null;
		List<ReservedLogic> empList = new ArrayList<ReservedLogic>();
	
	try {
		//JDBCドライバ読込み
		Class.forName("org.h2.Driver");
		
		//データベースへ接続
		conn = DriverManager.getConnection(
				"JDBC_URL,DB_USER,DB_PASS");
		
		//UPDATE文の準備
		String sql = "UPDATE INTO Reservation(number,date,mail) VALUES(?,?,?)";
		PreparedStatement pStmt =conn.prepareStatement(sql);
		
		//UPDATE文の「?」に使用する値を設定しSQLを完成
		pStmt.setString(1, ReservedLogic.getNumber());
		pStmt.setString(2, ReservedLogic.getDate());
		pStmt.setString(3, ReservedLogic.getMail());
		
		
		
	}catch
	