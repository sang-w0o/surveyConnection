package com.surveypro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.surveypro.controller.DbManager;
import com.surveypro.vo.QuestionVO;

public class QuestionDAO {
	
	public static final String KEY = "QuestionDAO";

	public ArrayList<QuestionVO> getQuestion(int s_code) {
	
		ArrayList<QuestionVO> list = new ArrayList<>();
		
		String sql = "SELECT s_code, q_number, q_title, q_type FROM questions WHERE s_code=?;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QuestionVO q = new QuestionVO();
				q.setS_code(rs.getInt("s_code"));
				q.setQ_number(rs.getInt("q_number"));
				q.setQ_title(rs.getString("q_title"));
				q.setQ_type(rs.getString("q_type"));
				list.add(q);
			} 
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (NamingException e) {
			e.printStackTrace();
		} 
		finally {
			DbManager.close(rs);
			DbManager.close(pstmt);
			DbManager.close(con);
		}
		return list;
	}
	
	public int getLastQ_number(int s_code) {
		String sql = "SELECT q_number FROM questions WHERE s_code=? ORDER BY q_number DESC LIMIT 1;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("q_number");
			} 
			else {
				result = 0;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (NamingException e) {
			e.printStackTrace();
		} 
		finally {
			DbManager.close(rs);
			DbManager.close(pstmt);
			DbManager.close(con);
		}
		return result;
	}
	
	public boolean insert(QuestionVO question) {
		boolean result = false;

		int s_code = question.getS_code();
		int q_number = question.getQ_number();
		String q_title = question.getQ_title();
		String q_type = question.getQ_type();

		String sql = "INSERT INTO questions VALUES(?,?,?,?);";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
			pstmt.setInt(2,  q_number);
			pstmt.setString(3,  q_title);
			pstmt.setString(4, q_type);
			result = (pstmt.executeUpdate() > 0);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (NamingException e) {
			e.printStackTrace();
		} 
		finally {
			DbManager.close(pstmt);
			DbManager.close(con);
		}
		return result;
	}
}
