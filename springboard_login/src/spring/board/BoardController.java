package spring.board;

import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.board.service.MainService;
import util.DBUtil;

@Controller
public class BoardController {

	@Autowired
	private MainService mainService;
	
	
	@RequestMapping("/login.do")
	public void login(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable{
		
	}
	
	@RequestMapping("/loginFail.do")
	public void loginFail(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable{
		
	}
	
	@RequestMapping("/main.do")
	public void main(@RequestParam Map<String, Object> paramMap, ModelMap model ,Principal principal) 
			throws Throwable{
		
		//�α��� �� �α��� �� ���̵�  ������ �´�.
		String name = principal.getName();
		
		model.addAttribute("username", name);
		System.out.println("�α��ο��� ������ �̸�: "+ name);
		
	}
	
	@RequestMapping("/logout.do")
	public void logout(@RequestParam Map<String, Object> paramMap, ModelMap model,Principal principal) 
			throws Throwable{
  
	}

	
	@RequestMapping("/writeForm.do")
	public void writeForm(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable{

	}
	
	@RequestMapping("/writeProc.do")
	public ModelAndView  writeProc(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable{
		//Form ���� �Ѿ� ���� ��  ���  	paramMap �ȿ� Form ���� �Ѿ� ���� ���� ����	
		System.out.println("id = " + paramMap.get("id"));
		System.out.println("password = " + paramMap.get("pw"));
		System.out.println("name = " + paramMap.get("name"));
		System.out.println("school = " + paramMap.get("school"));
		System.out.println("major = " + paramMap.get("major"));
		//�����ϱ� ���Ͽ� paramMap �� �ѱ��.	
		PreparedStatement pstmt = null;
		Connection con = null;
		con = DBUtil.getConnection();
		pstmt = con.prepareStatement("insert into member(userid,userpwd,name,school,major) values(?,?,?,?,?)");
		pstmt.setString(1, (String) paramMap.get("id"));
		pstmt.setString(2, (String) paramMap.get("pw"));
		pstmt.setString(3, (String) paramMap.get("name"));
		pstmt.setString(4, (String) paramMap.get("school"));
		pstmt.setString(5, (String) paramMap.get("major"));
		pstmt.executeUpdate();
		
		System.out.println("���ο� ȸ�������� ���������� ����Ǿ����ϴ�.");		
		//ó�� �� redirect
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/WEB.html"); //���⼭ �������� �̵���Ű��.
		return mav;
	}
}
