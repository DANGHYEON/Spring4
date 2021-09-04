package com.iu.s4;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s4.notice.NoticeDAO;
import com.iu.s4.notice.NoticeDTO;

public class NoticeDAOTest extends MyJunitTest{
	
	
	@Autowired
	private NoticeDAO noticeDAO;

	
	
	@Test
	public void setUpdate() {
		NoticeDTO dto = new NoticeDTO();
		dto.setNum(61);
		dto.setTitle("String");
		dto.setContents("String2");
		
		int result = noticeDAO.setUpdate(dto);
		
		assertNotEquals(0, result);
	}
	
	
	
	
	
	
	//@Test
	public void setDelete() {
		NoticeDTO dto = new NoticeDTO();
		dto.setNum(21);
		
		int result = noticeDAO.setDelete(dto);
		
		assertNotEquals(0, result);
	}
	
	
	
	
	
	
	
	//@Test
	public void setInsert() {
		NoticeDTO dto = new NoticeDTO();
		dto.setTitle("t3");
		dto.setContents("c3");
		dto.setWriter("w3");
		
		int result = noticeDAO.setInsert(dto);
		
		assertNotEquals(0, result);
		
	}
	
	
	
	
	
	
	
	//@Test
	public void getSelectTest() {
		NoticeDTO dto = new NoticeDTO();
		dto.setNum(1);
		dto = noticeDAO.getSelet(dto);
		
		assertNotNull(dto);
		
		
	}
	
	
	
	
	
	
	//@Test
	public void getListTest() {
		
		List<NoticeDTO> ar = noticeDAO.getList();
		
		assertNotEquals(0, ar.size());
	}


}
