package co.seokjin.mybatis.command;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seokjin.mybatis.comm.Command;
import co.seokjin.mybatis.notice.service.NoticeService;
import co.seokjin.mybatis.notice.service.NoticeVO;
import co.seokjin.mybatis.notice.serviceImpl.NoticeServiceImpl;

public class NoticeInsert implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		LocalDate date = LocalDate.now();
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		vo.setWriteDate(Date.valueOf(date));
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));
		
		String viewPage = null;
		int n = noticeDao.noticeInsert(vo);
		
		if(n != 0) {
			viewPage= "noticeList.do";
		} else {
			request.setAttribute("message", "글쓰기 실패");
			viewPage = "notice/noticeFail";
		}
		return viewPage;
	}
}
