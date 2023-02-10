import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDaoDemo2 {

	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAO();
		
		Student2 s2 = new Student2();
		s2.rollNo = 15;
		s2.sName = " Archana";
	}

}

class StudentDAO2 {
	
	public Student2 getStudent(int rollNo) {
	
	try {
		String query = "select sName from studentRollNumber where rollNo= " + rollNo;
		Student2 s = new Student2();
		s.rollNo = rollNo;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens", "root", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String name = rs.getString(1);
		s.sName = name;
		st.close();
		con.close();
		return s;
	} catch (Exception e) {
		System.out.println(e);;
	}
	return null;
	}
}

class Student2 {
	int rollNo;
	String sName;
}
