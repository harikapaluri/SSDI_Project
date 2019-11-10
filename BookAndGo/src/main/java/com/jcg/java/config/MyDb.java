package com.jcg.java.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jcg.java.model.Employee;
import com.jcg.java.model.Hotel;
import com.jcg.java.model.User;
import com.mysql.jdbc.PreparedStatement;

public class MyDb {

	public static ResultSet rsObj = null;
	public static Statement stmtObj = null;
	public static Connection connObj = null;
    public static DbDetails dbDetails=new DbDetails(); 
	/***** Method #1 :: This Method Is Used To Create A Connection With The Database *****/
	public static  Connection connectDb() {
		
		
	      String userName =dbDetails.getUserName();
	      String password =dbDetails.getPassword();
	      String jdbcUrl =dbDetails.getJdbcUrl();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connObj = DriverManager.getConnection(jdbcUrl,userName,password);			
		} catch (Exception exObj) {
			exObj.printStackTrace();
		}
		return connObj;
	}

	

	/***** Method #3 :: This Method Is Used To Close The Connection With The Database *****/
	public  void disconnectDb() {
		try {
			rsObj.close();
			stmtObj.close();
			connObj.close();
		} catch (SQLException sqlExObj) {
			sqlExObj.printStackTrace();
		}		
	}
		//Method to get username and password searched by user
		public String getLoginDetailsFromDb(User user){
			String response="No user Exists";
			String correctpwd="";
			try {
		   	String sql ="select *  from USERS WHERE users_email = '" + user.users_email + "' AND users_password = " + user.users_password ;
	           	stmtObj = connectDb().prepareStatement(sql);
				rsObj = stmtObj.executeQuery(sql);
				
		        if(rsObj.next()){
		        	correctpwd=rsObj.getString("users_password");
					
				}
		        
		        if(correctpwd.equalsIgnoreCase(user.users_password)) {
		        	response="Logged in";
		        	
		        }else {
		        
		        }
				
			} catch (SQLException sqlExObj) {
				sqlExObj.printStackTrace();
			} finally {
			disconnectDb();
			return response;
			}
			
			
		}

		  
	  //Method to get search Results from DB
	public List<Hotel> getSearchDetails(String searchString) {
		Hotel hotel = null;
		List<Hotel> eList = new ArrayList<Hotel>();
		String sql ="SELECT * FROM (SELECT * FROM hotel) t1 LEFT OUTER JOIN (SELECT * FROM event_table) t2 ON t1.event_id = t2.event_id WHERE t1.hotel_name='"+searchString + "'OR t2.event_name='"+searchString+"'OR t1.hotel_address='"+searchString+"'" ;
       	try{stmtObj = connectDb().prepareStatement(sql);
		rsObj = stmtObj.executeQuery(sql);
		//Getting the hotel details from search 
while(rsObj.next()) {
	hotel = new Hotel(rsObj.getInt("hotel_id"), rsObj.getString("hotel_name"), rsObj.getString("hotel_address"),rsObj.getInt("Room_id"));
	      if(rsObj.getString("event_id")!=null)
	      { hotel.setEvent_name(rsObj.getString("event_name"));
	        hotel.setEvent_id(rsObj.getInt("event_id"));
	        hotel.setEvent_times(rsObj.getString("event_times"));}
	eList.add(hotel);	
       	}
       	
       	
       	}
       	
       	
       	
       	catch(SQLException sqlExObj) {
       		sqlExObj.printStackTrace();
       	}
       	finally {
       		return eList;
       	}
		
	}
	 
}