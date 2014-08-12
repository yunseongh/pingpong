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
	
	//DataSource �ʱ�ȭ
	static {
		try {
			Context initContext = new InitialContext();		
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			source = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//DataSource�� ���� Connection ��ü ȹ���� ��ȯ
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
				con.close();//������ �ƴ� Connection pool�޸𸮷� ��ȯ�Ǵ� ����
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
				con.close();//������ �ƴ� Connection pool�޸𸮷� ��ȯ�Ǵ� ����
				con = null;
			}
		}catch(SQLException s){
			s.printStackTrace();
		}
	}


}
