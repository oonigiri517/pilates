package model;

public class SQL {
	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final String JDBC_URL_y = "jdbc:mysql://192.168.10.27/pilates";
	final String DB_USER = "root";
	final String DB_PASS = "root";

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
