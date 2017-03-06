package SocialAlarmClockJava;

// used for iteration. Basically this class holds on row of the committed requests table.
public class CommitterTuple {

	private int ReqID;
	private String CommitterEmail;
	
	
	public CommitterTuple(int reqid, String email){
		this.ReqID=reqid;
		this.CommitterEmail=email;
	}
	
	public int returnReqID(){
		return this.ReqID;
	}
	public String returnCommitterEmail(){
		return this.CommitterEmail;
	}
}
