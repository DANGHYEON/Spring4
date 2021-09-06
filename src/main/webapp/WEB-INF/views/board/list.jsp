<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Board List Page</h1>
	
	<div class="container-fluid">
		<div class="col-md-7 mx-auto my-2">
		<table class="table table-striped">
			<tr>
				<th>num</th> <th>title</th> <th>writer</th> <th>regDate</th> <th>hits</th>
			</tr>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.num}</td>
					<td><a href="./select?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.regDate}</td>
					<td>${dto.hits}</td>
				
					
				</tr>
			</c:forEach>
		
		</table>

		
		
	
		</div>
	</div>
	
	

</body>
</html>