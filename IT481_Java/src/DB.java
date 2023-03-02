import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

//Controller class for taking user requests 
//  and converting into database actions.
public class DB {
	
	//Connection object
	private Connection conn = null;
	
	//Database URL to connect
	private String dbURL;
	
	//Default constructor
	public DB () {
		
		
		 dbURL =
                "jdbc:sqlserver://NB69004BOB\\SQLEXPRESS;"
                        + "database=Northwind;"
                        + "user=sa;"
                        + "password=123456;"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
	}
	
	
	//Constructor taking a string connect request
	public DB(String connection) {
			
			dbURL = connection;
		 
	}
	
	//Method for querying for the customer count
	public String getCustomerCount() {
		
		String count = null;
		 
        try {
        	
            conn = DriverManager.getConnection(dbURL);
            
            if (conn != null) {
            	
            	String countQuery = "select count(*) as count from customers;";
            	Statement stmt = conn.createStatement();
            	ResultSet rs = stmt.executeQuery(countQuery);
            	
            	while ( rs.next() ) {
                   count = rs.getString("count");
                }
               
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return count;
	}

	//Method for getting and returning the company names
	public String getCompanyNames() {
		
		String result = "";
		
		try {
            conn = DriverManager.getConnection(dbURL);
            
            if (conn != null) {
            	
            	String countQuery = "select companyname from customers;";
            	Statement stmt = conn.createStatement();
            	ResultSet rs = stmt.executeQuery(countQuery);
            	
            	while ( rs.next() ) {
                   result += rs.getString("companyname");
                   result += "\n";
                }
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
		
		return result;
	}
}
