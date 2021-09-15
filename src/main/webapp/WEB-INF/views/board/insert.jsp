<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
<style type="text/css">
	#d1 {
		width: 300px;
		height: 300px;
		background-color: blue;
	}
</style>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
<h1>${board} Insert Page</h1>

<div class="container-fluid">
		<form class="col-md-5 mx-auto" action="./insert" method="post" enctype="multipart/form-data">
			<div class="mb-3">
  			<label for="title" class="form-label">Title</label>
  				<input type="text" class="form-control" name="title" id="title" placeholder="Enter Title">
			</div>
			
			<div class="mb-3">
  			<label for="writer" class="form-label">Writer</label>
  				<input type="text" class="form-control" name="writer" id="writer" value="${member.id}" placeholder="Enter writer" readonly="readonly">
			</div>		
				
			
			<div class="mb-3">
			<label for="contents">Contents</label>
  		<textarea class="form-control" name="contents" placeholder="Leave a comment here" id="contents" style="height: 100px"></textarea>
			</div>
			
			<button class="btn btn-success" id="btn1" type="button">FileAdd</button>
			<button id="del" type="button">Delete</button>
			
			
			
			<div id="fileAddResult">
			
			</div>
			
			
						
			<button type="submit" class="btn btn-success">Add</button>
			
		</form>
		
	</div>



<script type="text/javascript" src="../resources/js/boardFile.js"></script>

</body>
</html>