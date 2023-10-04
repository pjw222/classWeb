package c2301004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServletContext
 */
@WebServlet("/GetServletContext")
public class GetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServletContext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		ServletContext context = getServletContext();
		
		List testArr = (ArrayList) context.getAttribute("testArr");
		int temp = (Integer) testArr.get(1); // 변수에 넣을때는 만약 정수형이면 인티저로 변환 문자열이라면 스트링으로 변환해서 넣어줘야함
		
		InputStream is = context.getResourceAsStream("/WEB-INF/bin/test.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		InputStreamReader ir = new InputStreamReader(is);
		StringTokenizer st =	new StringTokenizer(br.readLine(), ",");  //","를 기준으로 여러개 끊어서 받아올수있음
		
		response.getWriter().print(context.getAttribute("test")+ "<br />");;
		response.getWriter().print(testArr.get(0) +"<br />");
		response.getWriter().print(testArr.get(1) +"<br />");
		for(int i= 0; i<5; i++)
		{
			response.getWriter().print(temp+(i+1)+" "+((i+1)+"번째")+"<br />");
		}
		response.getWriter().print(context.getInitParameter("text_xml")+"<br />");
		response.getWriter().print(is+"<br />");
		response.getWriter().print(br.readLine()+"<br />");
		response.getWriter().print(ir.read()+"<br />");
		response.getWriter().print(st.nextToken() + "<br />");
		response.getWriter().print(st.nextToken() + "<br />");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
