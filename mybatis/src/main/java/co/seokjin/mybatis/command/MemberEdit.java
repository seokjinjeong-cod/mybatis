package co.seokjin.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seokjin.mybatis.comm.Command;
import co.seokjin.mybatis.member.service.MemberService;
import co.seokjin.mybatis.member.service.MemberVO;
import co.seokjin.mybatis.member.serviceImpl.MemberServiceImpl;

public class MemberEdit implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("modPw"));
		vo.setAuthor(request.getParameter("modAuthor"));
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("modPw"));
//		System.out.println(request.getParameter("modAuthor"));
		int n = memberDao.memberUpdate(vo);
		System.out.println(n);
		String viewPage = null;
		
		if(n != 0) {
			viewPage = "home.do";
		} else {
			request.setAttribute("message", "수정 실패");
			viewPage = "member/memberFail";
		}
		return viewPage;
	}
}
