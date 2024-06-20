<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = 5 width=50% height=40%>
	<tr>
		<th scope="col">seq</th>
		<th scope="col">title</th>
		<th scope="col">contents</th>
		<th scope="col">regid</th>
		<th scope="col">regdate</th>
	</tr>
<c:forEach items="${KEY_BOARDLIST}" var="bvo">
	<tr>
		<td><a href="${pageContext.request.contextPath}/board_detail?seq=${bvo.seq}">${bvo.seq}</a></td>
		<td>${bvo.title}</td>
		<td>${bvo.contents}</td>
		<td>${bvo.regid}</td>
		<td>${bvo.regdate}</td>
	</tr> 
</c:forEach>
</table>

</body>
</html>