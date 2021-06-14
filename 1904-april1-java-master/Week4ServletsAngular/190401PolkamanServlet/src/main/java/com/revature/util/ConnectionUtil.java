package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				/*
				 * **Because i felt like it**
				 * In the old days, JDBC would require you to manually
				 * add the oracle ojdbc driver class at runtime.
				 * Class.forName will explicityly serach and load the
				 * detailed class at runtime, as opposed to Java
				 * naturally loading the class itself.
				 */
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			String[] creds= System.getenv("DBProps").split(";");
			conn = DriverManager.getConnection(
					creds[0],
					creds[1],
					creds[2]
					);
			System.out.println("=====<CONNECTED>====");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
