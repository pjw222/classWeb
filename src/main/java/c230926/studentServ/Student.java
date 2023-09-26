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
 * Servlet implementation class Student
 */
@WebServlet("/student")
public class Student extends HttpServlet {
	
	private static final long serialVersionUID = 1095918089297854350L;


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
		//		response.setContentType("text/html;charset=UTF-8");
		System.out.println("id : "+request.getParameter("id"));
		StudentDAO dao = new StudentDAO();
		List<StudentVO> list = dao.getList();
		StudentVO student = null;
		if(request.getParameter("id") != null) {
			student=dao.getStudent(Integer.parseInt(request.getParameter("id")));
		}
		//System.out.println(list.size());
		String html = "<html>";
		html += "<head>";
		html += "<meta charset='UTF-8' />";
		html += "<title>";
		html += "학생목록";
		html += "</title>";
		html += "</head>";
		html += "<body>";
		if(student==null) {
			
			html += "<form action='student' method='post' >";
			html += "<input type='text' name='student-id' placeholder='ID' />";
			html += "<input type='PASSWORD' name='student-pw' placeholder='PASSWORD' />";
			html += "<button>로그인</button>";
			html += "</form>";
			html += " ";
			html += " ";
			html += " ";
			html += "<a href='//localhost/classWeb/addmember' /><button>회원가입</button></a>";
			html += "</form>";
		}
		else
		{
			html += "<div>";
			html += student.getName() + "님 어서오세요.";
			html += "</div>";
			html += "<form action='student' method='post' >";
			html += "<a href='//localhost/classWeb/student' /><button>로그아웃</button></a>";
			html += "</form>";
		}
		html += "<ol>";
		for(int i=0; i <list.size(); ++i)
		{
			html += "<li>";
			html += list.get(i).getName() ;
			html += " ";
			html += list.get(i).getStudentId() ;
			html += " ";
			html += list.get(i).getStudentPw() ;
			html += "</li>";
		}
		html += "</ol>";
		html += "</body>";
		html += "</html>";	
//		System.out.println(html);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String studentId = request.getParameter("student-id");
		String studentPw = request.getParameter("student-pw");
//		int studentAge = Integer.parseInt(request.getParameter("age"));
//		String studentName = request.getParameter("name");
//		String studentGitAddress = request.getParameter("git_address");
		StudentDAO dao = new StudentDAO();
		StudentVO temp = dao.getStudent(studentId,studentPw);
//		StudentVO create = dao.getStudent(studentName, studentId, studentPw, studentAge, studentGitAddress);
		System.out.println(temp);
		if(temp != null)response.sendRedirect("student"+ "?id="+temp.getId());
		else response.sendRedirect("student");
//		response.sendRedirect("student"+"?id=" +"1");
//		response.getWriter().append("testing");
	}

}
