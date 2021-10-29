package co.seokjin.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seokjin.mybatis.comm.Command;
import co.seokjin.mybatis.notice.service.NoticeService;
import co.seokjin.mybatis.notice.service.NoticeVO;
import co.seokjin.mybatis.notice.serviceImpl.NoticeServiceImpl;

public class NoticeDelete implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNid(Integer.valueOf(request.getParameter("nid")));
		int n = noticeDao.noticeDelete(vo);
		String viewPage = null;
		
		if(n != 0) {
			viewPage = "noticeList.do";
		} else {
			request.setAttribute("messsage", "삭제 실패");
			viewPage = "notice/noticeFail";
		}
		return viewPage;
	}
}
