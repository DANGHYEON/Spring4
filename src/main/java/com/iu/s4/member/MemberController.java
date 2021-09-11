package com.iu.s4.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	
	
	
	@GetMapping("mypage")
	public ModelAndView mypage() throws Exception {

		ModelAndView mv = new ModelAndView();
		
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
	public ModelAndView join(MemberDTO memberDTO) throws Exception{
		ModelAndView mv =new ModelAndView();
		int result = memberService.setJoin(memberDTO);
		if(result<=0) {
		 System.out.println("다시입력해주세요");
		 mv.setViewName("member/join");
		}else {
			mv.setViewName("redirect:../");
		}
		return mv;
	}
	
	
	

}
