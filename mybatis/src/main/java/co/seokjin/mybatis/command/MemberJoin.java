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
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setAddress(request.getParameter("address"));
		vo.setTel(request.getParameter("tel"));
		vo.setAuthor(request.getParameter("author"));
		int n = memberDao.memberInsert(vo);
		
		String viewPage = null;
		if(n != 0) {
			viewPage = "member/memberLoginForm"; 
		} else {
			request.setAttribute("message", "회원가입 실패");
			viewPage = "member/memberFail";	
		}
		return viewPage;
	}
}
