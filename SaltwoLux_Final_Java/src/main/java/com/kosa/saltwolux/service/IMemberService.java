package com.kosa.saltwolux.service;

import javax.servlet.http.HttpSession;

import com.kosa.saltwolux.vo.MemberVO;

public interface IMemberService {
	
	// 로그인
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
	
	// 회원가입, memberNum + 1
	void memberRegister(MemberVO memberVO) throws Exception;
	
	// 로그인 체크
	int logincheck(HttpSession session);

}
