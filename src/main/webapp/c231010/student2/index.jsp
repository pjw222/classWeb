
<%@page import="c231006.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- webapp/c231010/student2/index.jsp --%>
<%--
	List students = (ArrayList) request.getAttribute("students");
--%>
<%-- <jsp:useBean id="students" class="java.util.ArrayList" scope="page"/>
<jsp:useBean id="studentsMap" class="java.util.HashMap" scope="page"/>--%>
    
<!DOCTYPE html>
<html>	
<head>
<meta charset="UTF-8">
<title>student2</title>
</head>
<body>
	${studentsMap.students[0].name }<br />
	${studentsMap.students[1].name }<br />
	${sessionScope.studentsMap2.students2[0].name }<br />
	page => request => session => application(Context, ServletContext)<br />
	<%=request.getContextPath() %><br />
	${pageContext.request.contextPath }<br />
	${requestScope.error }<br />
	<%-- pageScope, requestScope, sessionScope, applicationScope --%>
	<% for(int i=0; i<2; ++i){ %>
	 	<%=i %><br />
	<% }%>
</body>
</html>