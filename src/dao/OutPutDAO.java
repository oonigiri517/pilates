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

import model.SQL;

public class OutPutDAO {

	//public static void main(String[] args)throws Exception {
	public String OutputCSV() {

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

		try {
			Class.forName(DRIVER_NAME).newInstance();
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

	        File file = new File("java.csv");

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
			sql = "select  * , work.mail, sum(予約回数) as 予約回数, sum(OK) as OK, sum(キャンセル) as キャンセル"
				+	" from "
				+	"(select *, 1 as 予約回数, 0 as OK, 0 as キャンセル "
				+  "from reservation "
				+	"union all "
				+	"select *, 0 as 予約回数, 1 as OK, 0 as キャンセル "
				+	"from reservation where Yes_or_no=1 "
				+	"union all "
				+	"select *, 0 as 予約回数, 0 as OK, 1 as キャンセル "
				+	"from reservation where Yes_or_no=0 "
				+	") work "
				+	"group by work.mail;";

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
				String d8=rs.getString("予約回数");
				String d9=rs.getString("OK");
				String d10=rs.getString("キャンセル");


				bw.write("\""+d1+"\",");
				bw.write("\""+d2+"\",");
				bw.write("\""+d3+"\",");
				bw.write("\""+d4+"\",");
				bw.write("\""+d5+"\"");
				bw.write("\""+d6+"\"");
				bw.write("\""+d7+"\"");
				bw.write("\""+d8+"\"");
				bw.write("\""+d9+"\"");
				bw.write("\""+d10+"\"");
				bw.write("\n");

				sb.append("\""+d1+"\",");
				sb.append("\""+d2+"\",");
				sb.append("\""+d3+"\",");
				sb.append("\""+d4+"\",");
				sb.append("\""+d5+"\",");
				sb.append("\""+d6+"\",");
				sb.append("\""+d7+"\",");
				sb.append("\""+d8+"\"");
				sb.append("\""+d9+"\"");
				sb.append("\""+d10+"\"");
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
