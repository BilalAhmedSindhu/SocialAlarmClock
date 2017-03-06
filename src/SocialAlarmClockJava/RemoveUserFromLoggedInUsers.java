package SocialAlarmClockJava;
// Removes the user from the loggedon users table in the db when the user clicks signout
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class RemoveUserFromLoggedInUsers {
	private Connection dbCon;

	RemoveUserFromLoggedInUsers(){
		dbCon=ConnectionManager.getConnection();
	}
	
	public  void RemoveUser(String ID){
		String MyQuery= "DELETE FROM LoggedInUsers WHERE SessionID = ?";
		PreparedStatement preparedStatementinsert ;
		try{
			preparedStatementinsert= dbCon.prepareStatement(MyQuery);
			
			preparedStatementinsert.setString(1, ID);
							
			preparedStatementinsert.executeUpdate();
			
			 if (preparedStatementinsert != null) {
			        try {
			        	preparedStatementinsert.close();
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
	}
}