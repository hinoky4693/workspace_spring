<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript"></script>
<script>
//$(document).ready(function() {
	function formSubmit() {
		document.getElementById("myForm").submit();
	}
//});
</script>
</head>

<body ng-controller="moniteringCtrl" class="pad">

<form action="/member/logout" method="post" id="myForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="submit" value="로그아웃">
</form>

${sess_username} 님 반갑습니다.

</body>
</html>