package c230927.redirectTest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServ
 */
@WebServlet("/from")
public class FirstServ extends HttpServlet {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.sendRedirect("to");
//		response.addHeader("Refresh", "1; url=to");
//		response.getWriter().append("<script>location.href='to'</script>");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("key", "값");
		RequestDispatcher dispatch = request.getRequestDispatcher("to");
		dispatch.forward(request, response); 
		//서버쪽에서 돌리는 거기때문에 모든 브라우저가 동일한 속도로 뜨는데
		//단점은 서버쪽에 부담이 커진다. 보안상의 이유로 사용 비즈니스 로직 사용자에게 보여주지않고 내부적으로 돌림
		// 비투비(비즈니스투비즈니스) 회사에서 회사로 비투씨(비즈니스투커스터머) 회사에서 고객으로
//		Integer.parseInt("123");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
