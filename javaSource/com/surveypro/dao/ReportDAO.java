package com.surveypro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.surveypro.controller.DbManager;
import com.surveypro.vo.ReportVO;

public class ReportDAO {
	public static final String KEY = "ReportDAO";

	public static String getReportedWriter(int s_code) {

		String reportedWriter = null;
		String sql = "SELECT email FROM survey WHERE s_code = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				reportedWriter = rs.getString("email");
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
		return reportedWriter;
	}

	public ArrayList<ReportVO> getAllReports() {
		ArrayList<ReportVO> reports = new ArrayList<>();

		String sql = "SELECT * FROM reports WHERE r_type = 'W' AND r_state='N';";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ReportVO r = new ReportVO();
				r.setR_id(rs.getInt("r_id"));
				int s_code = rs.getInt("s_code");
				r.setS_code(s_code);
				r.setReporter(rs.getString("reporter"));
				String reportedWriter = getReportedWriter(s_code);
				r.setReportedWriter(reportedWriter);
				r.setR_type("W");
				r.setR_state("N");
				r.setCause(rs.getString("cause"));
				reports.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
			;
		} finally {
			DbManager.close(rs, stmt);
			DbManager.close(con);
		}
		return reports;
	}

	public boolean approveReport(int s_code) {

		String sql = "UPDATE reports SET r_state='Y' WHERE s_code=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
			result = (pstmt.executeUpdate() > 0);
			setReportSurvey(s_code, con);
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

	public static void setReportSurvey(int s_code, Connection con) throws SQLException {
		String sql = "UPDATE survey SET s_reported = 'Y' WHERE s_code=?";
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, s_code);
		pstmt.execute();
	}

	public boolean removeReport(int s_code) {

		String sql = "DELETE FROM reports WHERE s_code=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
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

	public boolean insert(ReportVO report) {

		String sql = "INSERT INTO reports VALUES(DEFAULT,?,?,?,?,DEFAULT);";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, report.getS_code());
			pstmt.setString(2, report.getReporter());
			pstmt.setString(3, report.getCause());
			pstmt.setString(4, "W");
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

	public boolean checkIfAlreadyExists(ReportVO r) {
		String sql = "SELECT * FROM reports WHERE reporter=? AND s_code=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, r.getReporter());
			pstmt.setInt(2, r.getS_code());
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
