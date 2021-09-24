
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
<style type="text/css">
	.more{
		cursor: pointer;
	}
</style>
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
	
	
		<!-- comment list -->
	<div id = "commentList" data-board-num="${dto.num}">
		
	
	
	</div>
	
	
	
	
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
	
	
		getCommentList(1);
		
		
		//Updata click event
		$("#commentList").on("click",".commentUpdate",function(){
			let num = $(this).attr("data-comment-update");
			let content = $("#content"+num).text().trim();
			$("#content"+num).children().css('display','none');
			let ta = '<textarea class="form-control" name="contents" placeholder="Leave a comment here" id="contents"  style="height: 150px">'
			ta = ta+content.trim()+'</textarea>';
			ta = ta + '<button type="button" id="update" class="btn btn-primary up">update</button>';
			ta = ta + '<button type="button" id="cancel" class="btn btn-danger can">Cancel</button>';
			$("#content"+num).append(ta);
			
			
			
		})
		
		
		
		//update
		$("#commentList").on("click",".up",function(){
			let contents = $(this).prev().val();
			let cn = $(this).parent().prev().text().trim();
			$.ajax({
				
				type:"POST",
				url : "./commentUpdate",
				data:{
					commentNum:cn,
					contents:contents
				},
				success:function(result){
					if(result.trim()>0){
						alert("수정성공");
						getCommentList(1);
						/* $(this).parent().children('div').text(contents);
						$(this).parent().children('div').css('display','block');
						$(this).parent().children('textarea').remove();
						$(this).parent().children('button').remove(); */
					}else{
						alert("수정 실패");
					}
				},
				error:function(){
					alert("수정실패");
				}
			});
		});
		
		
		
		//cancel
		$("#commentList").on("click",".can",function(){
			
			$(this).parent().children('div').css('display','block');
			$(this).parent().children('textarea').remove();
			$(this).parent().children('button').remove();
		})
		
		
		
		
		//Del click event
		$("#commentList").on("click",".commentDel",function(){
			let commentNum = $(this).attr("data-comment-del");
			console.log(commentNum);
			//url ./commentDel
			$.ajax({
				type:"POST",
				url: "./setCommentDelete",
				data: {commentNum:commentNum},
				success:function(result){
					
					result = result.trim();
					if(result>0){
						alert("삭제성공");
						getCommentList(1);
					}else{
						alert("삭제 실패");
					}
					
				},
				error:function(error){
					console.log(error);
					alert("삭제 실패");
				}
				
				
			})
			
		})
		
		
		$("#commentList").on("click",".more",function(){
			//data-comment-pn 값을 출력
			let pn = $(this).attr("data-comment-pn");
			getCommentList(pn);
		});
		
		
		
	
		function getCommentList(pageNumber){
			let num = $("#commentList").attr("data-board-num");
			$.ajax({
				type: "GET",
				url: "./getCommentList",
				data: {num:num, pn: pageNumber},
				success: function(result){
					result = result.trim();
					$("#commentList").html(result);
				},
				error:function(xhr,status,error){
					console.log(error);
				}
				
			});
		}
	
	
	
		$("#comment").click(function(){
			//작성자, 내용을 콘솔에 출력
			let writer = $("#writer").val();
			let contents = $("#contents").val();
			$.post('./comment',{num:'${dto.num}',writer:writer, contents:contents}, function(result){
					console.log(result.trim());
					
					$("#contents").val('');
					getCommentList();
			});
			
		});
	</script>
	
</body>
</html>