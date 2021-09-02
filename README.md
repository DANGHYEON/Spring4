# Spring4

## Board

### Notice

 글번호, 글제목, 글의 내용, 작성자, 작성일, 조회수
	a      a       a      오늘   0
	
1. 테이블 생성
   NOTICE
   NUM 슈퍼키
   TITLE
   CONTENTS
   WRITER
   REGDATE
   HITS
 
2. Notice Sequence


3. 기능			URL                 jsp경로
	1) LIST (/notice/list) , (/WEB-INF/board/list.jsp)
	2) 상세  (/notice/select?num=?), (/WEB-INF/board/select.jsp)
	3) 글쓰기 (/notice/)
	4) 삭제
	5) 수정


흐름 : 처옴 보는건 리스트(글 목록)-> 제목 클릭시 상세페이지 -> 글 삭제 -> 리스트
											-> 글 수정 -> 리스트
						-> 글 쓰기  -> 리스트
						
				
				
4. 순서
1) DTO, DAO, MAPPER, Test case 테스트 수행
2) Service, Controller, JSP 연결