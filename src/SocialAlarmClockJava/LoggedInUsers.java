package SocialAlarmClockJava;

/* This is a very important class in our project. It is used to store the members that are currently online. We take the ID from the http and the email of the user and store it into the db
 * to classify the user as a logged on user. This helps us in personalizing the website and when user performs various function like making a wake up request, we know where to store
 * the information and under which members name
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoggedInUsers {
	private Connection dbCon;
	
	LoggedInUsers(){
		dbCon=ConnectionManager.getConnection();
	}
	
	public  void StoreSession(String email, String Session){
		String MyQuery= "INSERT INTO LoggedInUsers(Email,SessionID) VALUES(?,?)";
		PreparedStatement preparedStatementinsert ;
		try{
			//Outputting Result to the OUTPUT relation with TRANSACTION ID as well as the message of what happened
			preparedStatementinsert= dbCon.prepareStatement(MyQuery);
			
			preparedStatementinsert.setString(1, email);
			preparedStatementinsert.setString(2, Session);
				
			preparedStatementinsert.executeUpdate();
			
			 if (preparedStatementinsert != null) {
			        try {
			        	preparedStatementinsert.close();
			        } catch (SQLException e) { /* ignored */}
			    }
			    
			}catch(SQLException e){
				
				//this.success=false;
				SQLExcept.handleException(e);
				e.printStackTrace();
			}	
		  
		if (this.dbCon != null) {
	        try {
	            this.dbCon.close();
	        } catch (SQLException e) {}
	    }
	}
	
	public String ReturnEmailOfLoggedInUser(String ID){
		String Email = "";
		String MyQuery= "SELECT Email FROM LoggedInUsers WHERE SessionID = ?";
		PreparedStatement preparedStatementQ ;
		try{
			preparedStatementQ= dbCon.prepareStatement(MyQuery);
			preparedStatementQ.setString(1, ID);
			ResultSet rs = preparedStatementQ.executeQuery();
			while (rs.next()){
			Email = rs.getString(1);
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

		return 	Email;
	}
	
	
	
}