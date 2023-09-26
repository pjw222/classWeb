package c230926.boardServ;

import java.io.IOException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c230926.board.BoardDAO;
import c230926.board.BoardVO;

/**
 * Servlet implementation class NewContent
 */
@WebServlet("/textcontent")
public class TextContent extends HttpServlet {
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
		BoardDAO dao = new BoardDAO();
		
		BoardVO board = dao.getBoard(Integer.parseInt(request.getParameter("id")));
		
		String html = "<html>";
		html += "<head>";
		html += "<meta charset='UTF-8' />";
		html += "<title>";
		html += "게시판";
		html += "</title>";
		html += "</head>";
		html += "<body>";
		html += "<form action='newcontent' method='post' >";
		html += "<input type='text' name='name' placeholder='"+board.getName()+"' />";
		html += "<br/>";
		html += "<input type='text' name='board-name' placeholder='"+board.getBoardName()+"' />";
		html += "<br/>";
		html += "<input type='text' name='content' placeholder='"+board.getContent()+"' />";
		html += "<br/>";
		html += "<a href='//localhost/classWeb/board' /><button>글수정하기</button></a>";
		html += "</form>";
		html += "<ol>";
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
		String name = request.getParameter("name");
		String boardName = request.getParameter("board-name");
		String content = request.getParameter("content");
		BoardDAO dao = new BoardDAO();
		dao.update(Integer.parseInt(request.getParameter("id")), name, boardName, content);
		response.sendRedirect("./board");
	}

}
