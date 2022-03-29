package com.taxiMe.servlet.rating;

import java.io.IOException;
import java.util.InputMismatchException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taxiMe.interfaces.Irating;
import com.taxiMe.model.Rating;
import com.taxiMe.services.Srating;

 
/**
 * Servlet implementation class addRating
 */ 
public class addRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRating() {
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
		Rating rating= new Rating();
		Irating service  = new Srating();				

		int rate = Integer.parseInt(request.getParameter("rate"));
		int uid = Integer.parseInt(request.getParameter("uid")); 
		
		rating.setUserid(uid); 
		rating.setRating(rate);
		rating.setDescription( request.getParameter("des")); 
		
		  
		try {
			
			isTrue = service.addRating(rating);
			
			//if return value is true
			if(isTrue == true) {
			  
				RequestDispatcher dispatcher = request.getRequestDispatcher("aboutUs.jsp");
				dispatcher.forward(request, response);
			}
			else { 
				RequestDispatcher dispatcher = request.getRequestDispatcher("aboutUs.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		catch ( InputMismatchException  e) {
			e.printStackTrace();
		}
	}

}
