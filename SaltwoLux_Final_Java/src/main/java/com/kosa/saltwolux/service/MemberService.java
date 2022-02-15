package com.kosa.saltwolux.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.saltwolux.repository.IMemberRepository;
import com.kosa.saltwolux.vo.MemberVO;

@Service
public class MemberService implements IMemberService{

	@Autowired
	IMemberRepository memberRepository;
	
	// 로그인
	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception{
		return memberRepository.memberLogin(memberVO);
	}
	
	// 회원가입, memberNum + 1
	@Override
	public void memberRegister(MemberVO memberVO) throws Exception{
		memberVO.setMemberNum(memberRepository.getMemberNum());
		memberRepository.memberRegister(memberVO);
	}
	
	// 로그인 체크
	@Override
	public int logincheck(HttpSession session) {
		if(session.getAttribute("memberVO") != null) {
			return 1;
		}
		else return 0;
	}

}
