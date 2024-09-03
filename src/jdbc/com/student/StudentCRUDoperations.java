package jdbc.com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCRUDoperations {

	private static Connection connection = null;
	private static String insertquery = "insert into student(name,age,city,pincode) values(?,?,?,?)";
	private static String displayquery = "select * from student";
	private static String updatequery = "update student set age=?,city=? where id=?";
	private static String deletequery = "delete from student where id=?";
	int i;
	
	public int insertStudent(StudentPojo stu) throws SQLException {
		try {
			connection = DbConnection.getDbConnection();
			PreparedStatement psmt = connection.prepareStatement(insertquery);
//		  set the value of parameters
			psmt.setString(1, stu.getName());
			psmt.setInt(2, stu.getAge());
			psmt.setString(3, stu.getCity());
			psmt.setLong(4, stu.getPincode());
			i = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeDbConnection();
		}
		return i;
	}

	public void displayStudent() throws SQLException {
		try {
			connection = DbConnection.getDbConnection();
			PreparedStatement psmt = connection.prepareStatement(displayquery);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.println("id: " + rs.getInt("id") + " name: " + rs.getString("name") + " age: "
						+ rs.getInt("age") + " city: " + rs.getString("city") + " pincode: " + rs.getLong("pincode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeDbConnection();
		}
	}

	public int updateStudent(int id, int age, String city) throws SQLException {
		try {
			connection = DbConnection.getDbConnection();
			PreparedStatement psmt = connection.prepareStatement(updatequery);
			psmt.setInt(3, id);
			psmt.setInt(1, age);
			psmt.setString(2, city);
			i = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeDbConnection();
		}
		return i;
	}

	public int deleteStudent(int userId) throws SQLException {
		try {
			connection = DbConnection.getDbConnection();
			PreparedStatement psmt = connection.prepareStatement(deletequery);
			psmt.setInt(1, userId);
			i = psmt.executeUpdate();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeDbConnection();
		}
		return i;
	}
}
