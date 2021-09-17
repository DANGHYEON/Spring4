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
	<form id="frm" class="col-md-4 mx-auto" action="join" method="post" enctype="multipart/form-data">
	
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">ID</label>
  			<input type="text" class="form-control es" name="id" id="id" placeholder="id">
  			<button id="idCheck" type="button">ID중복체크</button>
  			<div id="idResult"></div>
	</div>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">password</label>
  			<input type="password" class="form-control es pw"  name="pw" id="exampleFormControlInput1" placeholder="password">
	</div>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">confirm password</label>
  			<input type="password" class="form-control es pw" id="exampleFormControlInput1" placeholder="confirm password">
	</div>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">Name</label>
  			<input type="text" class="form-control es" name="name" id="exampleFormControlInput1" placeholder="Name">
	</div>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">Phone</label>
  			<input type="tel" class="form-control es" name="phone" id="exampleFormControlInput1" placeholder="Phone-number">
	</div>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">email</label>
  			<input type="email" class="form-control es" name="email" id="exampleFormControlInput1" placeholder="xxxxx@naver.com">
	</div>
	
	
	
 	 <div class="mb-3" id="f">
   		 <label for="photo" class="form-label">Photo</label>
    	<input type="file" class="form-control put" id="photo" name="photo" >
  	</div>

	
	
	<button id="btn" type="submit">회원가입</button>
	</form>
	</div>
	

<script type="text/javascript" src="../resources/js/join.js"></script>

</body>
</html>