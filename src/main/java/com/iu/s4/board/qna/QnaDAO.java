package com.iu.s4.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s4.board.BoardDAO;
import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESAPCE="com.iu.s4.board.qna.QnaDAO.";
	
	

	@Override
	public Long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESAPCE+"getCount", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESAPCE+"getList",pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESAPCE+"getSelect", boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESAPCE+"setInsert", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESAPCE+"setDelete", boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESAPCE+"setUpdate", boardDTO);
	}
	
	//답글
	public int setReply(QnaDTO qnaDTO) throws Exception {
		
		return 0;
	}

}
