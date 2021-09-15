
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>${board} Select Page</h1>
	
	<div>
	<h2>글번호 : ${dto.num}</h2>
	<h2>글제목 : ${dto.title}</h2>
	<h2>글내용 : ${dto.contents}</h2>
	<h2>작성자 : ${dto.writer}</h2>
	<h2>작성일 : ${dto.regDate}</h2>
	<h2>조회수 : ${dto.hits}</h2>
	</div>
	
	<c:forEach items="${fileList}" var="f">
		<div>
		<img alt="" src="../resources/upload/${board}/${f.fileName}">
		</div>
	</c:forEach>
	

	
	<div>
	<c:if test="${not empty member and member.id eq dto.writer}">
	<a href="./delete?num=${dto.num}" class="btn btn-danger" >Delete</a>
	<a href="./update?num=${dto.num}" class="btn btn-success">Update</a>
	</c:if>
	
	<c:if test="${board eq 'qna'}">
		<a href="./reply?num=${dto.num}">Reply</a>
	</c:if>
	</div>
	
</body>
</html>