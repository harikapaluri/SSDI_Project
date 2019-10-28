/*
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.Assert.assertTrue;
 * 
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.SQLException;
 * 
 * import org.junit.Test;
 * 
 * public class JUnit { static Connection connObj = null; //This is sample test
 * case to show that junit is up and running
 * 
 * @Test public void testSetup() { String str= "I am done with Junit setup";
 * assertEquals("I am done with Junit setup",str); } //This is sample test case
 * to show that database connection is up and running
 * 
 * @Test public void ConnectionTest() throws SQLException { String dbName =
 * "Sample"; String userName = "utkarsha"; String password = "utkarsha"; String
 * hostname = "ssdi-project-db.cxqdrxxfwjtl.us-east-2.rds.amazonaws.com"; String
 * port = "3306"; String jdbcUrl =
 * "jdbc:mysql://ssdi-project-db.cxqdrxxfwjtl.us-east-2.rds.amazonaws.com:3306/Sample?useSSL=false";
 * connObj = DriverManager.getConnection(jdbcUrl,userName,password);
 * assertTrue("DB connection Succesful",connObj!=null); } }
 */