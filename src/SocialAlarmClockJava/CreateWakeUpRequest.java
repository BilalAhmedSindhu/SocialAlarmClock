package SocialAlarmClockJava;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;
/* this class is called up when the user fills in his wake up request details in the form and we finalize it by storing it in the database */

@WebServlet("/CreateWakeUpRequest")
public class CreateWakeUpRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateWakeUpRequest() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoggedInUsers UserEmail = new LoggedInUsers();
		String Email=UserEmail.ReturnEmailOfLoggedInUser(session.getId());
		
		WakeUpRequest NewRequest = new WakeUpRequest (Email, request.getParameter("PhNumber"),request.getParameter("THours"),
				request.getParameter("TMinutes"),request.getParameter("Day"),request.getParameter("Month"),
				request.getParameter("Year"));
		NewRequest.StoreRequest();
		 response.sendRedirect("MembersHomeAfterRequestCreated.jsp");
		
	}



}