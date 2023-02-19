import java.sql.*;

public class JdbcDaoDemo {

	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAO();
		Student s1 = dao.getStudent(12);
		
		System.out.println(s1.sName);

	}

}

class StudentDAO {
	
	
	public Student getStudent(int rollNo) {
	
	try {
		String query = "select sName from studentRollNumber where rollNo= " + rollNo;
		Student s = new Student();
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

	public void addStudent(Student s) {
		
		String query = "insert into student values(?,?)";
		
		
	}
}

class Student {
	int rollNo;
	String sName;
}
