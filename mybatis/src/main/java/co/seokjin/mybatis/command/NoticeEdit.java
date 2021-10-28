package co.seokjin.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seokjin.mybatis.comm.Command;
import co.seokjin.mybatis.notice.service.NoticeService;
import co.seokjin.mybatis.notice.service.NoticeVO;
import co.seokjin.mybatis.notice.serviceImpl.NoticeServiceImpl;

public class NoticeEdit implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNid(Integer.parseInt(request.getParameter("nid")));
		vo.setTitle(request.getParameter("modTitle"));
		vo.setContents(request.getParameter("modContents"));
//		System.out.println(Integer.parseInt(request.getParameter("nid")));
//		System.out.println(request.getParameter("modTitle"));
//		System.out.println(request.getParameter("modContents"));
		
		int n = noticeDao.noticeUpdate(vo);
		String viewPage = null;
		
		if(n != 0) {
			viewPage = "noticeList.do";
		} else {
			request.setAttribute("message", "수정 실패");
			viewPage = "notice/noticeFail";
		}
		return viewPage;
	}
}
