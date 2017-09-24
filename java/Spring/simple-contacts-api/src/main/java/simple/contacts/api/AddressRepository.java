package simple.contacts.api;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AddressRepository {

    //  Database Properties
    private  Connection conn;
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://172.17.0.2:3306/simple-contact-manager";
    static final String USER = "root";
    static final String PASSWORD = "My-root-pw";
    
    
    public AddressRepository () {
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public long count() throws SQLException {

	Statement stmt = conn.createStatement();
	String query = "SELECT count(*) FROM address" ;
	
	ResultSet result = stmt.executeQuery(query);

	result.next();
	return result.getInt(1);
    }

    // public void delete(long id) throws SQLException {
    // 	//TODO
    // }

    // public void delete(Iterable<Address> entities) throws SQLException {
    // 	//TODO
    // }

    // public void deleteAll() throws SQLException {
    // 	//TODO
    // }

    // public boolean exists(long id) throws SQLException {
    // 	//TODO
    // 	return false;
    // }

    public Iterable<Address> findAll() throws SQLException {

	ArrayList<Address> addresses = new ArrayList<Address>();
	
	Statement stmt = conn.createStatement();
	String query = "SELECT * FROM address" ;
	ResultSet result = stmt.executeQuery(query);
	
	while(result.next()) {
	    Address address = new Address (
					   result.getInt("id"),
					   result.getString("street"),
					   result.getString("city"),
					   result.getString("postal_code"),
					   result.getString("country"));
	    addresses.add(address);
	}
	stmt.close();

	return addresses;
    }
    
    // public Iterable<Address> findAll(List<long> ids) throws SQLException {
    // 	//TODO
    // 	return null;
    // }

    public List<Address> findFiltered(Map<String,String> filters) throws SQLException {
	    return null;
    }
    
    public Address findOne(long id) throws SQLException {
        Address address = null;
	
	Statement stmt = conn.createStatement();
	String query = "SELECT * FROM address WHERE id=" + id;
	ResultSet result = stmt.executeQuery(query);
	
	while(result.next()) {
	    address = new Address (
				   result.getInt("id"),
				   result.getString("street"),
				   result.getString("city"),
				   result.getString("postal_code"),
				   result.getString("country"));
	}
	stmt.close();

	return address;
    }

    public void save(Iterable<Address> addresses) throws SQLException {
	//TODO
    }

    public void save(Address address) throws SQLException {
	//TODO
    }
    
    public void close() {
	try {
	    conn.close();
	} catch (SQLException se) {
	    se.printStackTrace();
	}
    }
}
