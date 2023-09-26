package c230926.board;

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


public class BoardDAO {
	private Connection con;

	public List<BoardVO> getList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			connect();
			String query = "select * from board";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				BoardVO temp = new BoardVO(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("board_name"),
						rs.getString("content")
						);
				list.add(temp);
			}
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public void setBoard(String name, String boardName, String content)
	{
		try {
			connect();
			String insertQuery = "insert into board"
					+"(name, board_name, content)"
					+"values (?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, name);
			pstmt.setString(2, boardName);
			pstmt.setString(3, content);		
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public BoardVO getBoard(int id) {
		BoardVO temp = null;
		try {
			connect();

			String query = "select * from board where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
			{
				temp = new BoardVO(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("board_name"),
						rs.getString("content")
						);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;	
	}
	public void update(
			int id,
			String name,
			String boardName,
			String content
			
			) 
	{
		try {
			connect();

			String insertQuery = "update board set name=? and board_name=? and content=? where id=? ";
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, boardName);
			pstmt.setString(4, content);
			
			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		try {
			connect();
			
			String insertQuery = "delete from board where id=?";
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void connect() throws Exception {
		
		Context ctx = new InitialContext();

		Context envContext = (Context) ctx.lookup("java:/comp/env");
		DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		con = dataFactory.getConnection();
	}
}
