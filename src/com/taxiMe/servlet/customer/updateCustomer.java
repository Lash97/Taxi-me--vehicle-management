package com.taxiMe.servlet.customer;

import java.io.IOException;
import java.util.InputMismatchException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taxiMe.interfaces.Icustomer;
import com.taxiMe.model.Customer;
import com.taxiMe.model.User;
import com.taxiMe.services.Scustomer;

/**
 * Servlet implementation class updateCustomer
 */ 
public class updateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isTrue; 
		Customer customer= new Customer();
		Icustomer service  = new Scustomer();				
		 
		int tp = Integer.parseInt(request.getParameter("tel")); 
		int id = Integer.parseInt(request.getParameter("id")); 
		 
		customer.setId(id);
		customer.setName(request.getParameter("name"));
		customer.setMail(request.getParameter("email")); 
		customer.setTelephone(tp); 
		customer.setGender(request.getParameter("gender")); 
		customer.setAddress(request.getParameter("address"));
		customer.setUserName( request.getParameter("uName")); 
		customer.setPassword(request.getParameter("password")); 
		
		  
		try {
			
			isTrue = service.updateCustomer(customer);
			
			//if return value is true
			if(isTrue == true) {
			  
				RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerManegment.jsp");
				dispatcher.forward(request, response);
			}
			else { 
				RequestDispatcher dispatcher = request.getRequestDispatcher("customerUpdate.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		catch ( InputMismatchException  e) {
			e.printStackTrace();
		}
	}

}
