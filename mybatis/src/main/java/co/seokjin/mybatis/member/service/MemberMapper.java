package co.seokjin.mybatis.member.service;

import java.util.List;

public interface MemberMapper {		//mybatis mapper에서 사용
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
}
