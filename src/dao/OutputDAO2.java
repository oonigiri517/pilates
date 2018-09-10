package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.SQL;

public class OutputDAO2 {
	public String OutputCSV(String str1,String str2) {
		SQL sqlUrl = new SQL();
		final String DRIVER_NAME = sqlUrl.getDRIVER_NAME();
		final String JDBC_URL = sqlUrl.getJDBC_URL_y();
		final String DB_USER = sqlUrl.getDB_USER();
		final String DB_PASS = sqlUrl.getDB_PASS();
		Connection conn = null;

		try {
			Class.forName(DRIVER_NAME).newInstance();
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

	        File file = new File("inquiry.csv");

	        //ファイルパスを取得する
	        String str = file.getAbsolutePath();

	        System.out.println("pass : " + str);

			//文字コードを指定して書き込むやつ？
		    OutputStreamWriter osw  = new OutputStreamWriter(new FileOutputStream(str), "SHIFT-JIS");
		    BufferedWriter bw = new BufferedWriter(osw);

		    StringBuilder sb = new StringBuilder() ;

			Statement stmt = conn.createStatement();

			//項目名を表示するSQL文
			String sql = "show columns from reservation";
			ResultSet rs = stmt.executeQuery(sql);

			//項目名を書き込む
			while (rs.next()) {
				String c1=rs.getString("Field");
				bw.write("\""+c1+"\",");
				sb.append("\""+c1+"\",");
			}
			bw.write("\n");
			sb.append("\n");

			//データを表示するSQL分
			sql = "select * from reservation where date between ? and ? order by number";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, str1);
			pStmt.setString(2, str2);
			rs = pStmt.executeQuery();

			//データを書き込む
			while (rs.next()) {//

				String d1=rs.getString("number");//該当する項目名の値を書込む
				String d2=rs.getString("date");
				String d3=rs.getString("time");
				String d4=rs.getString("family_name");
				String d5=rs.getString("first_name");
				String d6=rs.getString("mail");
				String d7=rs.getString("tel");
				String d8=rs.getString("memo");
				String d9=rs.getString("yes_or_no");

				bw.write("\""+d1+"\",");
				bw.write("\""+d2+"\",");
				bw.write("\""+d3+"\",");
				bw.write("\""+d4+"\",");
				bw.write("\""+d5+"\",");
				bw.write("\""+d6+"\",");
				bw.write("\""+d7+"\",");
				bw.write("\""+d8+"\",");
				bw.write("\""+d9+"\",");
				bw.write("\n");

				sb.append("\""+d1+"\",");
				sb.append("\""+d2+"\",");
				sb.append("\""+d3+"\",");
				sb.append("\""+d4+"\",");
				sb.append("\""+d5+"\",");
				sb.append("\""+d6+"\",");
				sb.append("\""+d7+"\",");
				sb.append("\""+d8+"\",");
				sb.append("\""+d9+"\",");
				sb.append("\n");

			}
			//閉じる
			bw.close();

			System.out.println(sb.toString());

			rs.close();
			stmt.close();

			return sb.toString() ;

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException:" + e.getMessage());
			return null ;
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
			return null ;
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			return null ;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("SQLException:" + e.getMessage());
				return null ;
			}

		}
	}

}

