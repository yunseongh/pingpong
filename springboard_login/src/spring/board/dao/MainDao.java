package spring.board.dao;

import java.util.List;
import java.util.Map;


public interface MainDao  {
	
	public int writeProc(Map<String, Object> paramMap);
	
	public String getUserPwd(String userid);
	
}
