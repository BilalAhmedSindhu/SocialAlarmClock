package SocialAlarmClockJava;
// Pulls the wakeup requests made by the logged on user only from the DB
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WakeUpRequestsMadeByUserFromDB {

	private Connection dbCon;
	private String queryString;

	public List GetRequestsMadeByUser(String Email) { 
	
		dbCon=ConnectionManager.getConnection();
		List RequestList = new ArrayList();
		String MyQuery= "SELECT * FROM WakeUpRequests WHERE Email = ?";
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
			WakeUpRequest Request = new WakeUpRequest(ID,Email,PhNumber,THours,TMinutes,Day,Month,Year);
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
	public String getWakeUpRequestCreatorsPhNumber(int ReqID){
		String PhNumber = "";
		dbCon=ConnectionManager.getConnection();
		String MyQuery= "SELECT PhoneNumber FROM WakeUpRequests WHERE RequestID = ?";
		PreparedStatement preparedStatementQ ;
		try{
			preparedStatementQ= dbCon.prepareStatement(MyQuery);
			preparedStatementQ.setInt(1, ReqID);
			ResultSet rs = preparedStatementQ.executeQuery();
			while (rs.next()){
				PhNumber = rs.getString(1);
				}
			//PhNumber = rs.getString(1);
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
		}
		catch(SQLException e){
			SQLExcept.handleException(e);
			e.printStackTrace();
		}
		if (this.dbCon != null) {
	        try {
	            this.dbCon.close();
	        } catch (SQLException e) {}
	    }

	return PhNumber;
	}
}