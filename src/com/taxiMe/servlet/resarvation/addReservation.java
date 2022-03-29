package com.taxiMe.servlet.resarvation;

import java.io.IOException;
import java.util.InputMismatchException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taxiMe.interfaces.Iresarvation;
import com.taxiMe.interfaces.Ivehicle;
import com.taxiMe.model.Resarvation;
import com.taxiMe.services.Sresarvation;
import com.taxiMe.services.Svehicle;

 

/**
 * Servlet implementation class addReservation
 */ 
public class addReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isTrue; 
		Resarvation resarvation= new Resarvation();
		Iresarvation service  = new Sresarvation();				
 
		int uid = Integer.parseInt(request.getParameter("cusName")); 
		
		resarvation.setUserId(uid); 
		resarvation.setDropLocation(request.getParameter("drop_location"));
		resarvation.setPickupLocation( request.getParameter("pick_location"));
		resarvation.setTime(request.getParameter("time"));
		resarvation.setVehicleId( request.getParameter("VNumber"));
		resarvation.setVehicleType(request.getParameter("type"));
		resarvation.setDate( request.getParameter("date")); 
		
		if(request.getParameter("VNumber") == null) {
			resarvation.setStatus("Pending");
		}
		else {
			resarvation.setStatus("Assinged");
			Ivehicle vehicleService = new Svehicle();
			vehicleService.changeVehicleStatus("Assinged", request.getParameter("VNumber"));
		}
		  
		try {
			
			isTrue = service.addResarvation(resarvation);
			
			//if return value is true
			if(isTrue == true) {
			  
				RequestDispatcher dispatcher = request.getRequestDispatcher("resarvationManegment.jsp");
				dispatcher.forward(request, response);
			}
			else { 
				RequestDispatcher dispatcher = request.getRequestDispatcher("resarvationManegment.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		catch ( InputMismatchException  e) {
			e.printStackTrace();
		}
	}

}
