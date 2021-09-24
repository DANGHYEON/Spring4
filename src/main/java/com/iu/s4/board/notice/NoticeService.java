package com.iu.s4.board.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardFilesDTO;
import com.iu.s4.board.BoardService;
import com.iu.s4.board.CommentsDTO;
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
	
	
	public int setCommentUpdate(CommentsDTO commentsDTO) throws Exception{
		return noticeDAO.setCommentUpdate(commentsDTO);
	}
	
	
	
	public int setCommentDelete(CommentsDTO commentsDTO) throws Exception {
		return noticeDAO.setCommentDelete(commentsDTO);
	}
	
	
	
	@Override
	public List<CommentsDTO> getCommentList(CommentsDTO commentsDTO,Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.setPerPage(5L); //보여줄 데이터 갯수
		pager.makeRow();
		pager.makeNum(noticeDAO.getCommentCount(commentsDTO)); //전체 데이터 갯수 가져와 넣기
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("comments", commentsDTO);
		map.put("pager", pager);
		return noticeDAO.getCommentList(map);
	}
	
	
	@Override
	public int setComment(CommentsDTO commentsDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setComment(commentsDTO);
	}
	
	
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO) throws Exception{
		
		return noticeDAO.getFiles(boardDTO);
				
	}
	

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
		
		noticeDAO.setHitUpdate(boardDTO);
		return noticeDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		
		//1. 어느 폴더 /resources/upload/notice
		String realPath = this.servletContext.getRealPath("/resources/upload/notice");
		System.out.println(realPath);
		File file = new File(realPath);
		
		//System.out.println("BE Num : "+boardDTO.getNum());
		
		int result = noticeDAO.setInsert(boardDTO);
		
		//System.out.println("AT Num : "+boardDTO.getNum());
		
		
		
		//2. 파일 저장
		for(MultipartFile multipartFile : files) {
		 String fileName = fileManager.fileSave(multipartFile, file);
		 BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
		 boardFilesDTO.setFileName(fileName);
		 boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
		 boardFilesDTO.setNum(boardDTO.getNum());
		 
		 result = noticeDAO.setFile(boardFilesDTO);
		}
		
		return result; 
		// noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		//Files Table에서 삭제할 파일명들 조회
		List<BoardFilesDTO> ar = noticeDAO.getFiles(boardDTO);
		
		//어느 폴더
		String realPath = servletContext.getRealPath("/resources/upload/notice/");
		System.out.println(realPath);
			for(BoardFilesDTO dto : ar) {
				File file = new File(realPath,dto.getFileName());
				fileManager.fileDelete(file);
			}
		
		
		
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}

}
