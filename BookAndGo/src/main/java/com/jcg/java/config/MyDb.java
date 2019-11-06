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

	/***** Method #1 :: This Method Is Used To Create A Connection With The Database *****/
	public  Connection connectDb() {
		
		String dbName = "test";
	      String userName = "harika";
	      String password =  "password";
	      String hostname = "ssdi-project-db.cxqdrxxfwjtl.us-east-2.rds.amazonaws.com";
	      String port = "3306";
	      String jdbcUrl = "jdbc:mysql://localhost:3306/bookandgo";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connObj = DriverManager.getConnection(jdbcUrl,userName,password);			
		} catch (Exception exObj) {
			exObj.printStackTrace();
		}
		return connObj;
	}

	/***** Method #2 :: This Method Is Used To Retrieve The Records From The Database *****/
	public  List<Employee> getEmployeeListFromDb() {		
		Employee emp = null;
		List<Employee> eList = new ArrayList<Employee>();
		try {
			stmtObj = connectDb().createStatement();
           	String sql = "SELECT * FROM employeetbl";
			rsObj = stmtObj.executeQuery(sql);
			while(rsObj.next()) {
				emp = new Employee(rsObj.getInt("e_id"), rsObj.getString("e_name"), rsObj.getString("e_email"), rsObj.getString("e_gender"));
				eList.add(emp);
			}
		} catch (SQLException sqlExObj) {
			sqlExObj.printStackTrace();
		} finally {
			disconnectDb();
		}
		return eList;
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
	//Method to get details searched by user
		public  List<Hotel> getHotelListFromDb() {		
			Hotel hotel = null;
			List<Hotel> eList = new ArrayList<Hotel>();
			try {
				stmtObj = connectDb().createStatement();
	           	String sql = "SELECT * FROM hotel_dummy";
				rsObj = stmtObj.executeQuery(sql);
				while(rsObj.next()) {
					hotel = new Hotel(rsObj.getInt("hotel_id"), rsObj.getString("hotel_name"), rsObj.getString("hotel_address"),rsObj.getInt("Event_id"),rsObj.getInt("Room_id"));
					eList.add(hotel);
				}
			} catch (SQLException sqlExObj) {
				sqlExObj.printStackTrace();
			} finally {
				disconnectDb();
			}
			return eList;
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

	
	  public String saveHotelDetails(Hotel hotel) { // TODO Auto-generated method
	 String response="Db error"; try {
	 
	  String sql ="INSERT INTO Hotel " + "VALUES (?,?,?, ?, ?,?)";
	  java.sql.PreparedStatement ps = connectDb().prepareStatement(sql);
	  ps.setString(1,hotel.getHotel_name()); ps.setInt(2,1);
	  ps.setString(3,hotel.getHotel_address()); ps.setInt(4,0); ps.setInt(5,0);
	  ps.setString(6,hotel.getHotel_contact()); rsObj = stmtObj.executeQuery(sql);
	  
	  if(rsObj.rowInserted()){ response="Added";
	  
	  }
	  
	  
	  } catch (SQLException sqlExObj) { sqlExObj.printStackTrace(); } finally {
	  disconnectDb(); return response; } }
	 
}