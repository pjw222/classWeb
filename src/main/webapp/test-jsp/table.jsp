<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
    pageEncoding="UTF-8"%>
<%
	//List list = (ArrayList) request.getAttribute("list");
	String name1 = (String) request.getAttribute("name");
	Integer num1 = (Integer) request.getAttribute("num");
	String hobby1 = (String) request.getAttribute("hobby");
%>    
    
<table>
	<tr>
		<th>이름</th>
		<th>번호</th>
		<th>취미</th>	
	</tr>
	<%--<%
		for(int i = 0; i<list.size(); ++i){
	
	<tr>
		<td><%=list.get(i).name %></td>
	</tr>
	<%
		}
	%>
	--%>

	<tr>
		<td><%=name1 %></td>
		<td><center><%=num1 %></center></td>
		<td><%=hobby1 %></td>
	</tr>
	
</table>