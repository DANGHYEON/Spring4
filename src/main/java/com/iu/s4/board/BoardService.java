package com.iu.s4.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.board.util.Pager;

public interface BoardService {
	
	//전체 갯수
	public Long getCount(Pager pager) throws Exception;
	
	//List
	public abstract List<BoardDTO>  getList(Pager pager) throws Exception;
	
	//상세
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
	
	//글쓰기
	public int setInsert(BoardDTO boardDTO,MultipartFile [] files) throws Exception;
	
	//글삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	//글수정
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	public int setComment(CommentsDTO commentsDTO) throws Exception;
	
	

}
