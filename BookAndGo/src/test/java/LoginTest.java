

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.jcg.java.config.DbDetails;
import com.jcg.java.config.MyDb;
import com.jcg.java.model.User;



@RunWith(MockitoJUnitRunner.class)
public class LoginTest {
//Here we need to test three scenario's 
	//Entered data is wrong case
	//Entered data is right
	//No data at all in the database
	//Get service for login details test.
		
	DbDetails dbDetails;
	private Connection con;
	private Statement st;
	private ResultSet rsObj;
	 MyDb myDb=new MyDb();

	@Before
	 public void setUp() throws Exception {
		//Creating mock object of my db class
		
       con=myDb.connectDb();
       st=con.createStatement();
       
	 }
	
	@Test
	public void testLogin(){
		//Set dummy data for login
		User user=new User();
        user.setUsers_email("ssmith@gmail.com");
        user.setUsers_password("1234");
        String returned=myDb.getLoginDetailsFromDb(user);
		assertEquals("Logged in",returned);//TO verify that the method was called with the right parameters
		
	}
	@Test
	public void testwrongLogin() {
		User user=new User();
        user.setUsers_email("ssmith@gmail.com");
        user.setUsers_password("xyz");
        String returned=myDb.getLoginDetailsFromDb(user);
		assertEquals("No user Exists",returned);
	}
	@Test
	public void testNoDataLogin() {
		User user=new User();
        String returned=myDb.getLoginDetailsFromDb(user);
		assertEquals("No user Exists",returned);
	}
    
}
