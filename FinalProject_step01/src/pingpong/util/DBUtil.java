package pingpong.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
private static DataSource source = null;	
	
	//DataSource 초기화
	static {
		try {
			Context initContext = new InitialContext();		
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			source = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//DataSource로 부터 Connection 객체 획득후 반환
	public static Connection getConnection() throws SQLException {
		return source.getConnection();
	}
	
	public static void close(Connection con, Statement stmt, ResultSet rset){
		try{
			if(rset != null){
				rset.close();
				rset = null;
			}
			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(con != null){
				con.close();//삭제가 아닌 Connection pool메모리로 반환되는 원리
				con = null;
			}
		}catch(SQLException s){
			s.printStackTrace();
		}
	}
	
	public static void close(Connection con, Statement stmt){
		try{
			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(con != null){
				con.close();//삭제가 아닌 Connection pool메모리로 반환되는 원리
				con = null;
			}
		}catch(SQLException s){
			s.printStackTrace();
		}
	}


}
