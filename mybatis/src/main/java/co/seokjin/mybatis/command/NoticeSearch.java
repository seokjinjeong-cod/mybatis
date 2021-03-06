package co.seokjin.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seokjin.mybatis.comm.Command;
import co.seokjin.mybatis.notice.service.NoticeService;
import co.seokjin.mybatis.notice.service.NoticeVO;
import co.seokjin.mybatis.notice.serviceImpl.NoticeServiceImpl;

public class NoticeSearch implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
//		System.out.println(request.getParameter("notice"));
//		System.out.println(request.getParameter("search"));
		if(request.getParameter("notice").equals("제목")) {	//제목으로 검색
			vo.setTitle(request.getParameter("search"));
			request.setAttribute("notices", noticeDao.titleSearchList(vo));
			
		} else if(request.getParameter("notice").equals("작성자")) {	//작성자로 검색
			vo.setName(request.getParameter("search"));
			request.setAttribute("notices", noticeDao.nameSearchList(vo));
			
		} else {
			vo.setContents(request.getParameter("search"));	//내용으로 검색
			request.setAttribute("notices", noticeDao.contentsSearchList(vo));
		}
		return "notice/noticeList";
	}
}
