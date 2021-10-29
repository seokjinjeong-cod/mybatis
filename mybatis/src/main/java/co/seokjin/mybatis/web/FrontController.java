package co.seokjin.mybatis.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seokjin.mybatis.comm.Command;
import co.seokjin.mybatis.command.HomeCommand;
import co.seokjin.mybatis.command.MemberDelete;
import co.seokjin.mybatis.command.MemberEdit;
import co.seokjin.mybatis.command.MemberJoin;
import co.seokjin.mybatis.command.MemberJoinFrom;
import co.seokjin.mybatis.command.MemberList;
import co.seokjin.mybatis.command.MemberLogin;
import co.seokjin.mybatis.command.MemberLoginForm;
import co.seokjin.mybatis.command.MemberLogout;
import co.seokjin.mybatis.command.MemberSelect;
import co.seokjin.mybatis.command.NoticeDelete;
import co.seokjin.mybatis.command.NoticeEdit;
import co.seokjin.mybatis.command.NoticeForm;
import co.seokjin.mybatis.command.NoticeInsert;
import co.seokjin.mybatis.command.NoticeList;
import co.seokjin.mybatis.command.NoticeSearch;
import co.seokjin.mybatis.command.NoticeSelect;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> map = new HashMap<String, Command>();

       
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new HomeCommand());	//홈페이지
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 폼
		map.put("/memberLogin.do", new MemberLogin()); // 로그인
		map.put("/memberJoinFrom.do", new MemberJoinFrom()); //회원가입폼
		map.put("/memberJoin.do", new MemberJoin()); //회원가입
		map.put("/memberList.do", new MemberList()); // 멤버리스트 가져오기
		map.put("/memberSelect.do", new MemberSelect()); // 나의 정보
		map.put("/memberLogout.do", new MemberLogout()); //로그아웃
		map.put("/memberEdit.do", new MemberEdit());  //내정보 수정
		map.put("/memberDelete.do", new MemberDelete()); // 회원탈퇴
		
		map.put("/noticeInsert.do", new NoticeInsert()); // 글쓰기
		map.put("/noticeForm.do", new NoticeForm()); //글쓰기 폼
		map.put("/noticeList.do", new NoticeList()); // 글목록
		map.put("/noticeEdit.do", new NoticeEdit()); // 글 수정
		map.put("/noticeSelect.do", new NoticeSelect()); //글상세보기
		map.put("/noticeDelete.do", new NoticeDelete()); //글삭제
		map.put("/noticeSearch.do", new NoticeSearch()); //글 검색
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.run(request, response);
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
