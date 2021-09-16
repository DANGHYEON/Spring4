package com.iu.s4.member;

import java.io.Console;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	
	@GetMapping("update")
	public ModelAndView update() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/update");
		return mv;
	}
	
	
	
	
	@PostMapping("update")
	public ModelAndView update(MemberDTO memberDTO, HttpSession session) throws Exception{
		//수정 전 데이터
		MemberDTO memberDTO2 =(MemberDTO)session.getAttribute("member");
		
		//수정 후 데이터
		memberDTO.setId(memberDTO2.getId());
		
		
		ModelAndView mv = new ModelAndView();
		int result = memberService.setUpdate(memberDTO);
		
		memberDTO.setName(memberDTO2.getName());
		
		session.setAttribute("member", memberDTO);
		
		mv.setViewName("redirect:../");
		
		return mv;
	}
	

	

	
	
	@GetMapping("out")
	public ModelAndView out(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberService.setOut(memberDTO);
		System.out.println(memberDTO.getId());
		mv.setViewName("redirect:./logout");
		
		return mv;
	}
	
	
	
	@GetMapping("mypage")
	public ModelAndView mypage(HttpSession session) throws Exception {
		MemberDTO memberDTO	= (MemberDTO)session.getAttribute("member");
		
		MemberFilesDTO memberFilesDTO  = memberService.getFile(memberDTO);
		
		ModelAndView mv = new ModelAndView();
		//mv.addObject("files", memberFilesDTO);
		mv.setViewName("member/mypage");
		return mv;
	}
	
	
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) throws Exception {
		
		//member라는 것을 삭제
		//session.removeAttribute("member");
		
		//2. 세션의 시간을 0
		session.invalidate();
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:../");
		return mv;
	}

	
	@PostMapping("login")
	public ModelAndView login(MemberDTO memberDTO, HttpSession session) throws Exception {
		
		
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getLogin(memberDTO);
		
		if(memberDTO != null) {
			System.out.println("로그인성공");
			session.setAttribute("member", memberDTO);
		}else {
			System.out.println("로그인 실패");
		}
		
		mv.setViewName("redirect:../");
		
		return mv;
		
	}
	
	
	
	@GetMapping("login")
	public ModelAndView login() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		
		return mv;
	}
	
	
	@GetMapping("idCheck")
	public ModelAndView getIdCheck(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getIdCheck(memberDTO);
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/idCheck");
		
		return mv;
	}
	
	
	@GetMapping("check")
	public ModelAndView check() throws Exception {
		
		ModelAndView mv =new ModelAndView();
		mv.setViewName("member/check");
		return mv;
	}
	
	@GetMapping("join")
	public ModelAndView join() throws Exception{
		ModelAndView mv =new ModelAndView();
		mv.setViewName("member/join");
		return mv;
		
	}
	
	@PostMapping("join")
	public ModelAndView join(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception{
		
		ModelAndView mv =new ModelAndView();
		int result = memberService.setJoin(memberDTO, photo, session);
		
		String message = "회원가입 실패";
		if(result>0) {
			message = "회원 가입 성공";
		}
		
		mv.addObject("msg", message);
		mv.addObject("url", "../");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	
	

}
