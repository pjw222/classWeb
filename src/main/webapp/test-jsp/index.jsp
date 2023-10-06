<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="javax.servlet.RequestDispatcher"
	errorPage="../c231006/exception.jsp"
    pageEncoding="UTF-8"%>
    
<%!
// 선언문
	String hobby = "음악듣기";
	public String getHobby(){return hobby;}
%>

<%
	// 스크립트릿
	String name = "송성민";
	getHobby();
	System.out.println(hobby);
	System.out.println(getHobby());
	String age = request.getParameter("age");
	Cookie cookie = new Cookie("test", "testing");
	response.addCookie(cookie);
	application.setAttribute("servletContext", "입니다.");
	session.setAttribute("session", "입니다~.");
	request.setAttribute("name", "김남균");
	request.setAttribute("num", 3);
	request.setAttribute("hobby", "음악듣기");
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기가 진자 JSP 테스트</title>
</head>
<body>
	<%@ include file="./table.jsp" %>
	<%=name+"입니다." %><br />
	<%=Integer.parseInt(age)+10 %><br />
	<%=session.getAttribute("session") %>
	<%-- 표현식 --%>
	<%! String test="test"; %><br />
	<%-- 되기는 하는데 컨벤션상으로 맞지않음 --%>
	<%
		for(int i=0; i < 10; i++){
			
	%>
		<div><%=i %></div>
	<%
	}
	%>
	<%--
	RequestDispatcher dispatch = request.getRequestDispatcher("./table.jsp");
	dispatch.forward(request, response);
	--%>
</body>
</html>