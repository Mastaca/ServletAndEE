import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDaoDemo2 {

	public static void main(String[] args) {

		StudentDAO2 dao = new StudentDAO2();

		Student2 s2 = new Student2();
		s2.rollNo = 18;
		s2.sName = "Ugapa";
		dao.connect();
		dao.addStudent(s2);
	}

}

class StudentDAO2 {

	Connection con = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}
	}

	public void connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens", "root", "1234"); // Connection																							// String
			System.out.println("A fost conectat");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Eroare conectare");
			e.printStackTrace();
		}
	}

	public Student2 getStudent(int rollNo) {

		try {
			String query = "select sName from studentRollNumber where rollNo= " + rollNo;
			Student2 s = new Student2();
			s.rollNo = rollNo;

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String name = rs.getString(1);
			
			s.sName = name;
			st.close();
			con.close();
			return s;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void addStudent(Student2 s) {
		String query = "insert into student values (?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, s.rollNo);
			pst.setString(2, s.sName);
			System.out.println("Inainte executeUpdate");
			pst.executeUpdate();
			System.out.println("Dupa executeUpdate");
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class Student2 {
	int rollNo;
	String sName;
}
