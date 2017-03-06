package SocialAlarmClockJava;

// This class is used to pull all requests that have already been committed to by various users. Pulls them from the DB. It also returns the phone number of the committer 
// as well as checks if the correct user is trying to complete the request meaning that only a user who intially committed to the request can complete the request 
// and get his call connected


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AllRequestsAlreadyCommittedFromDB {

	private Connection dbCon;


	public List InfoOfCommittedRequests (){
		List CommitList = new ArrayList();
		PreparedStatement preparedStatementQ ;
		dbCon=ConnectionManager.getConnection();
		String MyQuery= "SELECT * FROM CommittedRequests";
		try{
			preparedStatementQ=dbCon.prepareStatement(MyQuery);
			ResultSet rs = preparedStatementQ.executeQuery();
			
		while (rs.next()){
			int ReqID = rs.getInt(1);
			String CommitterEmail = rs.getString(2);
		CommitterTuple tempvariable = new CommitterTuple(ReqID,CommitterEmail);
		CommitList.add(tempvariable);
		
		}
			
		if (rs != null) {
	        try {
	        	rs.close();
	        } catch (SQLException e) { /* ignored */}
	    }
		if (preparedStatementQ != null) {
	        try {
	        	preparedStatementQ.close();
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
	return CommitList;
	} 
	
	public String returnPhNumberOfCommitter(int ReqID){
		String PhNumber="";
		PreparedStatement preparedStatementQ ;
		dbCon=ConnectionManager.getConnection();
		String MyQuery= "SELECT CommitterPhNumber FROM CommittedRequests WHERE ReqID = ?";
		try{
			preparedStatementQ=dbCon.prepareStatement(MyQuery);
			preparedStatementQ.setInt(1, ReqID);
			ResultSet rs = preparedStatementQ.executeQuery();
			while (rs.next()){
			PhNumber = rs.getString(1);
			}
			if (rs != null) {
		        try {
		        	rs.close();
		        } catch (SQLException e) { /* ignored */}
		    }
			if (preparedStatementQ != null) {
		        try {
		        	preparedStatementQ.close();
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
	return PhNumber;
	}
	
	public boolean CheckIfUserIsAuthorizedToCompleteRequest (int ReqID, String useremail){
		boolean authorization = false;
		PreparedStatement preparedStatementQ ;
		dbCon=ConnectionManager.getConnection();
		String MyQuery= "SELECT * FROM CommittedRequests WHERE ReqID = ? AND CommitterEmail = ?";
		try{
			preparedStatementQ=dbCon.prepareStatement(MyQuery);
			preparedStatementQ.setInt(1, ReqID);
			preparedStatementQ.setString(2, useremail);
			
			ResultSet rs = preparedStatementQ.executeQuery();
			
			if (rs.next())
				authorization = true;
	
		
			
		if (rs != null) {
	        try {
	        	rs.close();
	        } catch (SQLException e) { /* ignored */}
	    }
		if (preparedStatementQ != null) {
	        try {
	        	preparedStatementQ.close();
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
	return authorization;
	} 

}
