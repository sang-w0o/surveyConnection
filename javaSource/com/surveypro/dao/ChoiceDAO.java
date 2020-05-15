package com.surveypro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.surveypro.controller.DbManager;
import com.surveypro.vo.ChoiceVO;

public class ChoiceDAO {

	public static final String KEY = "ChoiceDAO";

	public ArrayList<ChoiceVO> getChoice(int s_code, int q_number) {
	
		ArrayList<ChoiceVO> list = new ArrayList<>();
		
		String sql = "SELECT s_code, q_number, choice_num, choice_content FROM choices WHERE s_code=? AND q_number=?;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
			pstmt.setInt(2,  q_number);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ChoiceVO c = new ChoiceVO();
				c.setS_code(rs.getInt("s_code"));
				c.setQ_number(rs.getInt("q_number"));
				c.setChoice_num(rs.getInt("choice_num"));
				c.setChoice_content(rs.getString("choice_content"));
				list.add(c);
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
	
	public boolean insert(ChoiceVO choice) {
		boolean result = false;

		int s_code = choice.getS_code();
		int q_number = choice.getQ_number();
		int choice_num = choice.getChoice_num();
		String choice_content = choice.getChoice_content();

		String sql = "INSERT INTO choices VALUES(?,?,?,?);";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
			pstmt.setInt(2,  q_number);
			pstmt.setInt(3,  choice_num);
			pstmt.setString(4, choice_content);
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
