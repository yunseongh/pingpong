package spring.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public  class MainDaoImpl extends SqlSessionDaoSupport implements MainDao {

	public int writeProc(Map<String, Object> paramMap) {
		return getSqlSession().insert("main.writeProc",paramMap );
	}
	
	public String getUserPwd(String userid) {
		return (String)getSqlSession().selectOne("main.getUserPwd",userid);
	}
	
}


