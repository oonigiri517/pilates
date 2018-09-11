package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.SQL;

public class CustomerDAO {
	SQL sqlUrl = new SQL();
	final String DRIVER_NAME = sqlUrl.getDRIVER_NAME();
	final String JDBC_URL = sqlUrl.getJDBC_URL_y();
	final String DB_USER = sqlUrl.getDB_USER();
	final String DB_PASS = sqlUrl.getDB_PASS();
	Connection conn = null;

	public int countCustomer(String day,String time){
		Connection conn =null;
		int CC=0;

		try{Class.forName(DRIVER_NAME);
		conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

		String sql="SELECT COUNT (*) AS CC FROM reservation WHERE date=?,time=?";
		PreparedStatement pStmt=conn.prepareStatement(sql);
		pStmt.setString(1, day);
		pStmt.setString(2, time);
		ResultSet rs=pStmt.executeQuery();
		while (rs.next()) {

     	CC =rs.getInt("CC");

		}
		return CC;


		}catch(SQLException e){
			e.printStackTrace();
			return 5;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return 5;
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return 5;
				}
			}
		}
	}


}
