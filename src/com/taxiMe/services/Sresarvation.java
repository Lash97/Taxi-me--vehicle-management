package com.taxiMe.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.taxiMe.interfaces.Iresarvation;
import com.taxiMe.model.Resarvation; 
import com.taxiMe.utill.DBConnection;

public class Sresarvation implements Iresarvation{
	private static Connection connection;
	private static Statement statement ;
	@Override
	public ArrayList<Resarvation> getResarvationList() {

		ArrayList<Resarvation> list = new ArrayList<Resarvation>();
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.resarvation  ";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	            	
	            	 
	            	Resarvation resarvation = new Resarvation(); 
	            	resarvation.setId(result.getInt("id"));
	            	resarvation.setVehicleId(result.getString("vehicalId"));
	            	resarvation.setUserId(result.getInt("userId"));
	            	resarvation.setPickupLocation(result.getString("pickLocation"));
	            	resarvation.setDropLocation(result.getString("dropLocation"));
	            	resarvation.setDate(result.getString("date"));
	            	resarvation.setTime(result.getString("time"));
	            	resarvation.setVehicleType(result.getString("vehicleType"));
	            	resarvation.setStatus(result.getString("status"));
	            	list.add(resarvation);
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
	public Resarvation getResarvation(int id) {
		Resarvation resarvation = new Resarvation(); 
		
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.resarvation where id='"+id+"'";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	             
	            	resarvation.setId(result.getInt("id"));
	            	resarvation.setVehicleId(result.getString("vehicalId"));
	            	resarvation.setUserId(result.getInt("userId"));
	            	resarvation.setPickupLocation(result.getString("pickLocation"));
	            	resarvation.setDropLocation(result.getString("dropLocation"));
	            	resarvation.setDate(result.getString("date"));
	            	resarvation.setTime(result.getString("time"));
	            	resarvation.setVehicleType(result.getString("vehicleType"));
	            	resarvation.setStatus(result.getString("status"));
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
	        return resarvation;
	}

	@Override
	public ArrayList<Resarvation> getResarvationByUserId(int userId) {
		 ArrayList<Resarvation> list= new  ArrayList<Resarvation>(); 
		
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.resarvation where userId='"+userId+"'";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	            	Resarvation resarvation = new Resarvation(); 
	            	resarvation.setId(result.getInt("id"));
	            	resarvation.setVehicleId(result.getString("vehicalId"));
	            	resarvation.setUserId(result.getInt("userId"));
	            	resarvation.setPickupLocation(result.getString("pickLocation"));
	            	resarvation.setDropLocation(result.getString("dropLocation"));
	            	resarvation.setDate(result.getString("date"));
	            	resarvation.setTime(result.getString("time"));
	            	resarvation.setVehicleType(result.getString("vehicleType"));
	            	resarvation.setStatus(result.getString("status"));
	            	list.add(resarvation);
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
	public ArrayList<Resarvation> getResarvationByStatus(String status) {

		ArrayList<Resarvation> list = new ArrayList<Resarvation>();
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.resarvation where status='"+status+"'  ";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	            	
	            	 
	            	Resarvation resarvation = new Resarvation(); 
	            	resarvation.setId(result.getInt("id"));
	            	resarvation.setVehicleId(result.getString("vehicalId"));
	            	resarvation.setUserId(result.getInt("userId"));
	            	resarvation.setPickupLocation(result.getString("pickLocation"));
	            	resarvation.setDropLocation(result.getString("dropLocation"));
	            	resarvation.setDate(result.getString("date"));
	            	resarvation.setTime(result.getString("time"));
	            	resarvation.setVehicleType(result.getString("vehicleType"));
	            	resarvation.setStatus(result.getString("status"));
	            	list.add(resarvation);
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
	public boolean addResarvation(Resarvation resarvation) {
		boolean isSuccess = false;
		
		try {
			 
			//create db connection
	       	connection = (Connection) DBConnection.getConnection();
	        statement = (Statement) connection.createStatement();
	        
	         //sql query
	        String sql = " INSERT INTO taxime.resarvation  (  `userId`,`vehicalId`, `pickLocation`, `dropLocation`, `time`, `date`, `vehicleType`, `status` ) VALUES"
	        		+ " ( '"+resarvation.getUserId()+"', '"+resarvation.getVehicleId()+"', '"+resarvation.getPickupLocation()+"', "
	        				+ "'"+resarvation.getDropLocation()+"', '"+resarvation.getTime()+"' , '"+resarvation.getDate()+"'"
	        						+ ", '"+resarvation.getVehicleType()+"', '"+resarvation.getStatus()+"') ";
	    		   
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
	public boolean updateResarvation(Resarvation resarvation) {
		//create return statement
				boolean isSuccess = false;
				
				//set object value to local variables
		        
		  	  try {
		  	   
			  		  //create db connection
			         connection = (Connection) DBConnection.getConnection();
			         statement =  (Statement) connection.createStatement();
			          //create sql query
			          String sql ="UPDATE taxime.resarvation SET  `vehicalId` = '"+resarvation.getVehicleId()+"', `pickLocation` = '"+resarvation.getPickupLocation()+"'"
			          		+ ", `dropLocation` = '"+resarvation.getDropLocation()+"', `time` = '"+resarvation.getTime()+"', `date` = '"+resarvation.getDate()+"'"
			          				+ ", `vehicleType` = '"+resarvation.getVehicleType()+"', `status` = '"+resarvation.getStatus()+"'"
			          				+ "  WHERE (`id` = '"+resarvation.getId()+"');";
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
	public boolean deleteResarvation(int id) {
		boolean isSuccess = false ;
		try {
    		//create db connection
    	    connection = (Connection) DBConnection.getConnection();
            statement =  (Statement) connection.createStatement();
            //sql query statement
            String sql = "DELETE FROM taxime.resarvation WHERE (`id` = '"+id+"');";
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
	public boolean clangeResarvationStatus(int id, String status) {
		//create return statement
		boolean isSuccess = false;
		
		//set object value to local variables
        
  	  try {
  	   
	  		  //create db connection
	         connection = (Connection) DBConnection.getConnection();
	         statement =  (Statement) connection.createStatement();
	          //create sql query
	          String sql ="UPDATE taxime.resarvation SET  `status` = '"+status+"'  WHERE (`id` = '"+id+"');";
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
	public ArrayList<Resarvation> getResarvationByVehicle(String id) {
		ArrayList<Resarvation> list = new ArrayList<Resarvation>();
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.resarvation where vehicalId='"+id+"'  ";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	            	
	            	 
	            	Resarvation resarvation = new Resarvation(); 
	            	resarvation.setId(result.getInt("id"));
	            	resarvation.setVehicleId(result.getString("vehicalId"));
	            	resarvation.setUserId(result.getInt("userId"));
	            	resarvation.setPickupLocation(result.getString("pickLocation"));
	            	resarvation.setDropLocation(result.getString("dropLocation"));
	            	resarvation.setDate(result.getString("date"));
	            	resarvation.setTime(result.getString("time"));
	            	resarvation.setVehicleType(result.getString("vehicleType"));
	            	resarvation.setStatus(result.getString("status"));
	            	list.add(resarvation);
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
