package SocialAlarmClockJava;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
/* This processes the details provided by the new user in the registration form. We then take all that information and send it to be stored in the DB
 */

@WebServlet("/GetUserDetails") //Name of the servlet
public class GetUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        
    UserTuple newuser= new UserTuple(request.getParameter("Fname"),request.getParameter("Lname"),request.getParameter("YearB"),//Storing the just recieved info into a new temp user variable 
    request.getParameter("DayB"),request.getParameter("MonthB"),request.getParameter("Gender"),request.getParameter("Country"),
    request.getParameter("City"),request.getParameter("Email"),request.getParameter("PassW"));
    InsertNewUserIntoDB NewUserGoingIn = new InsertNewUserIntoDB();
    NewUserGoingIn.NewUser(newuser);  //Storing the User permanently    
    response.sendRedirect("Login.jsp"); 
  
  }

}

