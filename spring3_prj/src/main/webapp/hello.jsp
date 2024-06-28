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
<c:set var="myvar" value="3" />
${myvar}
hello 한글테스트

<table border="1" width="100%">
<c:forEach items="${KEY_USERLIST}" var="uvo">
<tr>	
	<td>${uvo.userId}</td>
</tr>
</c:forEach>
</table>
<form action="/user_insert" method="post">
아이디:<input type="text" name="userId"><br>
패스워드:<input type="text" name="userPw"><br>
<input type="submit" value="가입"><br>
</form>
<form action="/user_update" method="get">
아이디:<input type="text" name="userId"><br>
패스워드:<input type="text" name="userPw"><br>
<input type="submit" value="PW변경"><br>
</form>

 <c:if test="${not empty message}">
        <script type="text/javascript">
            alert("${message}");
        </script>
    </c:if>
<form action="/user_one" method="post">
아이디:<input type="text" name="userId"><br>
패스워드:<input type="text" name="userPw"><br>
<input type="submit" value="로그인"><br>
</form>
</body>
</html>