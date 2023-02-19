package serv.testPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDataBase {
	
	static Connection con = null;
	static PreparedStatement pst = null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error driver registering");
			e.printStackTrace();
		}
	}
	
	
	
	static void signupUser(String firstName, String lastName,String userName, String userPassword) {	
		
		saveUserInfo(firstName, lastName, userName, userPassword);
//		saveUserCredentials(firstName, userName, userPassword);		
	}
	
	static void saveUserInfo (String firstName, String lastName, String userName, String userPassword) {
		String query = "insert into user_list (first_name, last_name, userName, password) values (?, ?, ?, ?)";
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing_webpage", "root", "1234");

			pst = con.prepareStatement(query);
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, userName);
			pst.setString(4, userPassword);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("saveUserInfo error");
			e.printStackTrace();
		}
	}
	
	static boolean loginUser(String userName, String userPassword) {
		boolean validLogin = false;
		try {
			int userId = 0;
			String query = "select userId from user_list where userName = '" + userName + "' and password = '" + userPassword + "'";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing_webpage", "root", "1234");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			try {
				rs.next();
				userId = Integer.parseInt(rs.getString(1));
				validLogin = true;
			} catch (SQLException e) {
				System.out.println("SQL Exception in userLogin");
				System.out.println(e);
			} catch (Exception e) {
				System.out.println("exception in userLogin");
				System.out.println(e);
			}
			
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("loginUser error");
			System.out.println(e);
		}		
		return validLogin;		
	}

	static boolean verifyUsername(String username) {
		boolean verifyIfExists = false;
		try {
			String query = "select userName from user_list where userName = '" + username + "'";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing_webpage", "root", "1234");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			try {
				if(!rs.next()) {
					verifyIfExists = true;
				}
			} catch (SQLException e) {
				System.out.println("SQL Exception in verifyUsername");
				System.out.println(e);
			} catch (Exception e) {
				System.out.println("exception in verifyUsername");
				System.out.println(e);
			}			
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("verifyUsername error");
			System.out.println(e);
		}		
		return verifyIfExists;
	}
	
//	static void saveUserCredentials(String firstName, String userName, String userPassword) {
//		int userId = getId(firstName);
//		String query = "insert into user_list (userName, password) values (?,?,?)";
//		
//		try {
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing_webpage", "root", "1234");
//				
//			pst = con.prepareStatement(query);
//			pst.setString(1, userName);
//			pst.setString(2, userPassword);
//			pst.setInt(3, userId);
//			pst.executeUpdate();
//			pst.close();
//			con.close();
//		} catch (SQLException e) {
//			System.out.println("saveUserCredentials error");
//			e.printStackTrace();
//		}
//	}
//	
//	
//	static int getId(String firstName) {
//		int userId = 0;
//		try {
//			String query = "select userId from user_list where first_name = '" + firstName + "'";
//
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(query);
//			rs.next();
//			userId = Integer.parseInt(rs.getString(1));
//			st.close();
//			con.close();
//			return userId;
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
//		return userId;
//	}

	
	

}
