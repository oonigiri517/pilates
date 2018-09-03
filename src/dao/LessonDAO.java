package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Lesson;

;

public class LessonDAO {

		private final String DRIVER_NAME="com.mysql.jdbc.Driver";
		private final String JDBC_URL="jdbc:mysql//localhost/data/DokoTsubu/useSSL=false";
		private final String DB_USER="sa";
		private final String DB_PASS="";


		public Lesson[] findDay(String day){
			Connection conn =null;
			int I=0;
			Lesson[] FDL= new Lesson[2];
			try{Class.forName(DRIVER_NAME);
			conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			String sql="SELECT l_date,l_time FROM lesson WHERE l_date=?";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setString(1, day);
			ResultSet rs=pStmt.executeQuery();
			while (rs.next()) {
	     		I=I+1;
	     		String l_date =rs.getString("l_date");
	     		String l_time=rs.getString("l_time");
	     		Lesson lesson=new Lesson(l_date,l_time);
	     		FDL[I]=lesson;
			}
			return FDL;


			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}catch(ClassNotFoundException e){
				e.printStackTrace();
				return null;
			}finally{
				if(conn !=null){
					try{
						conn.close();
					}catch(SQLException e){
						e.printStackTrace();
						return null;
					}
				}
			}
		}

		public boolean create(Lesson lesson){
			Connection conn=null;
			try{
				conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
				String sql="INSERT INTO MUTTER(l_day,l_time) VALUES(?,?)";
				PreparedStatement pStmt=conn.prepareStatement(sql);
				pStmt.setString(1,lesson.getDate());
				pStmt.setString(2,lesson.getTime());

				int result=pStmt.executeUpdate();
				if(result !=1){
					return false;
				}
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}finally{
				if(conn !=null){
					try{

					conn.close();
					}catch(SQLException e){
						e.printStackTrace();

					}

				}
			}return true;
		}
		}