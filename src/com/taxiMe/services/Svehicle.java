package com.taxiMe.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.taxiMe.interfaces.Ivehicle;
import com.taxiMe.model.Vehicle;
import com.taxiMe.utill.DBConnection; 

public class Svehicle implements Ivehicle{
	
	private static Connection connection;
	private static Statement statement ;
	
	@Override
	public ArrayList<Vehicle> getVehicleList() {


		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.vehicle  ";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	            	
	            	 
	            	Vehicle vehi = new Vehicle(); 
	            	vehi.setVehicleNumber(result.getString("vehicleNumber"));
	            	vehi.setType(result.getString("vehicleType"));
	            	vehi.setNoOfPasenger(result.getInt("numberOfPasenger"));
	            	vehi.setAddress(result.getString("address"));
	            	vehi.setStatus(result.getString("status"));
	            	vehi.setOwnerName(result.getString("ownerName"));
	            	list.add(vehi);
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
	public Vehicle getVehicle(String id) {
		Vehicle vehi = new Vehicle(); 
		
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.vehicle where vehicleNumber='"+id+"'";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	             
	            	vehi.setVehicleNumber(result.getString("vehicleNumber"));
	            	vehi.setType(result.getString("vehicleType"));
	            	vehi.setNoOfPasenger(result.getInt("numberOfPasenger"));
	            	vehi.setAddress(result.getString("address"));
	            	vehi.setStatus(result.getString("status"));
	            	vehi.setOwnerName(result.getString("ownerName"));
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
	        return vehi;
	}

	@Override
	public ArrayList<Vehicle> getVehicleByStatus(String status) {

		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.vehicle where status='"+status+"'";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	            	
	            	 
	            	Vehicle vehi = new Vehicle(); 
	            	vehi.setVehicleNumber(result.getString("vehicleNumber"));
	            	vehi.setType(result.getString("vehicleType"));
	            	vehi.setNoOfPasenger(result.getInt("numberOfPasenger"));
	            	vehi.setAddress(result.getString("address"));
	            	vehi.setStatus(result.getString("status"));
	            	vehi.setOwnerName(result.getString("ownerName"));	            	
	            	list.add(vehi);
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
	public boolean addvehicle(Vehicle vehicle) {
		boolean isSuccess = false;
		
		try {
			 
			//create db connection
	       	connection = (Connection) DBConnection.getConnection();
	        statement = (Statement) connection.createStatement();
	        
	         //sql query
	        String sql = " INSERT INTO taxime.vehicle  (`vehicleNumber`,  `numberOfPasenger`,`vehicleType`, `address`, `status`, `ownerName` ) VALUES"
	        		+ " ('"+vehicle.getVehicleNumber()+"', '"+vehicle.getNoOfPasenger()+"', '"+vehicle.getType()+"', "
	        				+ "'"+vehicle.getAddress()+"', '"+vehicle.getStatus()+"', '"+vehicle.getOwnerName()+"' ) ";
	    		   
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
	public boolean updateVehicle(Vehicle vehicle) {
		//create return statement
		boolean isSuccess = false;
		
		//set object value to local variables
        
  	  try {
  	   
	  		  //create db connection
	         connection = (Connection) DBConnection.getConnection();
	         statement =  (Statement) connection.createStatement();
	          //create sql query
	          String sql ="UPDATE taxime.vehicle SET  `numberOfPasenger` = '"+vehicle.getNoOfPasenger()+"',"
	          		+ " `vehicleType` = '"+vehicle.getType()+"', `address` = '"+vehicle.getAddress()+"',`status` ='"+vehicle.getStatus()+"',`ownerName` ='"+vehicle.getOwnerName()+"'"
	          				+ "  WHERE (`vehicleNumber` = '"+vehicle.getVehicleNumber()+"');";
	          
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
	public boolean deleteVehicle(String id) {
		boolean isSuccess = false ;
		try {
    		//create db connection
    	    connection = (Connection) DBConnection.getConnection();
            statement =  (Statement) connection.createStatement();
            //sql query statement
            String sql = "DELETE FROM taxime.vehicle WHERE (`vehicleNumber` = '"+id+"');";
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
	public void changeVehicleStatus(String status,String id) {
		//set object value to local variables
        
	  	  try {
	  	   
		  		  //create db connection
		         connection = (Connection) DBConnection.getConnection();
		         statement =  (Statement) connection.createStatement();
		          //create sql query
		          String sql ="UPDATE taxime.vehicle SET  `status` = '"+status+"'  WHERE (`vehicleNumber` = '"+id+"');";
		          
		          int result =  statement.executeUpdate(sql);
		          
		           
	          
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
		
	}

}
