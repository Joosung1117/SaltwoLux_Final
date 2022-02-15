package com.kosa.saltwolux.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosa.saltwolux.service.IMemberService;
import com.kosa.saltwolux.vo.MemberVO;
 
@Controller
public class MemberController {
	
	@Autowired
	IMemberService memberService;
	
	// 홈
	@RequestMapping(value="/home")
	public String home(HttpSession session) {
		if(memberService.logincheck(session) == 1){
			return "redirect:/memberhome";
		}
		else return "member/login";
	}
	
	// 로그인
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberVO memberVO, Model model, HttpSession session, RedirectAttributes attr) {
		String msg = "로그인 실패";
		try {
			memberVO = memberService.memberLogin(memberVO);
			if(memberVO.getMemberId() != null) {
				model.addAttribute("memberVO", memberVO);
			
				session.setAttribute("memberVO", memberVO);
				session.setAttribute("memberNum", memberVO.getMemberNum());
				
				return "redirect:/memberhome"; // 로그인 성공시 이동할 주소
			}
			else {
				session.setAttribute("memberVO", null);
				attr.addFlashAttribute("msg", msg);
				return "redirect:/home"; // 로그인 실패시 홈으로
			}
		}
		catch(Exception e) {
			attr.addFlashAttribute("msg", msg);
			return "redirect:/home";
		}
	}
	
	//
}
