package com.taxiMe.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.taxiMe.interfaces.Iaccident;
import com.taxiMe.model.Accident; 
import com.taxiMe.utill.DBConnection;

public class Saccident implements Iaccident{

	private static Connection connection;
	private static Statement statement ;
	
	@Override
	public ArrayList<Accident> getAccidentList() {
		ArrayList<Accident> list = new ArrayList<Accident>();
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.accident  ";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	            	
	            	 
	            	Accident accident = new Accident(); 
	            	accident.setId(result.getInt("id"));
	            	accident.setVehicleId(result.getString("vehicleNumber"));
	            	accident.setLocation(result.getString("location"));
	            	accident.setTime(result.getString("time")); 
	            	accident.setDate(result.getString("date"));
	            	accident.setVehicleType(result.getString("vehicleType")); 
	            	accident.setDrivername(result.getString("driverName")); 
	            	list.add(accident);
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
	public Accident getAccident(int id) {
		Accident accident = new Accident(); 
		
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.accident  WHERE id = '"+id+"'";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	             
	            	accident.setId(result.getInt("id"));
	            	accident.setVehicleId(result.getString("vehicleNumber"));
	            	accident.setLocation(result.getString("location"));
	            	accident.setTime(result.getString("time")); 
	            	accident.setDate(result.getString("date"));
	            	accident.setVehicleType(result.getString("vehicleType")); 
	            	accident.setDrivername(result.getString("driverName")); 
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
	        return accident;
	}

	@Override
	public boolean addAccident(Accident accident) {
		boolean isSuccess = false;
		
		try {
			 
			//create db connection
	       	connection = (Connection) DBConnection.getConnection();
	        statement = (Statement) connection.createStatement();
	        
	         //sql query
	        String sql = " INSERT INTO taxime.accident  (  `vehicleNumber`,`location`, `vehicleType`, `time`, `date`, `driverName`) VALUES"
	        		+ " ( '"+accident.getVehicleId()+"', '"+accident.getLocation()+"', '"+accident.getVehicleType()+"', "
	        				+ "'"+accident.getTime()+"', '"+accident.getDate()+"' , '"+accident.getDrivername()+"') ";
	    		   
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
	public boolean updateAccident(Accident accident) {
		//create return statement
		boolean isSuccess = false;
		
		//set object value to local variables
        
  	  try {
  	   
	  		  //create db connection
	         connection = (Connection) DBConnection.getConnection();
	         statement =  (Statement) connection.createStatement();
	          //create sql query
	          String sql ="UPDATE taxime.accident SET  `vehicleNumber` = '"+accident.getVehicleId()+"', `location` = '"+accident.getLocation()+"', `vehicleType` = '"+accident.getVehicleType()+"', `time` = '"+accident.getTime()+"', `date` = '"+accident.getDate()+"'"
	          				+ ", `driverName` = '"+accident.getDrivername()+"'"
	          				+ "  WHERE (`id` = '"+accident.getId()+"');";
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
	public boolean deleteAccident(int id) {
		boolean isSuccess = false ;
		try {
    		//create db connection
    	    connection = (Connection) DBConnection.getConnection();
            statement =  (Statement) connection.createStatement();
            //sql query statement
            String sql = "DELETE FROM taxime.accident WHERE (`id` = '"+id+"');";
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
	public ArrayList<Accident> getAccidentByVehicleId(String id) {
		ArrayList<Accident> list = new ArrayList<Accident>();
		try {
	        	
	            connection = (Connection) DBConnection.getConnection();
	            statement =  (Statement) connection.createStatement();
	            
	            String sql = "SELECT * FROM taxime.accident where vehicleNumber='"+id+"'  ";
	            PreparedStatement statement =  connection.prepareStatement(sql);
	       
	            ResultSet result = statement.executeQuery();
	
	            while(result.next()){
	            	
	            	 
	            	Accident accident = new Accident(); 
	            	accident.setId(result.getInt("id"));
	            	accident.setVehicleId(result.getString("vehicleNumber"));
	            	accident.setLocation(result.getString("location"));
	            	accident.setTime(result.getString("time")); 
	            	accident.setDate(result.getString("date"));
	            	accident.setVehicleType(result.getString("vehicleType")); 
	            	accident.setDrivername(result.getString("driverName")); 
	            	list.add(accident);
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
