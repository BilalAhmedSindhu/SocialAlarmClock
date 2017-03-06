package SocialAlarmClockJava;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Sms;
import com.twilio.sdk.resource.list.SmsList;

import java.util.HashMap;
import java.util.Map;
 

/* This is where we connect the two users anonymously through a phone call. First we check if the user is actually authorized to complete the request because to complete the request
 * he/she must be the ones that committed to the request earlier. If this is indeed the case, the call will be connected. We are using a third party service, twilio, to connect our calls.
 * The account we are using is registered to our project. */

@WebServlet("/CompleteRequestMakeCall")
public class CompleteRequestMakeCall extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iterator inputIterator;
	 public static final String ACCOUNT_SID = "AC59f185816eca0ce512e0503f3660499f";
	  public static final String AUTH_TOKEN = "058e77dc02c15cb04ca68557e1a84caa";
	public CompleteRequestMakeCall() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoggedInUsers UserEmail1 = new LoggedInUsers();
		boolean authorization = false;
		int ReqID= Integer.parseInt(request.getParameter("ReqID"));
		String Email=UserEmail1.ReturnEmailOfLoggedInUser(session.getId());
		AllRequestsAlreadyCommittedFromDB CheckAuthorization = new AllRequestsAlreadyCommittedFromDB();
		authorization = CheckAuthorization.CheckIfUserIsAuthorizedToCompleteRequest(ReqID, Email);
		
		if (authorization == false){
			response.sendRedirect("CompleteRequestFailed.jsp");
		}
		else{
			String CommitterPhNumber = CheckAuthorization.returnPhNumberOfCommitter(ReqID);
			WakeUpRequestsMadeByUserFromDB RequestCreator = new WakeUpRequestsMadeByUserFromDB();
			String RequestCreatorPhNumber=RequestCreator.getWakeUpRequestCreatorsPhNumber(ReqID);
			TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
					 
	       Account acct = client.getAccount();
	       CallFactory callFactory = acct.getCallFactory();
	         String url = "http://SocialAlarmClock.ngrok.io/SocialAlarmClock/ConnectSecondCaller.jsp?number=" + RequestCreatorPhNumber;
	   
	       Map<String,String> params = new HashMap<String,String>();
	        params.put("From", "+16477037866");
	        params.put("To", CommitterPhNumber);
	       params.put("Url", url);
	       
	       try {
	            // Make a phone call  ( This makes a POST request to the Calls resource)
	            callFactory.create(params);
	           
	        } catch (TwilioRestException e) {

	        		        	e.printStackTrace();
	        }
	      
	        
			
			response.sendRedirect("CompleteRequestSuccess.jsp");
		}}
		
			
		
	}

	
