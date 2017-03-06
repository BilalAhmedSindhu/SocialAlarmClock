package SocialAlarmClockJava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
/* This class just shows the wakeup requests made by the logged on user only. If no requests have been made by him/her, the appropiate message will be display */

@WebServlet("/ViewRequestsMadeByUser")
public class ViewRequestsMadeByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iterator inputIterator;
    public ViewRequestsMadeByUser() {
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
	    		+ "<TITLE> View Requests Made " +   "</TITLE></HEAD>\n" + " <body>\n<center>\n" +
	    		"<h1>View Requests Made</h1>	</center><div align=\"right\"><embed src=http://flash-clocks.com/free-flash-clocks-blog-topics/free-flash-clock-176.swf width=150 height=50 wmode=window type=application/x-shockwave-flash></embed></div><br>\n");
		HttpSession session = request.getSession();
		LoggedInUsers UserEmail1 = new LoggedInUsers();
		String Email=UserEmail1.ReturnEmailOfLoggedInUser(session.getId());
		List RequestsList =  new ArrayList();    
		WakeUpRequestsMadeByUserFromDB GetAllRequests = new WakeUpRequestsMadeByUserFromDB();
		RequestsList = GetAllRequests.GetRequestsMadeByUser(Email);
		
		if(RequestsList.isEmpty()){
			out.println("<h2><font color=\"red\">No Record of Requests Being Made</h2></font><br>"
				+	"<h2><a href=\"WakeUpRequest.jsp\">Make a Request</a></h2>"
					+ "<h2><a href=\"MembersHome.jsp\">Home</a></h2>\n</body>\n</html>");
		}
		else{
			out.println("<table border=\"1\">\n <tr> <font color=\"blue\"><th>Request ID</th>\n <th>Email</th>\n <th>Phone Number</th>\n"
					+ "<th>Time(Hours)</th>\n <th>Time(Minutes)</th>\n <th>Day</th>\n <th>Month</th>\n <th>Year</th>\n</font>\n</tr>\n");
		inputIterator = RequestsList.iterator();
		while(inputIterator.hasNext()){
			WakeUpRequest temprequest = (WakeUpRequest) inputIterator.next();
			
			out.println("<tr> <td><b>"+temprequest.returnRequestID()+"</b></td>\n<td><b>"+Email+"</b></td>\n<td><b>"+temprequest.returnPhNumber()+"</b></td>\n"
					+"<td><b>"+temprequest.returnTimeHours()+"</b></td>\n<td><b>"+temprequest.returnTimeMinutes()+"</b></td>\n"
					+"<td><b>"+temprequest.returnDay()+"</b></td>\n<td><b>"+temprequest.returnMonth()+"</b></td>\n<td><b>"+temprequest.returnYear()+"</b></td>\n"+
					"</tr>");
			
		}
		
		out.println("</table><br><h2><a href=\"WakeUpRequest.jsp\">Make another request</a></h2>"+
		"<h2><a href=\"MembersHome.jsp\">Home</a></h2>\n</body>\n</html>");
		out.flush();
		}
	}
}
