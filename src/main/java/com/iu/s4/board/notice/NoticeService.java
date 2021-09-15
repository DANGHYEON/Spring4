package com.iu.s4.board.notice;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardService;
import com.iu.s4.board.util.FileManager;
import com.iu.s4.board.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private ServletContext servletContext;
	

	@Override
	public Long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getCount(pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeNum(noticeDAO.getCount(pager));
		pager.makeRow();
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		noticeDAO.setHitUpdate(boardDTO);
		return noticeDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		
		//1. 어느 폴더 /resources/upload/notice
		String realPath = this.servletContext.getRealPath("/resources/upload/notice");
		System.out.println(realPath);
		File file = new File(realPath);
		
		
		//2. 파일 저장
		for(MultipartFile multipartFile : files) {
		 String fileName = fileManager.fileSave(multipartFile, file);
		}
		
		return 0; 
		// noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}

}
