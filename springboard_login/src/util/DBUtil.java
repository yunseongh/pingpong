package util;

import java.sql.*;

public class DBUtil{
	
	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
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
				con.close();
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
				con.close();
				con = null;
			}
		}catch(SQLException s){
			s.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try{		
			if(stmt != null){
				stmt.close();
				stmt = null;
			}
		}catch(SQLException s){
			s.printStackTrace();
		}
	}
}