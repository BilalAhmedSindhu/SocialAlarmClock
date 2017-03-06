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


/* This class is called upon when a user wants to commit to a request to wakeup a person up. It basically lays out all the requests that have been made by various
 * users of the website. It does not show the requests made by the user himself though. These requests are of all the other members of the website. The user can then enter a
 * request ID and a phone number and click the commit to request button the form to attemp to commit to the request
 */


@WebServlet("/CommitToARequest")
public class CommitToARequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iterator inputIterator;
    public CommitToARequest() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
	    		+ "<TITLE> All Requests " +   "</TITLE></HEAD>\n" + " <body>\n<center>\n" +
	    		"<h1>All Requests from other users</h1>	</center><div align=\"right\"><embed src=http://flash-clocks.com/free-flash-clocks-blog-topics/free-flash-clock-176.swf width=150 height=50 wmode=window type=application/x-shockwave-flash></embed></div><br>\n");
		HttpSession session = request.getSession();
		LoggedInUsers UserEmail1 = new LoggedInUsers();
		String Email=UserEmail1.ReturnEmailOfLoggedInUser(session.getId());
		List RequestsList =  new ArrayList();    
		WakeUpRequestsFromOtherUsers GetAllRequests = new WakeUpRequestsFromOtherUsers();
		RequestsList = GetAllRequests.GetRequestsMadeByAllOtherUsers(Email);
		
		if(RequestsList.isEmpty()){
			out.println("<h2><font color=\"red\">No Requests currently available</h2></font><br>"
				+	"<h2><a href=\"WakeUpRequest.jsp\">Make your own Request</a></h2>"
					+ "<h2><a href=\"MembersHome.jsp\">Home</a></h2>\n</body>\n</html>");
		}
		else{
			out.println("<table border=\"1\">\n <tr> <font color=\"blue\"><th>Request ID</th>\n <th>Email</th>\n "
					+ "<th>Time(Hours)</th>\n <th>Time(Minutes)</th>\n <th>Day</th>\n <th>Month</th>\n <th>Year</th>\n</font>\n</tr>\n");
		inputIterator = RequestsList.iterator();
		while(inputIterator.hasNext()){
			WakeUpRequest temprequest = (WakeUpRequest) inputIterator.next();
			
			out.println("<tr> <td><b>"+temprequest.returnRequestID()+"</b></td>\n<td><b>"+temprequest.returnEmail()+"</b></td>\n"
					+"<td><b>"+temprequest.returnTimeHours()+"</b></td>\n<td><b>"+temprequest.returnTimeMinutes()+"</b></td>\n"
					+"<td><b>"+temprequest.returnDay()+"</b></td>\n<td><b>"+temprequest.returnMonth()+"</b></td>\n<td><b>"+temprequest.returnYear()+"</b></td>\n"+
					"</tr>");
			
		}
		
		out.println("</table><br>");
		out.println("<FORM ACTION=\"FinalizeCommit\"> Request ID of the request you would like to commit to: <INPUT TYPE=\"TEXT\" NAME=\"ReqID\"><br>"
				+ "Phone Number: <INPUT TYPE=\"TEXT\" NAME=\"PhNumber\"><BR><CENTER><INPUT TYPE=\"SUBMIT\" VALUE=\"Commit to request\"></CENTER></FORM>");
		out.println("<h2><a href=\"WakeUpRequest.jsp\">Make your own request</a></h2>"+
		"<h2><a href=\"MembersHome.jsp\">Home</a></h2>\n</body>\n</html>");
		out.flush();
		}
		
		
		
	}
}