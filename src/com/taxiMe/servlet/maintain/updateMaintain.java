package com.taxiMe.servlet.maintain;

import java.io.IOException;
import java.util.InputMismatchException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taxiMe.interfaces.Imaintain;
import com.taxiMe.model.Maintaine;
import com.taxiMe.services.Smaintain;

/**
 * Servlet implementation class updateMaintain
 */ 
public class updateMaintain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateMaintain() {
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
		Maintaine maintaine= new Maintaine();
		Imaintain service  = new Smaintain();				

		int qty = Integer.parseInt(request.getParameter("qty"));
		int pid = Integer.parseInt(request.getParameter("part_id"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		maintaine.setId(id);
		maintaine.setVehicleId(request.getParameter("VNumber"));
		maintaine.setStatus(request.getParameter("status")); 
		maintaine.setQty(qty); 
		maintaine.setPartId(pid); 
		maintaine.setDate(request.getParameter("date"));
		maintaine.setDescription( request.getParameter("des")); 
		
		  
		try {
			
			isTrue = service.updateMaintaine(maintaine);
			
			//if return value is true
			if(isTrue == true) {
			  
				RequestDispatcher dispatcher = request.getRequestDispatcher("VehicleMaintainesManegment.jsp");
				dispatcher.forward(request, response);
			}
			else { 
				RequestDispatcher dispatcher = request.getRequestDispatcher("vehicleMaintaines.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		catch ( InputMismatchException  e) {
			e.printStackTrace();
		}
	}

}
