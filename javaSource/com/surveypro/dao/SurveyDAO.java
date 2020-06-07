package com.surveypro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.surveypro.controller.DbManager;
import com.surveypro.vo.SurveyVO;

public class SurveyDAO {

	public static final String KEY = "SurveyDAO";

	public SurveyDAO() {
	}

	public SurveyVO getSurvey(int s_code) {
		String sql = "SELECT s_code, s_title, email, c_code FROM survey WHERE s_code=? AND s_reported != 'Y';";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SurveyVO survey = new SurveyVO();

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				survey.setS_code(rs.getInt("s_code"));
				survey.setS_title(rs.getString("s_title"));
				survey.setEmail(rs.getString("email"));
				survey.setC_code(rs.getString("c_code"));
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
		return survey;
	}

	public SurveyVO getHisSurvey(int s_code) {
		String sql = "SELECT s_code, s_title, email, c_code FROM survey WHERE s_code=?;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SurveyVO survey = new SurveyVO();

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				survey.setS_code(rs.getInt("s_code"));
				survey.setS_title(rs.getString("s_title"));
				survey.setEmail(rs.getString("email"));
				survey.setC_code(rs.getString("c_code"));
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
		return survey;
	}

	public int getLastS_code() {
		String sql = "SELECT s_code FROM survey WHERE s_reported != 'Y' ORDER BY s_code DESC LIMIT 1;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("s_code");
			} else {
				result = 0;
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

	public int getLastS_id(String email) {
		String sql = "SELECT s_id FROM survey WHERE email=? AND s_reported != 'Y' ORDER BY s_code DESC LIMIT 1;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("s_id");
			} else {
				result = 0;
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

	public boolean insert(SurveyVO survey, int insertID) {
		boolean result = false;

		String email = survey.getEmail();
		String s_title = survey.getS_title();
		String c_code = survey.getC_code();
		String s_public = survey.getS_public();

		String sql = "INSERT INTO survey VALUES(DEFAULT,?,?,?,?,DEFAULT, DEFAULT, ?, DEFAULT);";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, insertID);
			pstmt.setString(3, c_code);
			pstmt.setString(4, s_public);
			pstmt.setString(5, s_title);
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

	public ArrayList<SurveyVO> getByEmail(String email) {
		ArrayList<SurveyVO> list = new ArrayList<>();
		String sql = "SELECT * FROM survey WHERE s_reported != 'Y' AND email =" + email;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SurveyVO s = null;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				s = new SurveyVO();
				s.setS_code(rs.getInt("s_code"));
				s.setEmail(rs.getString("email"));
				s.setS_id(rs.getInt("s_id"));
				s.setC_code(rs.getString("c_code"));
				s.setS_public(rs.getString("s_public"));
				s.setPrice(rs.getInt("price"));
				s.setWritten_date(rs.getString("written_date"));
				s.setS_title(rs.getString("s_title"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(pstmt);
			DbManager.close(con);
		}
		return list;
	}

	public boolean isPublic(int s_code) {
		String sql = "SELECT * FROM survey WHERE s_reported != 'Y' AND s_code = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
			rs = pstmt.executeQuery();
			result = rs.getString("s_public");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(pstmt);
			DbManager.close(con);
		}
		return (result == "Y" ? true : false);
	}

	public int getSample(int s_code) {
		String sql = "SELECT count(*) AS num FROM pointhistory WHERE s_code =" + s_code
				+ " AND pointchange = 5 AND ph_type='P'";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int num = -1;
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				num = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(stmt);
			DbManager.close(con);
		}
		return num;
	}

	public static int getInterestCount(int s_code) {
		String sql = "SELECT COUNT(*) AS cnt FROM interests WHERE s_code=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int interestCnt = 0;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				interestCnt = rs.getInt("cnt");
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
		return interestCnt;
	}

	public boolean updatePrice(int s_code) {

		int sampleNum = this.getSample(s_code);
		int interestCnt = getInterestCount(s_code);
		int finalPrice = interestCnt + sampleNum * 2;

		String sql = "UPDATE survey SET price=? WHERE s_reported != 'Y' AND s_code=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, finalPrice);
			pstmt.setInt(2, s_code);
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

	public boolean isWriterOfSurvey(int s_code, String respondent) {
		String sql = "SELECT email FROM survey WHERE s_code=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String writer = null;
		boolean result = false;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				writer = rs.getString("email");
				if (writer.equals(respondent)) {
					result = true;
				} else {
					result = false;
				}
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

	public static int getParticipateCount(String email) {

		int pCount = 0;
		String sql = "SELECT COUNT(*) AS CNT FROM pointhistory WHERE email=? AND ph_type='P'";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pCount = rs.getInt("CNT");
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
		return pCount;
	}

	public static int getWriteCount(String email) {

		int wCount = 0;
		String sql = "SELECT COUNT(*) AS CNT FROM survey WHERE email=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				wCount = rs.getInt("CNT");
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
		return wCount;
	}

	public boolean isRegisterable(String email) {

		int wCount = getWriteCount(email);
		int pCount = getParticipateCount(email);

		boolean result = (((pCount / 2) - wCount) > -1);
		return result;
	}
}
