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

//		Connection conn = null;
//		final String DRIVER_NAME = sqlUrl.getDRIVER_NAME();
//		String JDBC_URL = "jdbc:mysql://localhost:3306/pilates";//使用するデータベース名を設定
//		String DB_USER = "root";
//		String DB_PASS = "root";

		//期間入力フォームからとってきた日付
//		Lesson les1=new Lesson();
//		String str1 = les1.getDate();
//		Lesson les2=new Lesson();
//		String str2 = les2.getDate();




		try {
			Class.forName(DRIVER_NAME).newInstance();
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

	        File file = new File("inquiry.csv");

	        //ファイルパスを取得する
	        String str = file.getAbsolutePath();

	        System.out.println("pass : " + str);

//			//現在時間を取得
//	        Date d = new Date();
//	        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//	        String now = df.format(d);
//
//	        //現在時間をつけたファイルを生成
//			File f = new File("C:\\Users\\s1-01.S1-01\\Desktop\\家計簿"+now+".csv");

			//文字コードを指定して書き込むやつ？
		    OutputStreamWriter osw  = new OutputStreamWriter(new FileOutputStream(str), "SHIFT-JIS");
		    BufferedWriter bw = new BufferedWriter(osw);

		    StringBuilder sb = new StringBuilder() ;


			Statement stmt = conn.createStatement();

			//項目名を表示するSQL文
			String sql = "slect * from reservation  between ? and ? order by date";
			//ResultSet rs = stmt.executeQuery(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, str1);
			pStmt.setString(2, str2);
			ResultSet rs = pStmt.executeQuery();

			//項目名を書き込む
			while (rs.next()) {
				String c1=rs.getString("Field");
				bw.write("\""+c1+"\",");

				sb.append("\""+c1+"\",");

			}
			bw.write("\n");
			sb.append("\n");
			//データを表示するSQL分
			sql = "SELECT * FROM reservation ";
			rs = stmt.executeQuery(sql);

			//データを書き込む
			while (rs.next()) {//
				String d1=rs.getString("date");//該当する項目名の値を書込む
				String d2=rs.getString("time");
				String d3=rs.getString("family_name");
				String d4=rs.getString("first_name");
				String d5=rs.getString("mail");
				String d6=rs.getString("tel");
				String d7=rs.getString("memo");

				bw.write("\""+d1+"\",");
				bw.write("\""+d2+"\",");
				bw.write("\""+d3+"\",");
				bw.write("\""+d4+"\",");
				bw.write("\""+d5+"\"");
				bw.write("\""+d6+"\"");
				bw.write("\""+d7+"\"");
				bw.write("\n");

				sb.append("\""+d1+"\",");
				sb.append("\""+d2+"\",");
				sb.append("\""+d3+"\",");
				sb.append("\""+d4+"\",");
				sb.append("\""+d5+"\",");
				sb.append("\""+d6+"\",");
				sb.append("\""+d7+"\",");
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

