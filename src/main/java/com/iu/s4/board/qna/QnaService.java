package com.iu.s4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardFilesDTO;
import com.iu.s4.board.BoardService;
import com.iu.s4.board.util.FileManager;
import com.iu.s4.board.util.Pager;
@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private ServletContext servletContext;

	@Override
	public Long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getCount(pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeNum(qnaDAO.getCount(pager));
		pager.makeRow();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		qnaDAO.setHitUpdate(boardDTO);
		return qnaDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO,MultipartFile [] files) throws Exception {
		
		
		//1. 폴더 지정
		String realPath = servletContext.getRealPath("/resources/upload/QnA");
		
		File file = new File(realPath);
		
		System.out.println("BE Num : "+boardDTO.getNum());
		
		int result = qnaDAO.setInsert(boardDTO);
		
		System.out.println("AF Num : "+boardDTO.getNum());
		
		
		//파일 저장
		for(MultipartFile multipartFile : files) {
			String fileName = fileManager.fileSave(multipartFile, file);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			boardFilesDTO.setNum(boardDTO.getNum());
			
			result = qnaDAO.setFile(boardFilesDTO);
			
		}
		
		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setUpdate(boardDTO);
	}
	
	
	public int setReply(QnaDTO qnaDTO)throws Exception{
		// 1. 부모의 정보 조회
	 QnaDTO parent = (QnaDTO)qnaDAO.getSelect(qnaDTO);
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
	 
		// 2.update
		int result = qnaDAO.setReplyUpdate(parent);
		
		// 3. insert
		result = qnaDAO.setReply(qnaDTO);
	 
		return result;
	}
	
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO) throws Exception{
		return qnaDAO.getFiles(boardDTO);
	}

}
