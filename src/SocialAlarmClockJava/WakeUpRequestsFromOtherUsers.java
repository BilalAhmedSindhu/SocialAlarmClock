package SocialAlarmClockJava;

// Pulls all the wake up requests other than the ones made by the user who is wanting to view this list 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WakeUpRequestsFromOtherUsers {

	private Connection dbCon;
	private String queryString;

	public List GetRequestsMadeByAllOtherUsers(String Email) { 
	
		dbCon=ConnectionManager.getConnection();
		List RequestList = new ArrayList();
		String MyQuery= "SELECT * FROM WakeUpRequests WHERE Email <> ?";
		PreparedStatement preparedStatementQ ;
	
		try{
			preparedStatementQ= dbCon.prepareStatement(MyQuery);
			preparedStatementQ.setString(1, Email);
			ResultSet rs = preparedStatementQ.executeQuery();
			while (rs.next()){
			int ID = rs.getInt(1);
			String PhNumber = rs.getString(3);
			String THours = rs.getString(4);
			String TMinutes =rs.getString(5);
			String Day= rs.getString(6);
			String Month =rs.getString(7);
			String Year = rs.getString(8);
			String Email1 = rs.getString(2);
			WakeUpRequest Request = new WakeUpRequest(ID,Email1,PhNumber,THours,TMinutes,Day,Month,Year);
			//System.out.println("adsasd");
			RequestList.add(Request);
			
			}
			if (preparedStatementQ != null) {
		        try {
		        	preparedStatementQ.close();
		        } catch (SQLException e) { /* ignored */}
		    }
			if (rs != null) {
		        try {
		        	rs.close();
		        } catch (SQLException e) { /* ignored */}
		    }
			
		}catch(SQLException e){
			SQLExcept.handleException(e);
			e.printStackTrace();
		}
		if (this.dbCon != null) {
	        try {
	            this.dbCon.close();
	        } catch (SQLException e) {}
	    }

		
		
		return RequestList;
	}

}