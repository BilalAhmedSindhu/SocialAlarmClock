package SocialAlarmClockJava;
// Used to temporarily hold the data for a wake up request. Used for storing the request into the DB later
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WakeUpRequest {

	private String userEmail;
	private String phoneNumber;
	private String timeHours;
	private String timeMinutes;
	private int ID;
	private String day;
	private String month;
	private String year;

	private static Connection dbCon;
	private PreparedStatement preparedStatementinsert;

	public WakeUpRequest(String userEmail, String phoneNumber, String timeHours,
			String timeMinutes, String day, String month, String year) {
		this.userEmail = userEmail;
		this.phoneNumber = phoneNumber;
		this.timeHours = timeHours;
		this.timeMinutes = timeMinutes;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public WakeUpRequest(int ID,String userEmail, String phoneNumber, String timeHours,
			String timeMinutes, String day, String month, String year) {
		this.userEmail = userEmail;
		this.phoneNumber = phoneNumber;
		this.timeHours = timeHours;
		this.timeMinutes = timeMinutes;
		this.day = day;
		this.month = month;
		this.year = year;
		this.ID=ID;
	}
	public int returnRequestID(){
		return this.ID;
	}
	
	public String returnPhNumber(){
		return this.phoneNumber;
	}
	public String returnTimeHours(){
		return this.timeHours;
	}
	public String returnTimeMinutes(){
		return this.timeMinutes;
	}
	public String returnDay(){
		return this.day;
	}
	public String returnMonth(){
		return this.month;
	}
	public String returnYear(){
		return this.year;
	}
	public String returnEmail(){
		return this.userEmail;
	}
	
	public static void intializedatabase() {

		dbCon = ConnectionManager.getConnection();
	}

	public void StoreRequest() {
		intializedatabase();
		String MyQuery = "INSERT INTO WakeUpRequests(Email,PhoneNumber,TimeHours,TimeMinutes,Day,Month,Year) VALUES(?,?,?,?,?,?,?)";
		try {

			preparedStatementinsert = dbCon.prepareStatement(MyQuery);
			preparedStatementinsert.setString(1, this.userEmail);
			preparedStatementinsert.setString(2, this.phoneNumber);
			preparedStatementinsert.setString(3, this.timeHours);
			preparedStatementinsert.setString(4, this.timeMinutes);
			preparedStatementinsert.setString(5, this.day);
			preparedStatementinsert.setString(6, this.month);
			preparedStatementinsert.setString(7, this.year);
			preparedStatementinsert.executeUpdate();
			if (preparedStatementinsert != null) {
		        try {
		        	preparedStatementinsert.close();
		        } catch (SQLException e) { /* ignored */}
		    }

		} catch (SQLException e) {
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
