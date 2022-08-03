<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="modifySet" method="post" enctype="multipart/form-data">
<img src="download?file=${dto.imgName }" width="100px" height="100px"> <br>
	<input type="text" value="${dto.id }" name="id" readonly> <br>
	<input type="text" value="${dto.name }" name="name"> <br>
	<!-- 파일을 바꾸면 기존의 파일은 삭제하기 -->
	<input type="file" name="img" id="img"> <br>
	
	<input type="submit" value="수정">
</form>



</body>
</html>