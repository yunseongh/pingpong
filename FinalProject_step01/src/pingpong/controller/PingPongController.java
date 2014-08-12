package pingpong.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pingpong.model.PingPongBean;
import pingpong.model.PingPongDAO;

/**
 * Servlet implementation class PingPongController
 */
public class PingPongController extends HttpServlet {
    public PingPongController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		String command = request.getParameter("command");
		
		if (command == null) {
			command = "list";
		}
		
		if (command.equals("list")) {
			request.setAttribute("list", PingPongDAO.GetAllMember());

			request.getRequestDispatcher("list.jsp").forward(request, response);
			return;

		} else if (command.equals("write")) { // 회원가입 할 경우

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String major = request.getParameter("major");
			String school = request.getParameter("school");
			
			if (email == null || email.trim().length() == 0 || password == null
					|| password.trim().length() == 0 || name == null
					|| name.trim().length() == 0 || major == null
					|| major.trim().length() == 0 || school == null
					|| school.trim().length() == 0) {
				response.sendRedirect("LoginView.html");
				return;
			}
			//public PingPongBean(String email, String name, String password, String school, String major)
			PingPongBean gMember = new PingPongBean(email,name,password,school,major);
			boolean result = PingPongDAO.CreateMember(gMember);
			if (result) {
				response.sendRedirect("pingpong.do");
				return;
			} else {
				response.sendRedirect("error.jsp");
				return;
			}
		}else if(command.equals("main")){ // 로그인 과정의 경우
			//로그인 상태유지, id, password 값 넘겨주기
			
			String loginemail = request.getParameter("loginemail");
			String loginpassword = request.getParameter("loginpassword");
				
			if (loginemail.trim().length() == 0|| loginpassword.trim().length() == 0) {
				response.sendRedirect("LoginView.html");
				System.out.println("길이 오류");
				return;
			} 
			// 아이디와 비번이 맞으면 실행하고 아니면 실행시키지 않는 로직, 이메일을 통해서 password가 맞는지 아는 로직이 필요하다
			PingPongBean ppb = PingPongDAO.GetMember(loginemail);
			if(!ppb.getPassword().equals(loginpassword)){ // 비밀번호가 맞지 않으면 
				System.out.println("비밀번호 오류" + ppb.getPassword());
				response.sendRedirect("LoginView.html");
				return;
			}
			
			HttpSession session = request.getSession(); // 로그인 세션 등록하기
			session.setAttribute("id", loginemail);
			session.setAttribute("password", loginpassword);
			
			request.getRequestDispatcher("MainView.jsp").forward(request, response);
			return;
		}
	}
}
