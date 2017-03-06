package SocialAlarmClockJava;

import java.util.Iterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*; 

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Sms;

import SocialAlarmClockJava.SQLExcept;
import SocialAlarmClockJava.DBConstants;
import SocialAlarmClockJava.SQLExcept;
// Just used to test code without the server



public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Main() {
        super();

    }
	 
	// static PreparedStatement preparedStatementinsert ;
//	private static Connection dbCon;
	
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  { 
				  
			
		  
		  }
		  }
	

