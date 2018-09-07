package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final String JDBC_URL = "jdbc:mysql://localhost/pilates";
	final String DB_USER = "root";
	final String DB_PASS = "root";
	Connection conn = null;

	public int countCustomer(String day,String time){
		Connection conn =null;
		int CC=0;

		try{Class.forName(DRIVER_NAME);
		conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

		String sql="SELECT COUNT (date,time) AS CC FROM Reservation WHERE date=?,time=?";
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
