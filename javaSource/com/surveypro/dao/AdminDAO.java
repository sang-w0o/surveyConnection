package com.surveypro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.NamingException;

import com.surveypro.controller.DbManager;
import com.surveypro.vo.AdminVO;

public class AdminDAO {

	public static final String KEY = "AdminDAO";

	public static ArrayList<AdminVO> getAllMembers() {

		String sql = "SELECT email FROM members;";
		ArrayList<AdminVO> members = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String email = rs.getString(1);
				AdminVO a = new AdminVO();
				a.setEmail(email);
				members.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(rs, stmt);
			DbManager.close(con);
		}
		return members;
	}

	public static String getGrade(String email) {

		String sql = "SELECT g_name FROM members WHERE email=?;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String grade = null;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				grade = rs.getString(1);
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
		return grade;
	}

	public static void setGrade(String email, String g_name) {

		String sql = "UPDATE members SET g_name=? WHERE email=?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, g_name);
			pstmt.setString(2, email);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(pstmt);
			DbManager.close(con);
		}
	}

	public static void setGradeDown(String email) {

		String current_grade = getGrade(email);
		String new_grade = null;

		switch (current_grade) {
		case "IRON":
			new_grade = "IRON";
			break;
		case "BRONZE":
			new_grade = "IRON";
			break;
		case "SILVER":
			new_grade = "BRONZE";
			break;
		case "GOLD":
			new_grade = "SILVER";
			break;
		}

		String sql = "UPDATE members SET g_name=? WHERE email=?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, new_grade);
			pstmt.setString(2, email);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(pstmt);
			DbManager.close(con);
		}
	}

	public static int getGradeCondition(String g_name) {
		int g_cond = 0;
		String sql = "SELECT g_cond FROM grades WHERE g_name=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, g_name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				g_cond = rs.getInt(1);
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
		return g_cond;

	}

	public static ArrayList<Integer> getAllReportS_code() {

		ArrayList<Integer> codes = new ArrayList<>();
		String sql = "SELECT s_code FROM reports WHERE r_state='Y'";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int s_code = rs.getInt(1);
				codes.add(s_code);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(rs, stmt);
			DbManager.close(con);
		}
		return codes;
	}

	public static ArrayList<String> getReportedWriters(ArrayList<Integer> codes) {

		if (codes == null) {
			return null;
		}

		ArrayList<String> reportedWriters = new ArrayList<>();
		Iterator<Integer> it = codes.iterator();
		String sql = "SELECT email FROM survey WHERE s_code = ?";

		while (it.hasNext()) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DbManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, it.next());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					String rw = rs.getString(1);
					reportedWriters.add(rw);
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
		}
		return reportedWriters;
	}

	public static int getPointToAdd(String g_name) {
		int g_point = 0;
		String sql = "SELECT g_point FROM grades WHERE g_name=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, g_name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				g_point = rs.getInt(1);
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
		return g_point;
	}

	public static boolean addPoint(String email, int addPoint) {
		String sql = "INSERT INTO pointhistory VALUES(DEFAULT,?,227,?,'A');";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, addPoint);
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

	public static boolean setReportedCounts(ArrayList<AdminVO> members, ArrayList<String> reportedWriters) {

		if ((members == null) || (reportedWriters == null)) {
			return false;
		}

		for (int i = 0; i < members.size(); i++) {
			for (int j = 0; j < reportedWriters.size(); j++) {
				if (members.get(i).getEmail().equals(reportedWriters.get(j))) {
					members.get(i).addReportedCount();
				}
			}
		}
		return true;
	}

	public static boolean getParticipatedCounts(ArrayList<AdminVO> members) {

		boolean result = false;

		if (members == null) {
			return result;
		}

		String sql = "SELECT COUNT(*) AS CNT FROM pointhistory WHERE email=? AND ph_type='P';";
		Iterator<AdminVO> it = members.iterator();
		while (it.hasNext()) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			AdminVO a = it.next();
			try {
				con = DbManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, a.getEmail());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					int pCount = rs.getInt("CNT");
					a.setParticipated_count(pCount);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				result = false;
			} catch (NamingException e) {
				e.printStackTrace();
				result = false;
			} finally {
				DbManager.close(rs);
				DbManager.close(pstmt);
				DbManager.close(con);
			}
		}
		return true;
	}

	public static boolean removeAllReports() {
		boolean result = false;
		String sql = "DELETE FROM reports";
		Connection con = null;
		Statement stmt = null;

		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			result = (stmt.executeUpdate(sql) > 0);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(stmt);
			DbManager.close(con);
		}
		return result;
	}

	public boolean updateAllMembers() {

		boolean result = true;

		ArrayList<AdminVO> members = getAllMembers();
		if (members == null) {
			return false;
		}
		ArrayList<Integer> codes = getAllReportS_code();
		if (codes == null) {
			return false;
		}
		ArrayList<String> reportedWriters = getReportedWriters(codes);
		if (reportedWriters == null) {
			return false;
		}
		if (setReportedCounts(members, reportedWriters)) {
			if (getParticipatedCounts(members)) {
				Iterator<AdminVO> it = members.iterator();
				while (it.hasNext()) {
					AdminVO member = it.next();
					int pCount = member.getParticipated_count();
					if (pCount < 10) {
						setGrade(member.getEmail(), "IRON");
					} else if (pCount < 20) {
						setGrade(member.getEmail(), "BRONZE");
					} else if (pCount < 30) {
						setGrade(member.getEmail(), "SILVER");
					} else {
						setGrade(member.getEmail(), "GOLD");
					}
					if (member.getReported_count() >= 4) {
						setGradeDown(member.getEmail());
					}

					int addPoint = getPointToAdd(getGrade(member.getEmail()));
					if (addPoint(member.getEmail(), addPoint)) {
						result = true;
					} else {
						return false;
					}
				}
			}
		}
		if (removeAllReports()) {
			return true;
		}
		return result;
	}

}
