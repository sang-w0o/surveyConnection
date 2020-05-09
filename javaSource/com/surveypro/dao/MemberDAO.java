package com.surveypro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.surveypro.controller.DbManager;
import com.surveypro.vo.MemberVO;

public class MemberDAO {

	public static final String KEY = "MemberDAO";

	public MemberDAO() {
	}

	public boolean insert(MemberVO member) {

		String sql = "INSERT INTO members VALUES(?,PASSWORD(?),?,DEFAULT,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getNick());
			pstmt.setString(4, "IRON");
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

	public boolean checkEmail(String email) {
		String sql = "SELECT * FROM members WHERE email=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = true;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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

	public boolean checkNick(String nick) {
		String sql = "SELECT * FROM members WHERE nick=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = true;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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

	public boolean checkPassword(String email, String pass) {
		String sql = "SELECT * FROM members WHERE email=? AND pass=PASSWORD(?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
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

	public boolean checkWithdrawed(String email) {
		String sql = "SELECT * FROM withdrawed WHERE email=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = true;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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

	public MemberVO getMember(String email, String pass) {
		String sql = "SELECT * FROM members WHERE email=? AND pass=PASSWORD(?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO m = null;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new MemberVO();
				m.setEmail(rs.getString("email"));
				m.setNick(rs.getString("nick"));
				m.setG_name(rs.getString("g_name"));
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
		return m;
	}

	public int getPoint(String email) {
		int point = 0;
		String sql = "SELECT SUM(B.pointchange) AS point" + " FROM members AS A NATURAL JOIN pointhistory AS B"
				+ " WHERE A.email = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				point = rs.getInt("point");
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
		return point;
	}

	public boolean updatePassword(String email, String pass) {
		boolean result = false;
		String sql = "UPDATE members SET pass=PASSWORD(?) WHERE email=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, email);
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
