<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 파일은 무조건 post로 넘겨야 함 < multipart/form-data> 파일이나 이미지를 서버로 전송할때 사용(post메소드만 가능) -->
<form action="upload" method="post" enctype="multipart/form-data">
	<input type="text" name="id"> <br>
	<input type="text" name="name"> <br>
	<input type="file" name="f"> <br>
	<input type="submit" value="전송">
</form>
<a href="views">파일보기</a>
</body>
</html>