package com.surveypro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.surveypro.controller.DbManager;
import com.surveypro.vo.SubjectiveResultVO;

public class SubjectiveResultDAO {
	public static final String KEY = "SubjectiveResultDAO";

	public boolean insert(SubjectiveResultVO svr) {

		String sql = "INSERT INTO subjectiveresults VALUES(?,?,?,?);";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, svr.getS_code());
			pstmt.setInt(2, svr.getQ_number());
			pstmt.setString(3, svr.getRespondent());
			pstmt.setString(4, svr.getAnswer());
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
	
	public boolean checkSubjectiveResult(int s_code, String resp) {
		String sql = "SELECT * FROM subjectiveresults WHERE s_code=? AND respondent=?;";
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
