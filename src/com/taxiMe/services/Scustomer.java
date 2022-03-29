package com.taxiMe.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Statement;
import com.taxiMe.interfaces.Icustomer;
import com.taxiMe.model.Customer; 
import com.taxiMe.utill.DBConnection;

public class Scustomer implements Icustomer{

	private static Connection connection;
	private static Statement statement ;
	
	@Override
	public ArrayList<Customer> getCustomerList() {
		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
	        	
	            connection =  DBConnection.getConnection();
	            statement =    connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.customer  ";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	            	
	            	 
	            	Customer customer = new Customer(); 
	            	customer.setId(result.getInt("id"));
	            	customer.setName(result.getString("name"));
	            	customer.setMail(result.getString("mail"));
	            	customer.setTelephone(result.getInt("telephone"));   
	            	customer.setGender(result.getString("gender")); 
	            	customer.setUserName(result.getString("userName")); 
	            	customer.setPassword(result.getString("password")); 
	            	list.add(customer);
	            }
	         
	        }catch(Exception e) {
	        	e.printStackTrace();
	        } finally {
				
				try {
					
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        }
	        return list;
	
	}

	@Override
	public Customer getCustomer(int id) {
		Customer customer = new Customer(); 
		
		try {
	        	
	            connection =   DBConnection.getConnection();
	            statement =   connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.customer  WHERE id = '"+id+"'";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	             
	            	customer.setId(result.getInt("id"));
	            	customer.setName(result.getString("name"));
	            	customer.setMail(result.getString("mail"));
	            	customer.setTelephone(result.getInt("telephone"));   
	            	customer.setGender(result.getString("gender")); 
	            	customer.setUserName(result.getString("userName")); 
	            	customer.setPassword(result.getString("password")); 
	            }
	         
	        }catch(Exception e) {
	        	e.printStackTrace();
	        } finally {
				
				try {
					
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        }
	        return customer;
	}

	@Override
	public boolean addCustomer(Customer customer) {
boolean isSuccess = false;
		
		try {
			 
			//create db connection
	       	connection =  DBConnection.getConnection();
	        statement =  connection.createStatement();
	        
	         //sql query
	        String sql = " INSERT INTO taxime.customer  (  `name`,`mail`, `telephone`, `gender`, `userName`, `password`) VALUES"
	        		+ " ( '"+customer.getName()+"', '"+customer.getMail()+"' ,'"+customer.getTelephone()+"', "
	        				+ "'"+customer.getGender()+"', '"+customer.getUserName()+"', '"+customer.getPassword()+"') ";
	    		   
	       //execute query
	         int result = statement.executeUpdate(sql);
	   		 
	   		 if(result > 0) {
	   			 isSuccess = true;
	   		 }else {
	   			 isSuccess = false;
	   		 }
	   		 
	       }catch(SQLException  e) {
	    	   e.printStackTrace();
	       } finally {
				//close connection
				try {
					if(statement != null) {
						statement.close();
					}
					
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	    //return output
		return isSuccess;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		//create return statement
		boolean isSuccess = false;
		
		//set object value to local variables
        
  	  try {
  	   
	  		  //create db connection
	         connection =   DBConnection.getConnection();
	         statement =    connection.createStatement();
	          //create sql query
	          String sql ="UPDATE taxime.customer SET  `name` = '"+customer.getName()+"', `mail` = '"+customer.getMail()+"',"
	          		+ " `telephone` = '"+customer.getTelephone()+"', `gender` = '"+customer.getGender()+"'"
	          				+ ", `userName` = '"+customer.getUserName()+"', `password` = '"+customer.getPassword()+"'"
	          				+ "  WHERE (`id` = '"+customer.getId()+"');";
	        		  //
	          
	          int result =  statement.executeUpdate(sql);
	          
	          //if output have any value set return value true else set false
	          if(result>0) {
	              isSuccess = true;	
	          }
	          else {
	          	isSuccess = false;
	          }
          
	  	}catch(SQLException | NullPointerException  e) {  
	        e.printStackTrace();    
		} finally {
			//close connection
			try {
				if(statement != null) {
					statement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch ( SQLException e) {
				e.printStackTrace();
			}
		}
		//return isSuccess as true or false
	      return isSuccess;
	}

	@Override
	public boolean deleteCustomer(int id) {
		boolean isSuccess = false ;
		try {
    		//create db connection
    	    connection =   DBConnection.getConnection();
            statement =    connection.createStatement();
            //sql query statement
            String sql = "DELETE FROM taxime.customer WHERE (`id` = '"+id+"');";
            //execute delete query
            int result =  statement.executeUpdate(sql);
            //if query execute success return true and if not return false	
            if (result > 0) {
            	isSuccess = true;
            }
            else {
            	isSuccess = false;
            }
            
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
			//close connection
			try {
				if(statement != null) {
					statement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch ( SQLException e) {
				e.printStackTrace();
			}
    	}
    	
	return isSuccess;
	}

}
