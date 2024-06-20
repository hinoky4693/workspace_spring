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

<input type="text" name="search_str" id ="search_str">
<input type="button" id="searchBtn" value="검색">
<div id="searchResDiv"></div>

<br><br><br><br><br>
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



<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script>
	    $(function() {
	    	// 검색어 입력하면 관련 내용 자동 완성 :: REST
			$("#search_str").on('input', function(){
				
				if ($("#search_str").val() != "") {
					$.ajax({
						method      : "POST",
				        url         : "${pageContext.request.contextPath}/board_search",
				        data 		: "search_str="+$("#search_str").val(),
				  		error 	    : function(myval){ console.log("에러:" + myval);   },
				  		success     : function(myval){
														console.log(myval);
														var htmlStr = "<ul>";
				  										$.map( myval, function( MYval, MYidx ) {
				  											htmlStr += "<li>"+MYval.title+"</li>";
				  										});
				  										htmlStr += "</ul>";
														
														$("#searchResDiv").empty();
														$("#searchResDiv").html(htmlStr);
				  									 }
					
				});
			} else {
					$("#searchResDiv").empty();
				   }
			});		
			
	    });
    
    </script>
    
</body>
</html>