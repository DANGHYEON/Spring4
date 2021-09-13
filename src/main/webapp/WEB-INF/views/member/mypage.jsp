<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>My page</h1>
	<h1>ID : ${member.id}</h1>
	<h1>Email : ${member.email}</h1>
	
	<form action="./out" id="frm">
	<input type="hidden" name="id" value="${member.id}">
	<button id="btn" type="button">회원탈퇴</button>
	</form>
	
	<a href="./update">수정</a>
	
	
	<script type="text/javascript" src="../resources/js/mypage.js"></script>
</body>
</html>