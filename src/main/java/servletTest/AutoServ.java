package servletTest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet("/auto")
public class AutoServ extends HttpServlet{

	@Override
	public void init() throws ServletException
	{
		System.out.println("요청 컨테이너");
	}
	@Override
	public void destroy()
	{
		System.out.println("컨테이너 종료 삭제");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		System.out.println("Get 받음");
	}

}
