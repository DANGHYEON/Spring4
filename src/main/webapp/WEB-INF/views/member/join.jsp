<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>Join Page</h1>
	<div class="container-fluid">
	<form class="col-md-4 mx-auto">
	
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">ID</label>
  			<input type="text" class="form-control" id="exampleFormControlInput1" placeholder="id">
	</div>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">password</label>
  			<input type="password" class="form-control" id="exampleFormControlInput1" placeholder="password">
	</div>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">confirm password</label>
  			<input type="password" class="form-control" id="exampleFormControlInput1" placeholder="confirm password">
	</div>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">Name</label>
  			<input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Name">
	</div>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">Phone</label>
  			<input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Phone-number">
	</div>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">email</label>
  			<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="xxxxx@naver.com">
	</div>
	
	<button type="submit">회원가입</button>
	</form>
	</div>

	
	

</body>
</html>