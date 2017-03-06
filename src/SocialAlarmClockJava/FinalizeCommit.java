package SocialAlarmClockJava;
import java.io.IOException;
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

/* This class is where we finalize the commit to a request by a user. When we get the information from the CommitToARequest class, we check first whether the request is still open
 * meaning that it has not already been committed to. If it is not open, we display the appropiate message. If it is indeed open, then we finalize the commit to the request 
 * by the user. We then send the various details such as request id, email of the committer and the phone number he provided in the DB. 
 */

@WebServlet("/FinalizeCommit")
public class FinalizeCommit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iterator inputIterator;
    public FinalizeCommit() {
        super();

    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	AllRequestsAlreadyCommittedFromDB Committers= new AllRequestsAlreadyCommittedFromDB();
    	List CommittersList =  new ArrayList();  
    	CommittersList= Committers.InfoOfCommittedRequests();
    	HttpSession session = request.getSession();
		LoggedInUsers UserEmail1 = new LoggedInUsers();
		String Email=UserEmail1.ReturnEmailOfLoggedInUser(session.getId());
    	int x = Integer.parseInt(request.getParameter("ReqID"));
    	boolean previouslycommitted=false;
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType ="<!DOCTYPE HTML>\n";
	    String stylesheet = "\"stylesheet\"" ;
	    String stylesheetdirectory = "\"./Design/stylesheet.css\"";
	    String type= "\"text/css\"";
	    String contenttype = "\"Content-Type\"" ;
	    String content ="\"text/html; charset=BIG5\"";

	    //String title = "You have been registered by the following details";
	    out.println(docType +"<HTML>\n" +"<HEAD>\n"+ "<link rel=" + stylesheet + " href="+ stylesheetdirectory
	    		+ " type="+ type +"/>\n"+ "<meta http-equiv="+contenttype+" content=" + content +">"
	    		+ "<TITLE> Commit to request" +   "</TITLE></HEAD>\n" + " <body>\n<center>\n" +
	    		"<h1>Commit Response</h1>	</center><div align=\"right\"><embed src=http://flash-clocks.com/free-flash-clocks-blog-topics/free-flash-clock-176.swf width=150 height=50 wmode=window type=application/x-shockwave-flash></embed></div><br>\n");	
    	
	    if(CommittersList.isEmpty()){
	    	FinalizeCommitToDB committodb = new FinalizeCommitToDB();
	    	committodb.WriteCommitToDB(x, Email,request.getParameter("PhNumber"));
	    	 out.println("<center><h2><font color=\"green\">Commit Successful</h2></font></center>"
	    			    +"<h2><a href=\"CommitToARequest\">Commit to another request</a></h2>"
	    			    +"<h2><a href=\"MembersHome.jsp\">Home</a></h2>\n</body>\n</html>");
	    			        out.flush();
	    }
	    else{
	    	inputIterator = CommittersList.iterator();
	    while(inputIterator.hasNext()){
	    	CommitterTuple temptuple = (CommitterTuple ) inputIterator.next();
	    	if (temptuple.returnReqID() == x){
	    		previouslycommitted=true;
	    	}
	    }
	    if (previouslycommitted){
	    	out.println("<center><h2><font color=\"red\">Request has already been committed too</h2></font></center>"
	    +"<h2><a href=\"CommitToARequest\">Commit to another request</a></h2>"
	    +"<h2><a href=\"MembersHome.jsp\">Home</a></h2>\n</body>\n</html>");
	    out.flush();
	    }
	    else{
	    	FinalizeCommitToDB committodb = new FinalizeCommitToDB();
	    	committodb.WriteCommitToDB(x, Email,request.getParameter("PhNumber"));
	    out.println("<center><h2><font color=\"green\">Commit Successful</h2></font></center>"
	    +"<h2><a href=\"CommitToARequest\">Commit to another request</a></h2>"
	    +"<h2><a href=\"MembersHome.jsp\">Home</a></h2>\n</body>\n</html>");
	        out.flush();
	    
	    }
	    }
    	}

    }
