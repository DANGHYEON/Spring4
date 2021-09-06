package com.iu.s4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	

	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
		
	}
	
	
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		List<BoardDTO> ar = noticeService.getList(pager);
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		
		return mv;
	}
	
	
	@GetMapping("select")
	public ModelAndView select(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/select");
		 return mv;
	
	}
	
	@GetMapping("insert")
	public ModelAndView insert() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/insert");
				return mv;
		
		
	}
	
	@PostMapping("insert")
	public String insert(BoardDTO boardDTO) throws Exception {
		
		int result = noticeService.setInsert(boardDTO);
		
		return "redirect:./list";
		
		/*
		 * System.out.println("Insert : "+bankBookDTO.getBookName());
		 * System.out.println(bankBookDTO.getBookSale());
		 */
		
	}
	
	@GetMapping("delete")
	public String delete(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setDelete(boardDTO);
		
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public ModelAndView update(BoardDTO boardDTO) throws Exception {
		boardDTO = noticeService.getSelect(boardDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("update", boardDTO);
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView update(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		
		int result = noticeService.setUpdate(boardDTO);
		mv.setViewName("redirect:./list");
		
		return mv;
		
		
	}
	
	

}
