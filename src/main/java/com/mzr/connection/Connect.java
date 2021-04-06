package com.mzr.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public interface Connect {
	
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mazhar");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
