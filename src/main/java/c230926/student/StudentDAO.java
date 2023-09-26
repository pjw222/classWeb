package c230926.student;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;  
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StudentDAO {
	private Connection con;
	
	public List<StudentVO> getList(){
		List<StudentVO> list = new ArrayList<StudentVO>();

		try {
			connect();
			String query = "select * from student2";
			Statement stmt = con.createStatement();
			ResultSet rs =stmt.executeQuery(query);
			while(rs.next()) {
				StudentVO temp = new StudentVO(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("student_id"),
						rs.getString("student_pw"),
						rs.getInt("age"),
						rs.getString("git_address")
						);
				list.add(temp);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public StudentVO getStudent(String studentId,String studentPw)
	{
		StudentVO temp =null;
		try {

			connect();
			String query = "select * from student2 where student_id=? and student_pw=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, studentId);
			pstmt.setString(2, studentPw);
			ResultSet rs =pstmt.executeQuery();

			if(rs.next()) {
				temp = new StudentVO(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("student_id"),
						rs.getString("student_pw"),
						rs.getInt("age"),
						rs.getString("git_address")
						);

			}
			rs.close();
			pstmt.close();
			con.close();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		return temp;
	}
	public StudentVO getStudent(int id)
	{
		StudentVO temp =null;
		try {

			connect();
			String query = "select * from student2 where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs =pstmt.executeQuery();

			if(rs.next()) {
				temp = new StudentVO(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("student_id"),
						rs.getString("student_pw"),
						rs.getInt("age"),
						rs.getString("git_address")
						);

			}
			rs.close();
			pstmt.close();
			con.close();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		return temp;
	}
	public void setStudent(int id,String name, String studentId, String studentPw, int age, String gitAddress)
	{
		
		try {
			connect();
			String insertQuery = "insert into student2"
					+"(id, name, student_id, student_pw, age, git_address)"
					+"values (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1,  id);
			pstmt.setString(2, name);
			pstmt.setString(3, studentId);
			pstmt.setString(4, studentPw);
			pstmt.setInt(5, age);
			pstmt.setString(6, gitAddress);
			pstmt.executeUpdate();

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	private void connect() throws Exception {
		/*
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/xe",
				"java",
				"qwer"
				);
		 */
		Context ctx = new InitialContext();
		// DriverManager => DM
		// initialize => 초기화
		Context envContext = (Context) ctx.lookup("java:/comp/env");
		DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		con = dataFactory.getConnection();
	}
}
