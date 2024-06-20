<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
REST Servlet Test<hr>
<div id="resultDIV"></div><br><br>

REST Test1<hr>
1. String -> String<br>
<input type="text" id="ename" name="ename">
<input type="button" id="ajax_test" value="Basic AJAX"><hr>

REST Test2<hr>
2. String -> String<br>
<input type="text" id="ename2" name="ename2">
<input type="button" id="string_string" value="String - String"><hr>

REST Test3<hr>
3. JSON -> String<br>
<input type="text" id="ename3" name="ename3">
<input type="button" id="json_string" value="JSON -> String"><hr>

REST Test4<hr>
4. String -> JSON<br>
<input type="text" id="ename4" name="ename4">
<input type="button" id="string_json" value="JSON -> String"><hr>

REST Test5<hr>
5. JSON -> JSON<br>
<input type="text" id="ename5" name="ename5">
<input type="button" id="json_json" value="JSON -> JSON"><hr>


<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
$(function(){
	// 공통 : 테이블 그리는 함수.
	function makeTable(myval){			
			var htmlStr = "<table border=1 width=50%><tr><th>제목</th><th>글쓴이</th></tr>";
			$.map( myval, function( MYval, MYidx ) {
				htmlStr += "<tr><td>" +MYval["title"] + "</td><td>"+MYval["regid"] +"</td></tr>"
			});
			htmlStr += "</table>";
			$("#resultDIV").empty();
			$("#resultDIV").html("1. <b>"+htmlStr+"</b>");
			console.log("200 ok");
		 }
	$("#ajax_test").click(  function(){
		var ename = $("#ename").val();
		
		$.ajax({
			method      : "GET",
	        url         : "${pageContext.request.contextPath}/RestServletTest?pagecode=B000",
	        data 		: "ename="+ename,
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ 
	  										console.log("성공:" + myval);
	  										console.log("200 ok");
	  										$("#resultDIV").html("<b>"+myval+"</b>");
	  									 }
		});
	});	


	$("#string_string").click(  function(){
		var ename2 = $("#ename2").val();
		
		$.ajax({
			method      : "GET",
	        url         : "${pageContext.request.contextPath}/RestServletTest?pagecode=B001",
	        data 		: "ename="+ename2,
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ 
											console.log("변환 전 : " + myval);
											myval = JSON.parse(myval);
											console.log("변환 후 :" + myval);
	  										makeTable(myval);
	  									 }
		});
	});

	$("#json_string").click(  function(){
		var objData = {"title":"제목입니다","contents":"내용입니다"};
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/RestServletTest?pagecode=B002",
	        data		: JSON.stringify(objData),
	        contentType : "application/json; charset=UTF-8",
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ 
											console.log("변환 전 : " + myval);
											myval = JSON.parse(myval);
											console.log("변환 후 :" + myval);
	  										makeTable(myval);
	  									 }
		});
	});
	
	$("#string_json").click(  function(){
		var ename4=$("ename4").val();
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/RestServletTest?pagecode=B003",
	        data 		: "ename="+ename4,
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ 
	  										console.log(myval);
											makeTable(myval);
	  									 }
		});
	});
	
	$("#json_json").click(  function(){
		var objData = {"title":"제목입니다","contents":"내용입니다"};
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/RestServletTest?pagecode=B004",
	        data 		: JSON.stringify(objData),
	        contentType : "application/json; charset=UTF-8",
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ 
	  										console.log(myval);
											makeTable(myval);
	  									 }
		});
	});
	
})

</script>

</body>
</html>