<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
img = opener.document.getElementById("pic");
img.src="${pageContext.request.contextPath }/image/member/picture/${filename}";
//업로드된 이미지 회원가입 화면에 출력
opener.document.f.picture.value="${filename }"
self.close();
</script>   
</body>
</html>