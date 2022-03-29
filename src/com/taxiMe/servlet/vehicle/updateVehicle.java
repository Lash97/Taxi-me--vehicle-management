package com.taxiMe.servlet.vehicle;

import java.io.IOException;
import java.util.InputMismatchException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taxiMe.interfaces.Ivehicle;
import com.taxiMe.model.Vehicle;
import com.taxiMe.services.Svehicle;

/**
 * Servlet implementation class updateVehicle
 */
 
public class updateVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateVehicle() {
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
		Vehicle vehicle= new Vehicle();
		Ivehicle service  = new Svehicle();				

		vehicle.setVehicleNumber(request.getParameter("vehicleNumber"));  
		int pass = Integer.parseInt(request.getParameter("noOfPAsengers"));
		vehicle.setStatus(request.getParameter("state")); 
		vehicle.setNoOfPasenger(pass);
		vehicle.setAddress(request.getParameter("address")); 
		vehicle.setType(request.getParameter("type")); 
		vehicle.setOwnerName(request.getParameter("ownerName"));   
		  
		try {
			
			isTrue = service.updateVehicle(vehicle);
			
			//if return value is true
			if(isTrue == true) {
			  
				RequestDispatcher dispatcher = request.getRequestDispatcher("VehicleManegment.jsp");
				dispatcher.forward(request, response);
			}
			else { 
				RequestDispatcher dispatcher = request.getRequestDispatcher("updateVehicle.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		catch ( InputMismatchException  e) {
			e.printStackTrace();
		}
		 
	}

}
