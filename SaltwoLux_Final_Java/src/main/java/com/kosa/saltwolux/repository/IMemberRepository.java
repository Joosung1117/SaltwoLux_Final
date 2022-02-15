package com.kosa.saltwolux.repository;

import com.kosa.saltwolux.vo.MemberVO;

public interface IMemberRepository {

	// 회원 가입
	public void memberRegister(MemberVO memberVO) throws Exception;

	// memberNum +1씩 증가
	public String getMemberNum();
	
	// 로그인
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;

}
