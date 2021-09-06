package com.iu.s4.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		
		List<BoardDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		
		return mv;
		
	}
	
	
	@GetMapping("select")
	public ModelAndView select(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getSelect(boardDTO);
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
		
		int result = qnaService.setInsert(boardDTO);
		
		return "redirect:./list";
		
		/*
		 * System.out.println("Insert : "+bankBookDTO.getBookName());
		 * System.out.println(bankBookDTO.getBookSale());
		 */
		
	}
	
	@GetMapping("delete")
	public String delete(BoardDTO boardDTO) throws Exception {
		int result = qnaService.setDelete(boardDTO);
		
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public ModelAndView update(BoardDTO boardDTO) throws Exception {
		boardDTO = qnaService.getSelect(boardDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("update", boardDTO);
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView update(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		
		int result = qnaService.setUpdate(boardDTO);
		mv.setViewName("redirect:./list");
		
		return mv;
		
		
	}

}
