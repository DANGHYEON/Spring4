package com.iu.s4.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.board.CommentsDTO;
import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardFilesDTO;
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
	
	
	
	@PostMapping("commentUpdate")
	public ModelAndView setCommentUpdate(CommentsDTO commentsDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setCommentUpdate(commentsDTO);
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		return mv;
	}
	
	
	
	
	@PostMapping("setCommentDelete")
	public ModelAndView setCommentDelete(CommentsDTO commentsDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setCommentDelete(commentsDTO);
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		return mv;
	}
	
	
	
	
	
	@GetMapping("getCommentList")
	public ModelAndView getCommentList(CommentsDTO commentsDTO, Pager pager) throws Exception{
		commentsDTO.setBoard("N");
		List<CommentsDTO> ar = noticeService.getCommentList(commentsDTO, pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("comments", ar);
		mv.addObject("pager", pager);
		mv.setViewName("common/ajaxList");
		
		return mv;
	}
	
	
	
	
	@PostMapping("comment")
	public ModelAndView setComment(CommentsDTO commentsDTO) throws Exception {
//		System.out.println(commetsDTO.getNum());
//		System.out.println(commetsDTO.getContents());
//		System.out.println(commetsDTO.getWriter());
		ModelAndView mv = new ModelAndView();
		commentsDTO.setBoard("N");
		
		int result = noticeService.setComment(commentsDTO);
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		
		return mv;
		
	}
	
	
	
	@GetMapping("down")
	public ModelAndView fileDown(BoardFilesDTO boardFilesDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto",boardFilesDTO);
		mv.setViewName("fileDown");
		return mv;
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
		List<BoardFilesDTO> ar = noticeService.getFiles(boardDTO);
	//	mv.addObject("fileList", ar);
		//List<CommentsDTO> comList = noticeService.getCommentList();
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
	public ModelAndView insert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		//original file name ??????
		
		for(MultipartFile files1 : files) {
			System.out.println(files1.getOriginalFilename());
		}
		
		
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(boardDTO,files);
		mv.setViewName("redirect:./list");
		return mv;
		
		
		
	}
	
	@GetMapping("delete")
	public ModelAndView delete(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(boardDTO);
		String message = " Delete Fail";
		if(result>0) {
			message = "Delete Success";
		}
		//"redirect:./list"
		mv.addObject("msg", message);
		mv.addObject("url", "./list");
		
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView update(BoardDTO boardDTO) throws Exception {
		boardDTO = noticeService.getSelect(boardDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView update(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		
		int result = noticeService.setUpdate(boardDTO);
		mv.setViewName("redirect:./list");
		
		return mv;
		
		
	}
	
	@PostMapping("fileDelete")
	public ModelAndView setFileDelete(BoardFilesDTO boardFilesDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setFileDelete(boardFilesDTO);
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		return mv;
		
	}
	
	

}
