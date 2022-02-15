package com.kosa.saltwolux.vo;

public class MemberVO {
	private String memberNum;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	
	public String getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	@Override
	public String toString() {
		return "memberVO [memberNum=" + memberNum + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberPhone=" + memberPhone + "]";
	}
	
	
}
