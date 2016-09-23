package jp.gr.java_conf.pesk.db22sqlserver;

public class ConnectionString {

	public ConnectionString() {}

	public static String getSQLServerConnectionString() {
		String jdbc_url = "jdbc:sqlserver://";

		return jdbc_url;
	}
	public static String getDB2ConnectionStringForURL() {
		String jdbc_url = "jdbc:db2://";

		return jdbc_url;
	}
	public static String getDB2User() {
		return "user";
	}
	public static String getDB2Password() {
		return "password";
	}


}
