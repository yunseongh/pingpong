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

		} else if (command.equals("write")) { // ȸ������ �� ���

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
		}else if(command.equals("main")){ // �α��� ������ ���
			//�α��� ��������, id, password �� �Ѱ��ֱ�
			
			String loginemail = request.getParameter("loginemail");
			String loginpassword = request.getParameter("loginpassword");
				
			if (loginemail.trim().length() == 0|| loginpassword.trim().length() == 0) {
				response.sendRedirect("LoginView.html");
				System.out.println("���� ����");
				return;
			} 
			// ���̵�� ����� ������ �����ϰ� �ƴϸ� �����Ű�� �ʴ� ����, �̸����� ���ؼ� password�� �´��� �ƴ� ������ �ʿ��ϴ�
			PingPongBean ppb = PingPongDAO.GetMember(loginemail);
			if(!ppb.getPassword().equals(loginpassword)){ // ��й�ȣ�� ���� ������ 
				System.out.println("��й�ȣ ����" + ppb.getPassword());
				response.sendRedirect("LoginView.html");
				return;
			}
			
			HttpSession session = request.getSession(); // �α��� ���� ����ϱ�
			session.setAttribute("id", loginemail);
			session.setAttribute("password", loginpassword);
			
			request.getRequestDispatcher("MainView.jsp").forward(request, response);
			return;
		}
	}
}
