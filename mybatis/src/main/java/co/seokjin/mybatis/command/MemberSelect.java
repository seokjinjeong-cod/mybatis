package co.seokjin.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.seokjin.mybatis.comm.Command;
import co.seokjin.mybatis.member.service.MemberService;
import co.seokjin.mybatis.member.service.MemberVO;
import co.seokjin.mybatis.member.serviceImpl.MemberServiceImpl;

public class MemberSelect implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId((String)session.getAttribute("id"));	// 세션이 가지고있는 아이디값을 가져온다.
		request.setAttribute("member", memberDao.memberSelect(vo));
		
		return "member/memberSelect";
	}

}
