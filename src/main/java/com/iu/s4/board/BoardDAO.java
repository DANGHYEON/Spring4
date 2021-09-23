package com.iu.s4.board;

import java.util.List;

import com.iu.s4.board.util.Pager;

public interface BoardDAO {
	
	//전체 갯수
	public Long getCount(Pager pager) throws Exception;
	
	//List
	public abstract List<BoardDTO>  getList(Pager pager) throws Exception;
	
	//상세
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
	
	//글쓰기
	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	//글삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	//글수정
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//조회수 업데이트
	public int setHitUpdate(BoardDTO boardDTO) throws Exception;
	
	//file
	public int setFile(BoardFilesDTO boardFilesDTO) throws Exception;
	
	
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO) throws Exception;
	
	public int setComment(CommentsDTO commentsDTO) throws Exception;

}
