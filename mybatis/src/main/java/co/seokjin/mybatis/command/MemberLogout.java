package co.seokjin.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.seokjin.mybatis.comm.Command;

public class MemberLogout implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "home.do";
	}

}
