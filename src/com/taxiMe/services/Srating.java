package com.taxiMe.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.taxiMe.interfaces.Irating;
import com.taxiMe.model.Rating;  
import com.taxiMe.utill.DBConnection;
 

public class Srating implements Irating{
	private static Connection connection;
	private static Statement statement ;
	@Override
	public ArrayList<Rating> getRatingList() {
		ArrayList<Rating> list = new ArrayList<Rating>();
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.rating  ";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	            	
	            	 
	            	Rating rating = new Rating(); 
	            	rating.setId(result.getInt("id"));
	            	rating.setUserid(result.getInt("customerId"));
	            	rating.setRating(result.getInt("stars"));
	            	rating.setDescription(result.getString("description")); 
	            	list.add(rating);
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
	public Rating getRating(int id) {
		Rating rating = new Rating(); 
		
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.rating where customerId='"+id+"'";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	             
	            	rating.setId(result.getInt("id"));
	            	rating.setUserid(result.getInt("customerId"));
	            	rating.setRating(result.getInt("stars"));
	            	rating.setDescription(result.getString("description")); 
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
	        return rating;
	}

	@Override
	public boolean addRating(Rating rating) {
		boolean isSuccess = false;
		
		try {
			 
			//create db connection
	       	connection = (Connection) DBConnection.getConnection();
	        statement = (Statement) connection.createStatement();
	        
	         //sql query
	        String sql = " INSERT INTO taxime.rating  (`customerId`,  `stars`,`description`  ) VALUES"
	        		+ " (  '"+rating.getUserid()+"', '"+rating.getRating()+"', "
	        				+ "'"+rating.getDescription()+"' ) ";
	    		   
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
	public boolean updateRating(Rating rating) {
				//create return statement
				boolean isSuccess = false;
				
				//set object value to local variables
		        
		  	  try {
		  	   
			  		  //create db connection
			         connection = (Connection) DBConnection.getConnection();
			         statement =  (Statement) connection.createStatement();
			          //create sql query
			          String sql ="UPDATE taxime.rating SET  `stars` = '"+rating.getRating()+"',"
			          		+ " `description` = '"+rating.getDescription()+"' "
			          				+ "  WHERE (`customerId` = '"+rating.getUserid()+"');";
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
	public boolean deleteRating(int id) {
		boolean isSuccess = false ;
		try {
    		//create db connection
    	    connection = (Connection) DBConnection.getConnection();
            statement =  (Statement) connection.createStatement();
            //sql query statement
            String sql = "DELETE FROM taxime.rating WHERE (`id` = '"+id+"');";
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

	@Override
	public ArrayList<Rating> getRatingLByStar(int star) {
		ArrayList<Rating> list = new ArrayList<Rating>();
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.rating  WHERE stars='"+star+"'";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	            	
	            	 
	            	Rating rating = new Rating(); 
	            	rating.setId(result.getInt("id"));
	            	rating.setUserid(result.getInt("customerId"));
	            	rating.setRating(result.getInt("stars"));
	            	rating.setDescription(result.getString("description")); 
	            	list.add(rating);
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
	
}
