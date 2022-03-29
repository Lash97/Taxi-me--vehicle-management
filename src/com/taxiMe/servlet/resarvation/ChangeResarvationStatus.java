package com.taxiMe.servlet.resarvation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taxiMe.interfaces.Iresarvation;
import com.taxiMe.interfaces.Ivehicle;
import com.taxiMe.services.Sresarvation;
import com.taxiMe.services.Svehicle;

/**
 * Servlet implementation class ChangeResarvationStatus
 */ 
public class ChangeResarvationStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeResarvationStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		// create boolean variable for get out put of query
		boolean isTrue;
		
		Iresarvation service = new Sresarvation();
		Ivehicle vehicleservice = new Svehicle();
		
		//call function
		try {
			
			isTrue = service.clangeResarvationStatus(id,status) ;
			if(request.getParameter("vid") != "null") {
				vehicleservice.changeVehicleStatus( "not-assigned",request.getParameter("vid"));
			}
			if(isTrue == true) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
				dispatcher.forward(request, response);
				
			}
			else { 
				 
				 
				RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
				dispatcher.forward(request, response);
				
			}
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
