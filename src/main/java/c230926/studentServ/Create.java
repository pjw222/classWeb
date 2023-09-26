package c230926.studentServ;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c230926.student.StudentDAO;
import c230926.student.StudentVO;

/**
 * Servlet implementation class Create
 */
@WebServlet("/addmember")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDAO dao = new StudentDAO();
		List<StudentVO> list = dao.getList();
		StudentVO student = null;

		String html = "<html>";
		html += "<head>";
		html += "<meta charset='UTF-8' />";
		html += "<title>";
		html += "학생목록";
		html += "</title>";
		html += "</head>";
		html += "<body>";

			html += "<form action='addmember' method='post' >";
			html += "<input type='text' name='id' placeholder='ID' />";
			html += "<input type='text' name='name' placeholder='NAME' />";
			html += "<input type='text' name='student-id' placeholder='ID' />";
			html += "<input type='PASSWORD' name='student-pw' placeholder='PASSWORD' />";
			html += "<input type='text' name='age' placeholder='AGE' />";
			html += "<input type='text' name='git-addeess' placeholder='ADDESS' />";
			html += "<button>회원가입</button>";
			html += "</form>";
	
		html += "</body>";
		html += "</html>";	
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String studentId = request.getParameter("student-id");
		String studentPw = request.getParameter("student-pw");
		int studentAge = Integer.parseInt(request.getParameter("age"));
		String studentName = request.getParameter("name");
		String studentGitAddress = request.getParameter("git-address");
		StudentDAO dao = new StudentDAO();
		dao.setStudent(id, studentName, studentId, studentPw, studentAge, studentGitAddress);
	}

}
