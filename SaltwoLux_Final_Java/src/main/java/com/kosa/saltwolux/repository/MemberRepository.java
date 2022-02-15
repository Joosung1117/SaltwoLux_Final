package com.kosa.saltwolux.repository;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.kosa.saltwolux.vo.MemberVO;

@Repository
public class MemberRepository implements IMemberRepository{
 	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// 회원 가입
	@Override
	public void memberRegister(MemberVO memberVO) throws Exception{
		String sql = "insert into member values(?,?,?,?,?)";
		jdbcTemplate.update(sql, memberVO.getMemberNum(), memberVO.getMemberId(), memberVO.getMemberPw(), memberVO.getMemberName(), memberVO.getMemberPhone());
	}
	
	// userNum 자동 증가
	@Override
	public String getMemberNum() {
		String sql = "select nvl(max(SUBSTR(user_num, length(user_num), length(user_num))),0) as user_num from user";
		int intResult = jdbcTemplate.queryForObject(sql, Integer.class) + 1;
		String strResult = String.format("$04d", intResult);
		return strResult;
	}
	
	// 로그인
	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		String sql = "select * from member where member_id = ? and member_pw = ?";
		Object[] args = {memberVO.getMemberId(), memberVO.getMemberPw()};
		return jdbcTemplate.queryForObject(sql, args, new RowMapper<MemberVO>() {
			
			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				MemberVO memberVO = new MemberVO();
				memberVO.setMemberNum(rs.getString("member_num"));
				memberVO.setMemberId(rs.getString("member_id"));
				memberVO.setMemberPw(rs.getString("member_pw"));
				memberVO.setMemberName(rs.getString("member_name"));
				memberVO.setMemberPhone(rs.getString("member_phone"));
				return memberVO;
			}
		});
	}
	
}
