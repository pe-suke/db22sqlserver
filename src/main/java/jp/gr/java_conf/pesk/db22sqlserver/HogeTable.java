package jp.gr.java_conf.pesk.db22sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import com.microsoft.sqlserver.jdbc.SQLServerBulkCopy;
import com.microsoft.sqlserver.jdbc.SQLServerBulkCopyOptions;

public class HogeTable extends ConnectionString {

	private java.util.Date SQLServerMinDate = null;

	public HogeTable() {
		try {
			this.SQLServerMinDate = DateFormat.getDateInstance().parse("1753/01/02");
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public boolean execute() throws ClassNotFoundException {

		String tableName = "HOGE_TABLE";
		System.out.println(tableName + "テーブルデータ移行開始");
		Connection db2Con = null;
		Connection sqlServerCon = null;
		int fetchSize = 10000;

		Class.forName("com.ibm.db2.jcc.DB2Driver");
		try (Connection db2Connection = DriverManager.getConnection(getDB2ConnectionStringForURL(), getDB2User(), getDB2Password());
				Statement db2s = db2Connection.createStatement();) {

			db2s.setFetchSize(fetchSize);
			String sql = "SELECT * FROM " + tableName + " FOR READ ONLY WITH UR";
			ResultSet rs = db2s.executeQuery(sql);

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			try (Connection sqlServerConnection = DriverManager.getConnection(getSQLServerConnectionString());
					SQLServerBulkCopy bulkCopy = new SQLServerBulkCopy(sqlServerConnection)) {
				System.out.println("Bulk start -> " + new Date(System.currentTimeMillis()));

				SQLServerBulkCopyOptions options = new SQLServerBulkCopyOptions();
				options.setBulkCopyTimeout(600);
				bulkCopy.setBulkCopyOptions(options);
				bulkCopy.setDestinationTableName(tableName);

				bulkCopy.writeToServer(rs);
				System.out.println("Bulk end -> " + new Date(System.currentTimeMillis()));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
