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
import co.seokjin.mybatis.command.MemberList;
import co.seokjin.mybatis.command.MemberLogin;
import co.seokjin.mybatis.command.MemberLoginForm;
import co.seokjin.mybatis.command.MemberLogout;
import co.seokjin.mybatis.command.MemberSelect;
import co.seokjin.mybatis.command.NoticeList;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> map = new HashMap<String, Command>();

       
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new HomeCommand());
		map.put("/memberList.do", new MemberList()); // 멤버리스트 가져오기
		map.put("/memberSelect.do", new MemberSelect()); // 나의 정보
		map.put("/noticeList.do", new NoticeList()); // 글목록
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 폼
		map.put("/memberLogin.do", new MemberLogin()); // 로그인
		map.put("/memberLogout.do", new MemberLogout());
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
