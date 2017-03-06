package SocialAlarmClockJava;
/* Storing the information of the committer in the DB. 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FinalizeCommitToDB {
	
	private static Connection dbCon;

public void WriteCommitToDB(int ReqID, String Email, String PhNumber){
	dbCon=ConnectionManager.getConnection();
	PreparedStatement preparedStatementinsert ;
	String MyQuery= "INSERT INTO CommittedRequests(ReqID,CommitterEmail,CommitterPhNumber) VALUES(?,?,?)";

	try{
		//Outputting Result to the OUTPUT relation with TRANSACTION ID as well as the message of what happened
		preparedStatementinsert= dbCon.prepareStatement(MyQuery);
		
		preparedStatementinsert.setInt(1, ReqID);
		preparedStatementinsert.setString(2, Email);
		preparedStatementinsert.setString(3, PhNumber);
			
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


}
