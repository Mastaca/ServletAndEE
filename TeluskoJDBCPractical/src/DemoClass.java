import java.sql.*;
/*
 * Steps to use JDBC:
 * 1. Import the package ("java.sql.*")
 * 2. Load and register the Driver (com.mysql.jdbc.Driver)
 * 		1. Load
 * 			1. Download mysql-connector
 * 			2. Load into the IDE
 * 		2. Register
 * 			1. Class.forName("com.mysql.cj.jdbc.Driver");
 * 3. Estabilish the connection
 * 		1. Instantiate Connection Interface
 * 4. Create the statement
 * 		1. Statement
 * 		2. PreparedStatement
 * 		3. CallableStatement
 * 5. Execute the Querry
 * 6. Process result
 * 7. Close 
*/

class Pqr {
	static {
		System.out.println("In static");
	}
	
	{
		System.out.println("In instance");
	}
}

public class DemoClass {
	
	public static void main(String[] args) throws Exception {
		
//		Class.forName("Pqr").newInstance();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		
//		Connection con = Dr
		
	}
	
	

	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * String url = "jdbc:mysql://localhost:3306/aliens";// mysql tuorial Telusko
	 * String userName = "root"; String userPassword = "1234";
	 * 
	 * int newUserId = 6; String newUserName = "Dipali";
	 * 
	 * // String query = "insert into student values('" + newUserId + "','" +
	 * newUserName + "')"; String query = "insert into student values(?,?);";
	 * 
	 * Class.forName("com.mysql.cj.jdbc.Driver"); // class forName Telusko
	 * Connection con = DriverManager.getConnection(url, userName, userPassword);
	 * 
	 * // Statement st = con.createStatement(); PreparedStatement st =
	 * con.prepareStatement(query); st.setInt(1, newUserId); st.setString(2,
	 * newUserName);
	 * 
	 * // ResultSet rs = st.executeQuery(query); // DDl, DML, DQL int count =
	 * st.executeUpdate();
	 * 
	 * 
	 * while(rs.next()) { String userData = rs.getInt(1)+ " : " + rs.getString(2);
	 * System.out.println(userData); }
	 * 
	 * 
	 * System.out.println(count + " row/s affected");
	 * 
	 * st.close(); con.close(); }
	 */

}
