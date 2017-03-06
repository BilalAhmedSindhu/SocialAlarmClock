package SocialAlarmClockJava;

import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
// Class to end the tracking of the member that is currently logged on. When the user clicks log out, this class will removed the user from the loggedonusers table in the DB
// Thus signing him out and redirecting him to home
@WebServlet("/LogOut")

public class LogOut  extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	private String SessionID;
	
	public LogOut(){
		super();
		
	}
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		this.SessionID = session.getId();
		RemoveUserFromLoggedInUsers removeuser = new RemoveUserFromLoggedInUsers();
		removeuser.RemoveUser(this.SessionID);
		response.sendRedirect("Home.jsp"); 
	
	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		}

	

}