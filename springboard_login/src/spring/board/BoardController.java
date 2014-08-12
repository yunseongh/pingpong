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
		
		//로그인 후 로그인 한 아이디를  가지고 온다.
		String name = principal.getName();
		
		model.addAttribute("username", name);
		System.out.println("로그인에서 나오는 이름: "+ name);
		
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
		//Form 에서 넘어 오는 값  찍기  	paramMap 안에 Form 에서 넘어 오는 값이 있음	
		System.out.println("id = " + paramMap.get("id"));
		System.out.println("password = " + paramMap.get("pw"));
		System.out.println("name = " + paramMap.get("name"));
		System.out.println("school = " + paramMap.get("school"));
		System.out.println("major = " + paramMap.get("major"));
		//저장하기 위하여 paramMap 을 넘긴다.	
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
		
		System.out.println("새로운 회원정보가 성공적으로 저장되었습니다.");		
		//처리 후 redirect
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/WEB.html"); //여기서 메인으로 이동시키기.
		return mav;
	}
}
