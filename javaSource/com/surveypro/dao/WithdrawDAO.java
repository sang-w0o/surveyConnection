package com.surveypro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.surveypro.controller.DbManager;

public class WithdrawDAO {

	public static final String KEY = "WithdrawDAO";

	public WithdrawDAO() {
	}

	public boolean insert(String email) {

		String sql = "INSERT INTO withdrawed VALUES(?, DEFAULT)";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
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

	public boolean isRegisterable(String email) {
		String sql = "SELECT DATE_ADD((SELECT withdraw_date FROM withdrawed WHERE email=?), INTERVAL 30 DAY) < NOW() AS RES;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int isOK;
		boolean result = false;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				isOK = rs.getInt("RES");
				if (isOK == 0) {
					result = false;
				} else {
					result = true;
				}
			} else {
				result = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(rs);
			DbManager.close(pstmt);
			DbManager.close(con);
		}
		return result;
	}

	public boolean isWithdrawed(String email) {
		String sql = "SELECT * FROM withdrawed WHERE email=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(rs);
			DbManager.close(pstmt);
			DbManager.close(con);
		}
		return result;
	}

	public boolean delete(String email) {
		String sql = "DELETE FROM withdrawed WHERE email=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
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
}
