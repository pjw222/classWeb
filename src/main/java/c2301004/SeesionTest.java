package c2301004;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class SeesionTest
 */
@WebServlet("/SeesionTest")
public class SeesionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeesionTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// 세션은 로그인을 했을때 그사람이 로그인을 했다는걸 증명하기 위한 임시 데이터 만료기간을 넣어줄수있다.
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		// D9D377CF4CBF398BB3B3F0B7BF5CCEB0 //16진수 32글자 암호화 방법중 하나를 사용중
//		session.invalidate(); // 세션을 즉시 삭제한다.
		
		response.getWriter().println((session.getId()) + "<br />"); // id 출력하기
		response.getWriter().println((session.getCreationTime()) + "<br />"); // 만든시간 출력하기
		response.getWriter().println((session.getMaxInactiveInterval()) + "<br />"); //만료시간 출력하기
		response.getWriter().println((session.getLastAccessedTime()) + "<br />"); // 마지막으로 요청보낸시간 출력
		response.getWriter().println((session.getAttribute("test-session")) + "<br />");
		
		session.setMaxInactiveInterval(10);
		session.setAttribute("test-session", "테스트");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
