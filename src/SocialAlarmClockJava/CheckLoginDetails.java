package SocialAlarmClockJava;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// This class just check login details and see if the user is a member

public class CheckLoginDetails {

	private Iterator inputIterator;
	private boolean UserIsAMember;
	String Email;
	String PassW;
	
	public CheckLoginDetails(List users,String email,String password){
		this.Email = email;
		this.PassW = password;
		this.UserIsAMember=false;
		this.inputIterator = users.iterator();
	}
	
	public boolean confirmlogin (){
		
		
		while (inputIterator.hasNext()) {
			
			UserTuple TempUser = (UserTuple) inputIterator.next(); //Used for storing the current users values for comparison
			this.Email=Email.toUpperCase();
			
			if (this.Email.equals((TempUser.getEmail()).toUpperCase()) && PassW.equals(TempUser.getPassW()) )
				return true;
			}
		return this.UserIsAMember;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
