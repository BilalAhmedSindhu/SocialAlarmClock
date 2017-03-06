package SocialAlarmClockJava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;
/* Processing the information recieved in the login form. Sends the information to be checked, and if success is positive it will direct the user to the members home. */

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetUserDataFromDB GatherUserData = new GetUserDataFromDB();
		List CompareUser =  new ArrayList();
		CompareUser = GatherUserData.GetAllUsersData();
		boolean Success = false;
		CheckLoginDetails CheckLoginDetailsVar = new CheckLoginDetails (CompareUser,request.getParameter("Email"),request.getParameter("PassW"));
		Success = CheckLoginDetailsVar.confirmlogin();
		
		if (Success){
		HttpSession session = request.getSession();
			LoggedInUsers login = new LoggedInUsers();
		login.StoreSession(request.getParameter("Email"),session.getId());
		
			response.sendRedirect("MembersHome.jsp"); 
		}
			else
			response.sendRedirect("LoginFailed.jsp");

	}


}
