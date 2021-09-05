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

	<form class="col-md-5 mx-auto" action="./update" method="post">
		<input type="hidden" readonly="readonly" value="${update.num}" name="num">
		<div class="mb-3">
  			<label for="title" class="form-label">Title</label>
  			<input type="text" class="form-control" value="${update.title}" name="title" id="title" >
		</div>
		
		<div class="mb-3">
  			<label for="contents" class="form-label">contents</label>
  			<input type="text" class="form-control" value="${update.contents}" name="contents" id="contents" >
		</div>
		
		<div class="mb-3">
		<input readonly="readonly" value="${update.writer}" name="writer">
		</div>
		
		<div class="mb-3 ml-0">
			<button type="submit" class="btn btn-success">Update</button>
		</div>
		
		</form>
		</div>

</body>
</html>