package spring.board.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import spring.board.dao.MainDao;


public class MemberService implements UserDetailsService  {
	
	private MainDao mainDao;
	
	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		//�α��� ���̵�� �н����带 ������ ����.
		String userPwd = mainDao.getUserPwd(username);
		System.out.println(userPwd);
		
		//"ROLE_USER" �� �̸����� ������ �����Ѵ�. 
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>(); 
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
	 
		//�α��� ������ �����Ѵ�
		UserDetails user = new User(username, userPwd, roles);	
		return user;
	}
	
}


