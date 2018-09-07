package model;

public class SQL {
	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	//localhostの部分をSQLファイル記載のIPアドレスに変更すると
	//山本のSQLに接続できます。
	//SQLファイルの場所･･･授業用\アプリケーション\おにぎり\
	final String JDBC_URL_y = "jdbc:mysql://  /pilates";
	final String DB_USER = "onigiri";
	final String DB_PASS = "onigiri";

	public String getDRIVER_NAME() {
		return DRIVER_NAME;
	}
	public String getJDBC_URL_y() {
		return JDBC_URL_y;
	}
	public String getDB_USER() {
		return DB_USER;
	}
	public String getDB_PASS() {
		return DB_PASS;
	}
}
