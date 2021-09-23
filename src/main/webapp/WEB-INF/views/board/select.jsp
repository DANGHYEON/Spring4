
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
	<div>
		${dto.contents}
	</div>
	<h2>작성자 : ${dto.writer}</h2>
	<h2>작성일 : ${dto.regDate}</h2>
	<h2>조회수 : ${dto.hits}</h2>
	</div>
	
	<c:forEach items="${dto.files}" var="f">
		<div>
		<%-- <a href="../resources/upload/${board}/${f.fileName}">${f.oriName}</a> --%>
		<a href="./down?fileName=${f.fileName}">${f.oriName}</a>
		</div>
	</c:forEach>
	
	
	
	<hr>
	<div>
	<div class="mb-3">
  			<label for="writer" class="form-label">Writer</label>
  				<input type="text" class="form-control" name="writer" id="writer" value="${member.id}" placeholder="Enter writer" readonly="readonly">
			</div>		
				
			
			<div class="mb-3">
			<label for="contents">Contents</label>
  		<textarea class="form-control" name="contents" placeholder="Leave a comment here" id="contents" style="height: 100px"></textarea>
			</div>
	
	<button type="button" id="comment" class="btn btn-success">Add</button>
	
	</div>
	<hr>

	
	<div>
	<c:if test="${not empty member and member.id eq dto.writer}">
	<a href="./delete?num=${dto.num}" class="btn btn-danger" >Delete</a>
	<a href="./update?num=${dto.num}" class="btn btn-success">Update</a>
	</c:if>
	
	<c:if test="${board eq 'qna'}">
		<a href="./reply?num=${dto.num}">Reply</a>
	</c:if>
	</div>
	
	<script type="text/javascript">
		$("#comment").click(function(){
			//작성자, 내용을 콘솔에 출력
			let writer = $("#writer").val();
			let contents = $("#contents").val();
			$.post('./comment',{num:'${dto.num}',writer:writer, contents:contents}, function(result){
					console.log(result.trim());
			});
			
		});
	</script>
	
</body>
</html>