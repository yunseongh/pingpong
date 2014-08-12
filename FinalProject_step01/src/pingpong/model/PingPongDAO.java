package pingpong.model;

import pingpong.model.PingPongBean;
import pingpong.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PingPongDAO {
	
	//¸â¹öÃß°¡
	public static boolean CreateMember(PingPongBean vo){
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		String sql = "INSERT INTO MEMBER(EMAIL,NAME,PASSWORD,SCHOOL,MAJOR) VALUES (?,?,?,?,?)";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);

	        pstmt.setString(1,vo.getEmail());
	        pstmt.setString(2,vo.getName());
	        pstmt.setString(3, vo.getPassword());
	        pstmt.setString(4, vo.getSchool());
	        pstmt.setString(5, vo.getMajor());
	        
			int count = pstmt.executeUpdate();			
			if(count != 0){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(con, pstmt);
		}
		return result;		
	}
	
	//¸â¹ö ¾ò±â
	public static PingPongBean GetMember(String Email){		
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		PingPongBean vo  = null;
		
		String sql="SELECT EMAIL,NAME,PASSWORD,SCHOOL,MAJOR FROM MEMBER WHERE EMAIL = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Email);	
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				vo = new PingPongBean(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),rset.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(con, pstmt);
		}
		return vo;
	}
	
	//¸â¹ö Á¤º¸ º¯°æ
	public static boolean UpdateMember(PingPongBean vo){		
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		String sql = "UPDATE	MEMBER SET	 SCHOOL = ?, MAJOR = ? WHERE EMAIL = ?";		

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getSchool());
			pstmt.setString(2, vo.getMajor());
			pstmt.setString(3, vo.getEmail());
			
			int count = pstmt.executeUpdate();
			if(count != 0){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(con, pstmt);
		}
		return result;	
	}
	
	//¸â¹ö »èÁ¦ÇÏ±â
	public  static boolean deleteMember(String Email){
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		String sql="DELETE FROM MEMBER WHERE EMAIL = ?;";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);

	        pstmt.setString(1,Email);

			int count = pstmt.executeUpdate();
			
			if(count != 0){
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	public  static ArrayList<PingPongBean> GetAllMember(){
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//PingPongBean[] list  = null;
		ArrayList<PingPongBean> alist = new ArrayList<PingPongBean>();
		
		String sql="SELECT EMAIL,NAME,PASSWORD,SCHOOL,MAJOR FROM MEMBER";	
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()){
				alist.add(new PingPongBean(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5)));
			}
			//list = new PingPongBean[alist.size()];
			//alist.toArray(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return alist;
	}
	
	
}
