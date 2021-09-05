package com.iu.s4.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s4.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	public List<NoticeDTO> getList(Pager pager){
		return noticeDAO.getList(pager);
	}
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO) {
		
		return noticeDAO.getSelet(noticeDTO);
	}
	
	public int setInsert(NoticeDTO noticeDTO) {
		
		return noticeDAO.setInsert(noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO) {
		
		return noticeDAO.setDelete(noticeDTO);
	}
	
	public int setUpdate(NoticeDTO noticeDTO) {
		
		return noticeDAO.setUpdate(noticeDTO);
	}
	
	

}
