<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="false"
	errorPage="../c231006/exception.jsp"
    pageEncoding="UTF-8"%>
 <!--
 	위와 같은 것들을 디렉티브 태그라고 얘기한다. HTML상의 주석
  -->
 <%--
 	JSP에서의 주석
 	디렉티브 태그
 		페이지 디렉티브 태그
 			자바에서 사용하는 페이지를 설정하는 정보를 갖고있다.
 			language = JSP에서 사용하는 언어
 			contentType =페이지 출력 형식
 			session = 세션 사용 여부, true
 			pageEncoding = 페이지에서 사용하는 언어 형식
 			import = 다른 패키지에서 클래스 등을 가져옴
 			errorPage, is ErrorPage << 예외처리할때 
 		인클루드 디렉티브 태그
 			바디부분에서 <% 자바 %> 씀
 		태그라이브 디렉티브 태그
 --%>    
    
<%
	String str = "Java를 입력했어요";
	System.out.println(str);
%>

<html>
<head>
<meta charset="UTF-8">
<title>JSP 테스트</title>
</head>
<body>
	여기 입력시 페이지에 출력됨	
</body>
</html>