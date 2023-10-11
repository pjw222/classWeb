package c231011;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserTest
 */
@WebServlet("/usertest")
public class UserTestServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTestServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			ConnectionMaker maker = new TomcatOracleConnectionMaker();
			
			UserDAO dao = new UserDAO(maker);
			
			UserBean user = new UserBean();
			user.setName("김무개");
			user.setUserId("kdss1");
			user.setPassword("12345");

			dao.add(user);

			System.out.println("추가성공");	
			UserBean createdUser = dao.get("kdss");
			System.out.println(createdUser.getId());
			System.out.println(createdUser.getName());
			System.out.println(createdUser.getUserId());
			System.out.println(createdUser.getPassword());
			String html = "<html>";
			html += "<html>";
			html += "<head>";
			html += "<meta charset='UTF-8' />";
			html += "<title>";
			html += "회원목록";
			html += "</title>";
			html += "가입순서 : "+createdUser.getId()+"<br />";
			html += "이름 : "+createdUser.getName()+"<br />";
			html += "회원 아이디 : "+createdUser.getUserId()+"<br />";
			html += "회원 비밀번호 : "+createdUser.getPassword()+"<br />";
			html += "</body>";
			html += "</html>";
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(html);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
