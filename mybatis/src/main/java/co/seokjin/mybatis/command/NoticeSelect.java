package co.seokjin.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.seokjin.mybatis.comm.Command;
import co.seokjin.mybatis.notice.service.NoticeService;
import co.seokjin.mybatis.notice.service.NoticeVO;
import co.seokjin.mybatis.notice.serviceImpl.NoticeServiceImpl;

public class NoticeSelect implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNid(Integer.parseInt(request.getParameter("nid")));
		
		request.setAttribute("notice", noticeDao.noticeSelect(vo));
		request.setAttribute("member", session.getAttribute("author"));
		
		return "notice/noticeSelect";
	}
}
