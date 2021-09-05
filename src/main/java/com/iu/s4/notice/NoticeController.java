package com.iu.s4.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv, Pager pager) {
		
		List<NoticeDTO> ar	=noticeService.getList(pager);
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.setViewName("/board/list");
		
		return mv;
		
	}
	
	
	@RequestMapping("select")
	public ModelAndView select(NoticeDTO noticeDTO,ModelAndView mv) {
		noticeDTO=noticeService.getSelect(noticeDTO);
		
		mv.addObject("dto",noticeDTO );
		mv.setViewName("/board/select");
		
		return mv;
		
	}
	
	@RequestMapping("insert")
	public ModelAndView test(ModelAndView mv){
		mv.setViewName("/board/insert");
		
		return mv;
	}
	
	  
	  @RequestMapping(value = "insert", method = RequestMethod.POST ) 
	  public ModelAndView insert(NoticeDTO noticeDTO, ModelAndView mv) {
	  
	  int result = noticeService.setInsert(noticeDTO);
	  
	  mv.setViewName("redirect:/notice/list");
	  
	  return mv;
	  
	  }
	 
	
	@RequestMapping("delete")
	public String delete(NoticeDTO noticeDTO) {
		
		int result = noticeService.setDelete(noticeDTO);
		
		return "redirect:/notice/list";
		
		
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(NoticeDTO noticeDTO,ModelAndView mv) {
		noticeDTO = noticeService.getSelect(noticeDTO);
		
		mv.setViewName("/board/update");
		mv.addObject("update", noticeDTO);
		return mv;
		
	}
	

	@RequestMapping(value = "update", method=RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) {
		
		int result = noticeService.setUpdate(noticeDTO);
		
		return "redirect:/notice/list";
		
	}
	

}
