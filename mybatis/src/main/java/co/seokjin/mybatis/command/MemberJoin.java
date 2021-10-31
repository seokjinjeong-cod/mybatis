package co.seokjin.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seokjin.mybatis.comm.Command;
import co.seokjin.mybatis.member.service.MemberService;
import co.seokjin.mybatis.member.service.MemberVO;
import co.seokjin.mybatis.member.serviceImpl.MemberServiceImpl;

public class MemberJoin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		String viewPage = null;
		vo.setId(request.getParameter("id"));
		if(memberDao.memberSelect(vo) != null) {
			request.setAttribute("message", "중복된 아이디입니다.");
			viewPage = "member/memberFail";
		} else {
			vo.setId(request.getParameter("id"));
			vo.setPassword(request.getParameter("password"));
			vo.setName(request.getParameter("name"));
			vo.setAddress(request.getParameter("address"));
			vo.setTel(request.getParameter("tel"));
			vo.setAuthor(request.getParameter("author"));
			int n = memberDao.memberInsert(vo);
			if(n != 0) {
				request.setAttribute("message", "회원가입 성공");
				viewPage = "member/memberSuccess"; 
			} else {
				request.setAttribute("message", "회원가입 실패");
				viewPage = "member/memberFail";	
			}
		}
		return viewPage;
	}
}
