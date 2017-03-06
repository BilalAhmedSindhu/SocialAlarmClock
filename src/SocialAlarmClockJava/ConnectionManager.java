package SocialAlarmClockJava;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import SocialAlarmClockJava.DBConstants;
import SocialAlarmClockJava.SQLExcept;


public class ConnectionManager {
	static Connection dbCon;
	
	
	
	public static  Connection getConnection()  {
		
		try {
		    Class.forName(DBConstants.DB_DRIVER);
		} catch (ClassNotFoundException cfe) {		
			System.out.println("The JDBC drive loading failed.");
			cfe.printStackTrace();
		}
		try {	
			dbCon = DriverManager.getConnection(DBConstants.DB_NAME);
	//		System.out.print("asasdads");
		} catch (SQLException se) {
			SQLExcept.handleException(se);	
		}
		
		return dbCon;
	
	}
}
