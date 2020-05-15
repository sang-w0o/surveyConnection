package com.surveypro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.surveypro.controller.DbManager;
import com.surveypro.vo.InterestVO;

public class InterestDAO {

	public static final String KEY = "InterestDAO";

	public boolean insert(InterestVO i) {

		String sql = "INSERT INTO interests VALUES(?,?);";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, i.getEmail());
			pstmt.setInt(2, i.getS_code());
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

	public boolean checkIfAlreadyExists(InterestVO i) {
		String sql = "SELECT * FROM interests WHERE email=? AND s_code=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, i.getEmail());
			pstmt.setInt(2, i.getS_code());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(rs, pstmt);
			DbManager.close(con);
		}
		return result;
	}
}
