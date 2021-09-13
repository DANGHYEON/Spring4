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
	<h1>Update Page</h1>
	<div class="container-fluid">
	<form id="frm" class="col-md-4 mx-auto" action="update" method="post">
	
		
	
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">password</label>
  			<input type="password" class="form-control es pw"  name="pw" value="${member.pw}" id="exampleFormControlInput1" placeholder="password">
	</div>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">confirm password</label>
  			<input type="password" class="form-control es pw" id="exampleFormControlInput1" placeholder="confirm password">
	</div>
	
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">Phone</label>
  			<input type="tel" class="form-control es" name="phone" value="${member.phone}" id="exampleFormControlInput1" placeholder="Phone-number">
	</div>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">email</label>
  			<input type="email" class="form-control es" name="email" value="${member.email}" id="exampleFormControlInput1" placeholder="xxxxx@naver.com">
	</div>
	
	<button id="btn" type="submit">Update</button>
	</form>
	</div>

	
	

</body>
</html>