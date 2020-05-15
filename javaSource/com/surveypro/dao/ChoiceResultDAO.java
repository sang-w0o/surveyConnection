package com.surveypro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.surveypro.controller.DbManager;
import com.surveypro.vo.ChoiceResultVO;

public class ChoiceResultDAO {

	public static final String KEY = "ChoiceResultDAO";

	public boolean insert(ChoiceResultVO crv) {

		String sql = "INSERT INTO choiceresults VALUES(?,?,?,?);";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, crv.getS_code());
			pstmt.setInt(2, crv.getQ_number());
			pstmt.setInt(3, crv.getChoice_num());
			pstmt.setString(4, crv.getRespondent());
			result = (pstmt.executeUpdate() > 0);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(pstmt);
			DbManager.close(con);
		}
		return result;
	}
	
	public boolean checkChoiceResult(int s_code, String resp) {
		String sql = "SELECT * FROM choiceresults WHERE s_code=? AND respondent=?;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
			pstmt.setString(2, resp);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
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
