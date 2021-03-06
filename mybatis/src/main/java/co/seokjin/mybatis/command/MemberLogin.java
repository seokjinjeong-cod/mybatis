package co.seokjin.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.seokjin.mybatis.comm.Command;
import co.seokjin.mybatis.member.service.MemberService;
import co.seokjin.mybatis.member.service.MemberVO;
import co.seokjin.mybatis.member.serviceImpl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
//		vo.setId(session.getAttribute("id")); 세션이 존재할때 세션값을 가져온다.
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo = memberDao.memberSelect(vo);
		
		String viewPage = null;
		request.setAttribute("member", vo); //
		
		if(vo != null) {
			request.setAttribute("message", vo.getName()+"님 환영합니다.");
			session.setAttribute("id", vo.getId());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("name", vo.getName());
			viewPage = "member/memberSuccess";
		} else {
			request.setAttribute("message", "아이디 또는 패스워드가 틀렸습니다.");
			viewPage = "member/memberFail"; 
		}
		return viewPage;
	}

}
