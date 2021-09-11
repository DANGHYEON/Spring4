<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>Login Page</h1>
	
	<div class="container-fluid">
	<form id="frm" class="col-md-4 mx-auto" action="login" method="post">
	
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">ID</label>
  			<input type="text" class="form-control" name="id" id="id" placeholder="id">
  			<div id="idResult"></div>
	</div>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">password</label>
  			<input type="password" class="form-control" name="pw" id="exampleFormControlInput1" placeholder="password">
	</div>
	
	
	<button id="btn" type="submit">로그인</button>
	</form>
	</div>

</body>
</html>