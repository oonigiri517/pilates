//データベースを家計簿にしてます

package dao;//任意のパッケージに変更してください

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OutPutDAO {

	public static void main(String[] args)throws Exception {

		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/goods";//使用するデータベース名を設定
		String user = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

			//現在時間を取得
	        Date d = new Date();
	        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
	        String now = df.format(d);

	        //現在時間をつけたファイルを生成
<<<<<<< Updated upstream
//	        String realPath = this.getServletContext().getRealPath("/WEB-INF/name.txt");
			File f = new File("/WEB-INF/jsp/家計簿"+now+".csv");
=======
			File f = new File("C:\\Users\\s1-01.S1-01\\Desktop\\家計簿"+now+".csv");
>>>>>>> Stashed changes

			//文字コードを指定して書き込むやつ？
		    OutputStreamWriter osw  = new OutputStreamWriter(new FileOutputStream(f), "SHIFT-JIS");
		    BufferedWriter bw = new BufferedWriter(osw);

			Statement stmt = conn.createStatement();

			//項目名を表示するSQL文
			String sql = "show columns from 家計簿";
			ResultSet rs = stmt.executeQuery(sql);

			//項目名を書き込む
			while (rs.next()) {
				String c1=rs.getString("Field");
				bw.write("\""+c1+"\",");
			}
			bw.write("\n");

			//データを表示するSQL分
			sql = "SELECT * FROM 家計簿";
			rs = stmt.executeQuery(sql);

			//データを書き込む
			while (rs.next()) {//
				String d1=rs.getString("日付");//該当する項目名の値を書込む
				String d2=rs.getString("費目ID");
				String d3=rs.getString("メモ");
				String d4=rs.getString("入金額");
				String d5=rs.getString("出金額");

				bw.write("\""+d1+"\",");
				bw.write("\""+d2+"\",");
				bw.write("\""+d3+"\",");
				bw.write("\""+d4+"\",");
				bw.write("\""+d5+"\"");
				bw.write("\n");
			}
			//閉じる
			bw.close();
			rs.close();
			stmt.close();

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException:" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("SQLException:" + e.getMessage());
			}

		}
	}

}
