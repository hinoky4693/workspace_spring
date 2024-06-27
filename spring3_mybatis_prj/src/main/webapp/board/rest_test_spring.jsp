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
REST Spring Test<hr>
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
<input type="button" id="string_json" value="String -> JSON"><hr>

REST Test5<hr>
5. JSON -> JSON<br>
<input type="text" id="ename5" name="ename5">
<input type="button" id="json_json" value="JSON -> JSON"><hr>

REST Test6<hr>
6. 일반적형태(String -> JSON) <br>
<form id="regForm">
<input type="text" id="title" name="title" value="title">
<input type="text" id="regid" name="regid" value="regid">
<input type="button" id="writeButton" value="글쓰기"><hr>
</form>

REST Test7<hr>
7. RESTCONTROLLER (String -> String) <br>
<input type="text" id="ename6" name="ename6">
<input type="button" id="rest_string_string" value="RestController"><hr>

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
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/ctl_str_str",
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
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/ctl_str_str2",
	        data 		: "ename="+ename2,
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){
	  										console.log("1. Spring 응답 : " + myval);
	  									 }
		});
	});

	$("#json_string").click(  function(){
		var objData = {"title":"제목입니다","contents":"내용입니다"};
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/ctl_json_str",
	        data		: JSON.stringify(objData),
	        contentType : "application/json; charset=UTF-8",
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ 
	  										console.log("2. Spring 응답 : " + myval);
	  									 }
		});
	});
	
	$("#string_json").click(  function(){
		var ename4=$("#ename4").val();
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/ctl_str_json",
	        data 		: "ename="+ename4,
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval, textStatus, xhr){ 
	  								if (xhr.status == 200){
										console.log("3. Spring 응답 : " + myval["message"]);		  									
	  								}
						 }
		});
	});
	
	$("#json_json").click(  function(){
		var objData = {"title":"제목입니다","contents":"내용입니다"};
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/ctl_json_json",
	        data 		: JSON.stringify(objData),
	        contentType : "application/json; charset=UTF-8",
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ 
	  										console.log("4. Spring 응답 : " + myval["message"]);		
	  									 }
		});
	});
	
	$("#writeButton").click(  function(){
		var sendFormData = $("#regForm").serialize(); // title=aaaa&regid=kim
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/ctl_normal",
	        data 		: sendFormData,
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ 
	  										console.log(myval);
	  										makeTable(myval);
	  									 }
		});
	});
	
	$("#rest_string_string").click(  function(){
		var ename6 = $("#ename6").val();
		
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/restctl_str_str",
	        data 		: "ename="+ename6,
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){
	  										console.log("0. RestController 응답 : " + myval);
	  									 }
		});
	});
	
})

</script>

</body>
</html>