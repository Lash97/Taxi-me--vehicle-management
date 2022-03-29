package com.taxiMe.servlet.resarvation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taxiMe.interfaces.Iresarvation;
import com.taxiMe.services.Sresarvation;

 
/**
 * Servlet implementation class deleteReservation
 */ 
public class deleteReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("id"));
		// create boolean variable for get out put of query
		boolean isTrue;
		
		Iresarvation service = new Sresarvation();
		
		
		//call function
		try {
			isTrue = service.deleteResarvation(id) ;
			
			if(isTrue == true) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("resarvationManegment.jsp");
				dispatcher.forward(request, response);
				
			}
			else { 
				 
				 
				RequestDispatcher dispatcher = request.getRequestDispatcher("resarvationManegment.jsp");
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
