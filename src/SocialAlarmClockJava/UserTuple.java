package SocialAlarmClockJava;

//This class creates a temporary record of the new user while the application is running. Basically used to transfer user data permanently into the DB

public class UserTuple {
	
	private int UserID ;
	private String Fname;
	private String Lname;
	private String YearB;
	private String DayB;
	private String MonthB;
	private String Gender;
	private String Country;
	private String City;
	private String Email;
	private String PassW;
	
	public UserTuple(){
		
	}
	
	public UserTuple(String Fname, String Lname,String YearB,String DayB,String MonthB, String Gender, String Country, String City, String Email, String PassW) {
			this.Fname = Fname;
		this.Lname=Lname;
		this.DayB=DayB;
		this.YearB=YearB;
		this.Email=Email;
		this.PassW=PassW;
		this.City=City;
		this.MonthB=MonthB;
		this.Gender=Gender;
		this.Country=Country;
	}
	
	public String getLname() {
		return Lname;
	}
	
	
	
	public String getFname() {
		return Fname;
	}

	public String getYearB() {
		return YearB;
	}
	public String getGender() {
		return Gender;
	}
	public String getCountry() {
		return Country;
	}
	public String getMonthB() {
		return MonthB;
	}
	public String getEmail() {
		return Email;
	}
	public String getDayB() {
		return DayB;
	}
	public String getPassW() {
		return PassW;
	}
	public String getCity() {
		return City;
	}

}

