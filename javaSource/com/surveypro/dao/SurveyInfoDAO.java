package com.surveypro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.surveypro.controller.DbManager;
import com.surveypro.vo.SurveyInfoVO;

public class SurveyInfoDAO {

	public static final String KEY = "SurveyInfoDAO";

	public SurveyInfoDAO() {
	}

	public ArrayList<SurveyInfoVO> getSurveyInfoByDeadLine() {

		ArrayList<SurveyInfoVO> list = new ArrayList<>();

		String sql = "SELECT \r\n" + "		nick writer, \r\n" + "		s_title, \r\n" + "		interest_count, \r\n"
				+ "		DATE(writtendate) written_date, \r\n" + "		DATE(end_date) end_date,\r\n"
				+ "		sub1.s_code s_code\r\n" + "FROM (SELECT \r\n" + "				A.s_code, \r\n"
				+ "				C.nick, \r\n" + "				A.s_title, \r\n" + "				A.writtendate, \r\n"
				+ "				A.s_reported, \r\n"
				+ "				DATE_ADD(A.writtendate, INTERVAL D.g_deadLine DAY) end_date,\r\n"
				+ "				A.s_public,\r\n" + "				D.g_sample_num, \r\n"
				+ "				D.g_deadline\r\n" + "		FROM survey A, members C, grades D \r\n"
				+ "		WHERE A.email = C.email AND C.g_name = D.g_name) sub1 \r\n" + "		LEFT JOIN \r\n"
				+ "	  (SELECT \r\n" + "	  			s_code, \r\n" + "				COUNT(s_code) interest_count \r\n"
				+ "		FROM interests \r\n" + "		GROUP BY s_code) sub2 \r\n"
				+ "	   ON (sub1.s_code = sub2.s_code)\r\n" + "	   	LEFT JOIN\r\n" + "		(SELECT \r\n"
				+ "			s_code, COUNT(s_code) sample_num\r\n" + "		FROM\r\n" + "			pointhistory\r\n"
				+ "		WHERE ph_type='P'\r\n" + "		GROUP BY\r\n"
				+ "			s_code) sub3 ON (sub1.s_code = sub3.s_code)\r\n" + "WHERE\r\n"
				+ "	sub1.s_reported != 'Y'\r\n" + "	AND g_sample_num - IFNULL(sample_num, 0) != 0 \r\n"
				+ "	AND DATE(DATE_ADD(sub1.writtendate, INTERVAL sub1.g_deadLine DAY)) > DATE(NOW())\r\n"
				+ "ORDER BY\r\n" + "	TIMESTAMPDIFF(DAY, NOW(), end_date) ASC\r\n" + "LIMIT \r\n" + "	10;";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SurveyInfoVO s = new SurveyInfoVO();
				s.setS_code(rs.getInt("s_code"));
				s.setWriter(rs.getString("writer"));
				s.setS_title(rs.getString("s_title"));
				s.setInterest_count(rs.getInt("interest_count"));
				s.setWritten_date(rs.getString("written_date"));
				s.setEnd_date(rs.getString("end_date"));
				list.add(s);
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

		return list;
	}

	public ArrayList<SurveyInfoVO> getSurveyInfoBySpareSampleNum() {
		ArrayList<SurveyInfoVO> list = new ArrayList<>();

		String sql = "SELECT\r\n" + "		sub1.s_code s_code,\r\n" + "		nick writer, \r\n"
				+ "		s_title, \r\n" + "		interest_count, \r\n" + "		DATE(end_date) end_date,\r\n"
				+ "		CAST(g_sample_num - IFNULL(sample_num, 0) AS SIGNED INTEGER) spare_sample_num\r\n"
				+ "FROM (SELECT \r\n" + "				A.s_code, \r\n" + "				C.nick, \r\n"
				+ "				A.s_title, \r\n" + "				A.writtendate,\r\n"
				+ "				A.s_reported,\r\n"
				+ "				DATE_ADD(A.writtendate, INTERVAL D.g_deadLine DAY) end_date,\r\n"
				+ "				D.g_sample_num,\r\n" + "				A.s_public,\r\n"
				+ "				D.g_deadline\r\n" + "		FROM survey A, members C, grades D \r\n"
				+ "		WHERE A.email = C.email AND C.g_name = D.g_name) sub1 \r\n" + "		LEFT JOIN \r\n"
				+ "	  (SELECT \r\n" + "	  			s_code, \r\n" + "				COUNT(s_code) interest_count\r\n"
				+ "		FROM interests \r\n" + "		GROUP BY s_code) sub2 ON (sub1.s_code = sub2.s_code)\r\n"
				+ "		LEFT JOIN\r\n" + "		(SELECT \r\n" + "			s_code, COUNT(s_code) sample_num\r\n"
				+ "		FROM\r\n" + "			pointhistory\r\n" + "		WHERE ph_type='P'\r\n"
				+ "		GROUP BY\r\n" + "			s_code) sub3 ON (sub1.s_code = sub3.s_code)\r\n" + "WHERE\r\n"
				+ "	sub1.s_reported != 'Y'\r\n" + "	AND g_sample_num - IFNULL(sample_num, 0) != 0\r\n"
				+ "	AND DATE(DATE_ADD(sub1.writtendate, INTERVAL sub1.g_deadLine DAY)) > DATE(NOW())\r\n"
				+ "ORDER BY\r\n" + "	g_sample_num - IFNULL(sample_num, 0)\r\n" + "LIMIT\r\n" + "	10;";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SurveyInfoVO s = new SurveyInfoVO();
				s.setS_code(rs.getInt("s_code"));
				s.setWriter(rs.getString("writer"));
				s.setS_title(rs.getString("s_title"));
				s.setInterest_count(rs.getInt("interest_count"));
				s.setEnd_date(rs.getString("end_date"));
				s.setSpare_sample_num(rs.getString("spare_sample_num"));
				list.add(s);
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

		return list;
	}

	public ArrayList<SurveyInfoVO> getSurveyInfoByEndSurvey() {
		ArrayList<SurveyInfoVO> list = new ArrayList<>();

		String sql = "SELECT\r\n" + "		sub1.s_code s_code,\r\n" + "		nick writer, \r\n"
				+ "		s_title, \r\n" + "		interest_count, \r\n" + "		DATE(end_date) end_date,\r\n"
				+ "		((IFNULL(sample_num, 0) * 2) + interest_count) price\r\n" + "FROM (SELECT \r\n"
				+ "				A.s_code, \r\n" + "				C.nick, \r\n" + "				A.s_title, \r\n"
				+ "				A.writtendate,\r\n" + "				A.s_reported,\r\n"
				+ "				D.g_sample_num,\r\n"
				+ "				DATE_ADD(A.writtendate, INTERVAL D.g_deadLine DAY) end_date,\r\n"
				+ "				A.s_public\r\n" + "		FROM survey A, members C, grades D \r\n"
				+ "		WHERE A.email = C.email AND C.g_name = D.g_name) sub1 \r\n" + "		LEFT JOIN \r\n"
				+ "	  (SELECT \r\n" + "	  			s_code, \r\n" + "				COUNT(s_code) interest_count\r\n"
				+ "		FROM interests \r\n" + "		GROUP BY s_code) sub2 ON (sub1.s_code = sub2.s_code)\r\n"
				+ "		LEFT JOIN\r\n" + "		(SELECT \r\n" + "			s_code, COUNT(s_code) sample_num\r\n"
				+ "		FROM\r\n" + "			pointhistory\r\n" + "		WHERE ph_type='P'\r\n"
				+ "		GROUP BY\r\n" + "			s_code) sub3 ON (sub1.s_code = sub3.s_code)\r\n" + "WHERE \r\n"
				+ "		sub1.s_reported != 'Y'\r\n" + "		AND sub1.s_public = 'Y'\r\n"
				+ "		AND (g_sample_num - IFNULL(sample_num, 0) = 0\r\n"
				+ "		OR DATE(NOW()) >= DATE(end_date))\r\n" + "ORDER BY\r\n"
				+ "	TIMESTAMPDIFF(DAY, NOW(), end_date) DESC\r\n" + "LIMIT\r\n" + "	10;";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SurveyInfoVO s = new SurveyInfoVO();
				s.setS_code(rs.getInt("s_code"));
				s.setWriter(rs.getString("writer"));
				s.setS_title(rs.getString("s_title"));
				s.setInterest_count(rs.getInt("interest_count"));
				s.setEnd_date(rs.getString("end_date"));
				s.setPrice(rs.getInt("price"));
				list.add(s);
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

		return list;
	}

	public ArrayList<SurveyInfoVO> getClosedSurveyList() {

		ArrayList<SurveyInfoVO> endSurveys = new ArrayList<>();

		String sql = "SELECT\r\n" + "	   sub1.s_code s_code,\r\n" + "		nick writer,\r\n" + "		email,\r\n"
				+ "		s_title, \r\n" + "		sub4.c_desc,\r\n"
				+ "		CAST(g_sample_num - IFNULL(sample_num, 0) AS SIGNED INTEGER) spare_sample_num,\r\n"
				+ "		((IFNULL(sample_num, 0) * 2) + interest_count) price\r\n" + "FROM (SELECT \r\n"
				+ "				A.s_code, \r\n" + "				A.email,\r\n" + "				C.nick, \r\n"
				+ "				A.s_title, \r\n" + "				A.writtendate,\r\n" + "				A.c_code,\r\n"
				+ "				DATE_ADD(A.writtendate, INTERVAL D.g_deadLine DAY) end_date,\r\n"
				+ "				D.g_sample_num,\r\n" + "				A.s_public,\r\n"
				+ "				D.g_deadline,\r\n" + " A.s_reported		FROM survey A, members C, grades D \r\n"
				+ "		WHERE A.email = C.email AND C.g_name = D.g_name) sub1 \r\n" + "		LEFT JOIN\r\n"
				+ "	   (SELECT \r\n" + "	  			s_code, \r\n"
				+ "				COUNT(s_code) interest_count\r\n" + "		FROM interests \r\n"
				+ "		GROUP BY s_code) sub2 ON (sub1.s_code = sub2.s_code)\r\n" + "		LEFT JOIN\r\n"
				+ "		(SELECT \r\n" + "			s_code, \r\n" + "			COUNT(s_code) sample_num\r\n"
				+ "		FROM pointhistory\r\n" + "		WHERE ph_type='P'\r\n"
				+ "		GROUP BY s_code) sub3 ON (sub1.s_code = sub3.s_code)\r\n" + "		LEFT JOIN\r\n"
				+ "		(SELECT\r\n" + "			c_code,\r\n" + "			c_desc\r\n"
				+ "		FROM categories) sub4 ON (sub1.c_code = sub4.c_code)\r\n" + "WHERE\r\n"
				+ "		sub1.s_public = 'Y' \r\n" + "		AND (g_sample_num - IFNULL(sample_num, 0) = 0\r\n"
				+ "		OR DATE(NOW()) >= DATE(end_date)) AND sub1.s_reported = 'N'";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				SurveyInfoVO s = new SurveyInfoVO();
				s.setS_code(rs.getInt("s_code"));
				s.setWriter(rs.getString("writer"));
				s.setS_title(rs.getString("s_title"));
				s.setC_desc(rs.getString("c_desc"));
				s.setSpare_sample_num(rs.getString("spare_sample_num"));
				s.setPrice(rs.getInt("price"));
				s.setEmail(rs.getString("email"));
				endSurveys.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(rs, stmt);
			DbManager.close(con);
		}
		return endSurveys;

	}

	public int getTotalCountByCategory(String c_code) {
		String sql = "SELECT \r\n" + "	COUNT(*)\r\n" + "FROM (SELECT \r\n" + "			A.s_code, \r\n"
				+ "			A.writtendate, \r\n" + "			A.s_reported,\r\n" + "			C.g_deadline,\r\n"
				+ "			C.g_sample_num,\r\n"
				+ "			DATE_ADD(A.writtendate, INTERVAL C.g_deadLine DAY) end_date\r\n"
				+ "		FROM survey A, members B, grades C \r\n"
				+ "		WHERE A.email = B.email AND A.c_code=? AND B.g_name = C.g_name) sub1 \r\n"
				+ "		LEFT JOIN \r\n" + "		(SELECT s_code, COUNT(s_code) interest_count \r\n"
				+ "		FROM interests \r\n" + "		GROUP BY s_code) sub2 ON(sub1.s_code = sub2.s_code) \r\n"
				+ "			LEFT JOIN\r\n" + "		(SELECT s_code, COUNT(s_code) sample_num\r\n"
				+ "		FROM pointhistory\r\n" + "		WHERE ph_type='P'\r\n"
				+ "		GROUP BY s_code) sub3 ON (sub1.s_code = sub3.s_code)\r\n" + "WHERE\r\n"
				+ "		sub1.s_reported != 'Y'\r\n" + "		AND g_sample_num - IFNULL(sample_num, 0) != 0 \r\n"
				+ "		AND DATE(DATE_ADD(sub1.writtendate, INTERVAL sub1.g_deadLine DAY)) > DATE(NOW())";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rowCount = 0;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
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
		return rowCount;
	}

	public ArrayList<SurveyInfoVO> getSurveyByCategory(int page, int pageSize, String c_code) {
		String sql = "SELECT \r\n" + "	sub1.s_code s_code, \r\n" + "	nick writer,\r\n" + "	s_title,  \r\n"
				+ "	CAST(writtendate AS DATE) written_date,\r\n" + "	interest_count\r\n" + "FROM (SELECT  \r\n"
				+ "			A.s_code,  \r\n" + "			B.nick,  \r\n" + "			A.s_title, \r\n"
				+ "			A.writtendate,  \r\n" + "			A.s_reported,  \r\n" + "			A.s_id,\r\n"
				+ "			C.g_deadline,\r\n" + "			C.g_sample_num,\r\n"
				+ "			DATE_ADD(A.writtendate, INTERVAL C.g_deadLine DAY) end_date	\r\n"
				+ "		FROM survey A, members B, grades C \r\n"
				+ "		WHERE A.email = B.email AND A.c_code=? AND B.g_name = C.g_name) sub1\r\n"
				+ "		LEFT JOIN \r\n" + "		(SELECT s_code, \r\n"
				+ "				COUNT(s_code) interest_count \r\n" + "		FROM interests \r\n"
				+ "		GROUP BY s_code) sub2 ON(sub1.s_code = sub2.s_code) \r\n" + "			LEFT JOIN\r\n"
				+ "		(SELECT  \r\n" + "			s_code, COUNT(s_code) sample_num\r\n" + "		FROM\r\n"
				+ "			pointhistory\r\n" + "		WHERE ph_type='P'\r\n" + "		GROUP BY\r\n"
				+ "			s_code) sub3 ON (sub1.s_code = sub3.s_code)\r\n" + "WHERE\r\n"
				+ "		sub1.s_reported != 'Y'\r\n" + "		AND g_sample_num - IFNULL(sample_num, 0) != 0 \r\n"
				+ "		AND DATE(DATE_ADD(sub1.writtendate, INTERVAL sub1.g_deadLine DAY)) > DATE(NOW()) \r\n"
				+ "ORDER BY\r\n" + "		TIMESTAMPDIFF(DAY, NOW(), end_date) ASC\r\n";

		int startPos = ((page - 1) * pageSize < 0) ? 0 : (page - 1) * pageSize;
		sql += "LIMIT " + startPos + ", " + pageSize + " ";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SurveyInfoVO> surveys = new ArrayList<>();

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SurveyInfoVO s = new SurveyInfoVO();
				s.setS_code(rs.getInt("s_code"));
				s.setS_title(rs.getString("s_title"));
				s.setWriter(rs.getString("writer"));
				s.setWritten_date(rs.getString("written_date"));
				s.setInterest_count((rs.getString("interest_count") == null) ? 0 : rs.getInt("interest_count"));
				surveys.add(s);
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
		return surveys;
	}

	public int getTotalCountByMySurvey(String email) {
		String sql = "SELECT\r\n" + "		COUNT(*)\r\n" + "FROM (SELECT  \r\n" + "		 A.s_code, \r\n"
				+ "		 A.email, \r\n" + "		 A.writtendate, \r\n" + "		 A.s_reported, \r\n"
				+ "		 DATE_ADD(A.writtendate, INTERVAL D.g_deadLine DAY) end_date,\r\n"
				+ "		 D.g_sample_num, \r\n" + "		 D.g_deadline \r\n"
				+ "		FROM survey A, members C, grades D \r\n"
				+ "		WHERE A.email = C.email AND C.g_name = D.g_name) sub1 \r\n" + "		LEFT JOIN \r\n"
				+ "	  (SELECT  \r\n" + "	  			s_code\r\n" + "		FROM interests \r\n"
				+ "		GROUP BY s_code) sub2 \r\n" + "	   ON (sub1.s_code = sub2.s_code)\r\n" + "	   	LEFT JOIN\r\n"
				+ "		(SELECT \r\n" + "			s_code, COUNT(s_code) sample_num\r\n" + "		FROM\r\n"
				+ "			pointhistory\r\n" + "		WHERE ph_type='P'\r\n" + "		GROUP BY\r\n"
				+ "			s_code) sub3 ON (sub1.s_code = sub3.s_code)\r\n" + "WHERE\r\n"
				+ "	sub1.s_reported != 'Y'\r\n" + "	AND g_sample_num - IFNULL(sample_num, 0) != 0 \r\n"
				+ "	AND DATE(DATE_ADD(sub1.writtendate, INTERVAL sub1.g_deadLine DAY)) > DATE(NOW())\r\n"
				+ "	AND sub1.email = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rowCount = 0;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
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
		return rowCount;
	}

	// 진행중인 내 설문 보기
	public ArrayList<SurveyInfoVO> getSurveyByMySurvey(int page, int pageSize, String email) {
		String sql = "SELECT \r\n" + "		sub1.s_code s_code, \r\n" + "		nick writer, \r\n"
				+ "		s_title, \r\n" + "		interest_count, \r\n" + "		DATE(writtendate) written_date, \r\n"
				+ "		DATE(end_date) end_date\r\n" + "FROM (SELECT \r\n" + "				A.s_code, \r\n"
				+ "				A.email,\r\n" + "				C.nick, \r\n" + "				A.s_title, \r\n"
				+ "				A.writtendate, \r\n" + "				A.s_reported, \r\n"
				+ "				DATE_ADD(A.writtendate, INTERVAL D.g_deadLine DAY) end_date,\r\n"
				+ "				A.s_public,\r\n" + "				D.g_sample_num, \r\n"
				+ "				D.g_deadline\r\n" + "		FROM survey A, members C, grades D \r\n"
				+ "		WHERE A.email = C.email AND C.g_name = D.g_name) sub1 \r\n" + "		LEFT JOIN \r\n"
				+ "	  (SELECT \r\n" + "	  			s_code, \r\n" + "				COUNT(s_code) interest_count \r\n"
				+ "		FROM interests \r\n" + "		GROUP BY s_code) sub2 \r\n"
				+ "	   ON (sub1.s_code = sub2.s_code)\r\n" + "	   	LEFT JOIN\r\n" + "		(SELECT \r\n"
				+ "			s_code, COUNT(s_code) sample_num\r\n" + "		FROM\r\n" + "			pointhistory\r\n"
				+ "		WHERE ph_type='P'\r\n" + "		GROUP BY\r\n"
				+ "			s_code) sub3 ON (sub1.s_code = sub3.s_code)\r\n" + "WHERE\r\n"
				+ "	sub1.s_reported != 'Y'\r\n" + "	AND g_sample_num - IFNULL(sample_num, 0) != 0 \r\n"
				+ "	AND DATE(DATE_ADD(sub1.writtendate, INTERVAL sub1.g_deadLine DAY)) > DATE(NOW())\r\n"
				+ "	AND sub1.email = ?\r\n" + "ORDER BY\r\n" + "	TIMESTAMPDIFF(DAY, NOW(), end_date) DESC\r\n" + "";
		int startPos = ((page - 1) * pageSize < 0) ? 0 : (page - 1) * pageSize;
		sql += "LIMIT " + startPos + ", " + pageSize + " ";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SurveyInfoVO> surveys = new ArrayList<>();

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SurveyInfoVO s = new SurveyInfoVO();
				s.setS_code(rs.getInt("s_code"));
				s.setWriter(rs.getString("writer"));
				s.setS_title(rs.getString("s_title"));
				s.setInterest_count(rs.getInt("interest_count"));
				s.setWritten_date(rs.getString("written_date"));
				surveys.add(s);
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
		return surveys;
	}

	public int getTotalCountByMyInterest(String email) {
		String sql = "SELECT COUNT(*) \r\n" + "FROM (SELECT \r\n" + "			A.s_code, \r\n"
				+ "			DATE_ADD(A.writtendate, INTERVAL D.g_deadLine DAY) end_date,\r\n"
				+ "			A.s_public,\r\n" + "			D.g_sample_num, \r\n" + "			D.g_deadline,\r\n"
				+ "			A.writtendate, \r\n" + "			A.s_reported \r\n"
				+ "		FROM survey A, members C, grades D \r\n"
				+ "		WHERE A.email = C.email AND C.g_name = D.g_name) sub1\r\n" + "		LEFT JOIN \r\n"
				+ "		(SELECT  \r\n" + "			s_code,   \r\n" + "			COUNT(s_code) interest_count \r\n"
				+ "		FROM interests \r\n" + "		GROUP BY s_code) sub2 ON (sub1.s_code = sub2.s_code)\r\n"
				+ "		LEFT JOIN\r\n" + "		(SELECT  \r\n" + "			s_code, COUNT(s_code) sample_num \r\n"
				+ "		FROM pointhistory\r\n" + "		WHERE ph_type='P'\r\n"
				+ "		GROUP BY s_code) sub3 ON (sub1.s_code = sub3.s_code) \r\n" + "		INNER JOIN \r\n"
				+ "		(SELECT \r\n" + "			A.email,  \r\n" + "			A.s_code \r\n"
				+ "		FROM interests A, survey B \r\n" + "		WHERE A.s_code = B.s_code \r\n"
				+ "		AND A.email = ?) sub4 ON (sub4.s_code = sub1.s_code)\r\n"
				+ "WHERE g_sample_num - IFNULL(sample_num, 0) != 0 \r\n"
				+ "		AND DATE(DATE_ADD(sub1.writtendate, INTERVAL sub1.g_deadLine DAY)) > DATE(NOW())"
				+ "		AND sub1.s_reported != 'Y'";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rowCount = 0;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
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
		return rowCount;
	}

	// 진행중인 관심설문 보기
	public ArrayList<SurveyInfoVO> getSurveyByMyInterest(int page, int pageSize, String email) {
		String sql = "SELECT \r\n" + "		sub1.s_code s_code, \r\n" + "		nick writer, \r\n"
				+ "		s_title, \r\n" + "		interest_count, \r\n" + "		DATE(writtendate) written_date, \r\n"
				+ "		DATE(end_date) end_date\r\n" + "FROM (SELECT \r\n" + "				A.s_code, \r\n"
				+ "				A.email,\r\n" + "				C.nick, \r\n" + "				A.s_title, \r\n"
				+ "				A.writtendate, \r\n" + "				A.s_reported, \r\n"
				+ "				DATE_ADD(A.writtendate, INTERVAL D.g_deadLine DAY) end_date,\r\n"
				+ "				A.s_public,\r\n" + "				D.g_sample_num, \r\n"
				+ "				D.g_deadline\r\n" + "		FROM survey A, members C, grades D \r\n"
				+ "		WHERE A.email = C.email AND C.g_name = D.g_name) sub1 \r\n" + "		LEFT JOIN \r\n"
				+ "	  (SELECT \r\n" + "	  			s_code, \r\n" + "				COUNT(s_code) interest_count\r\n"
				+ "		FROM interests \r\n" + "		GROUP BY s_code) sub2 \r\n"
				+ "	   ON (sub1.s_code = sub2.s_code)\r\n" + "	   	LEFT JOIN\r\n" + "		(SELECT \r\n"
				+ "			s_code, COUNT(s_code) sample_num\r\n" + "		FROM\r\n" + "			pointhistory\r\n"
				+ "		WHERE ph_type='P'\r\n" + "		GROUP BY\r\n"
				+ "			s_code) sub3 ON (sub1.s_code = sub3.s_code)\r\n" + "		INNER JOIN \r\n"
				+ "		(SELECT\r\n" + "			A.email,\r\n" + "			A.s_code\r\n" + "		FROM \r\n"
				+ "			interests A, survey B\r\n" + "		WHERE\r\n" + "			A.s_code = B.s_code \r\n"
				+ "			AND A.email = ?) sub4 ON (sub4.s_code = sub1.s_code)\r\n" + "WHERE\r\n"
				+ "	sub1.s_reported != 'Y'\r\n" + "	AND g_sample_num - IFNULL(sample_num, 0) != 0 \r\n"
				+ "	AND DATE(DATE_ADD(sub1.writtendate, INTERVAL sub1.g_deadLine DAY)) > DATE(NOW())\r\n"
				+ "ORDER BY\r\n" + "	TIMESTAMPDIFF(DAY, NOW(), end_date) ASC ";
		int startPos = ((page - 1) * pageSize < 0) ? 0 : (page - 1) * pageSize;
		sql += "LIMIT " + startPos + ", " + pageSize + " ";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SurveyInfoVO> surveys = new ArrayList<>();

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SurveyInfoVO s = new SurveyInfoVO();
				s.setS_code(rs.getInt("s_code"));
				s.setWriter(rs.getString("writer"));
				s.setS_title(rs.getString("s_title"));
				s.setInterest_count(rs.getInt("interest_count"));
				s.setWritten_date(rs.getString("written_date"));
				surveys.add(s);
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
		return surveys;
	}

	public int getTotalCountByMyPurchase(String email) {
		String sql = "SELECT COUNT(*)\r\n" + "FROM pointhistory\r\n" + "WHERE email=?\r\n" + "AND ph_type='B'";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rowCount = 0;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
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
		return rowCount;
	}

	// 구매한 설문 보기
	public ArrayList<SurveyInfoVO> getSurveyByMyPurchase(int page, int pageSize, String email) {
		String sql = "SELECT \r\n" + "		sub1.s_code s_code, \r\n" + "		nick writer, \r\n"
				+ "		s_title, \r\n" + "		interest_count, \r\n" + "		DATE(writtendate) written_date, \r\n"
				+ "		DATE(end_date) end_date\r\n" + "FROM (SELECT \r\n" + "			A.s_code, \r\n"
				+ "			A.email,\r\n" + "			C.nick, \r\n" + "			A.s_title, \r\n"
				+ "			A.writtendate, \r\n" + "			A.s_reported, \r\n"
				+ "			DATE_ADD(A.writtendate, INTERVAL D.g_deadLine DAY) end_date,\r\n"
				+ "			A.s_public,\r\n" + "			D.g_sample_num, \r\n" + "			D.g_deadline\r\n"
				+ "		FROM survey A, members C, grades D \r\n"
				+ "		WHERE A.email = C.email AND C.g_name = D.g_name) sub1 \r\n" + "		LEFT JOIN \r\n"
				+ "	  (SELECT \r\n" + "	  		s_code, \r\n" + "			COUNT(s_code) interest_count\r\n"
				+ "		FROM interests \r\n" + "		GROUP BY s_code) sub2 \r\n"
				+ "	   ON (sub1.s_code = sub2.s_code)\r\n" + "	   	LEFT JOIN\r\n" + "		(SELECT \r\n"
				+ "			s_code, COUNT(s_code) sample_num\r\n" + "		FROM\r\n" + "			pointhistory\r\n"
				+ "		WHERE ph_type='P'\r\n" + "		GROUP BY\r\n"
				+ "			s_code) sub3 ON (sub1.s_code = sub3.s_code)\r\n" + "		INNER JOIN \r\n"
				+ "		(SELECT s_code\r\n" + "		FROM pointhistory\r\n" + "		WHERE email=?\r\n"
				+ "		AND ph_type='B') sub4 ON (sub4.s_code = sub1.s_code)\r\n" + "WHERE sub1.s_reported != 'Y'\r\n"
				+ "ORDER BY\r\n" + "	TIMESTAMPDIFF(DAY, NOW(), end_date) DESC ";

		int startPos = ((page - 1) * pageSize < 0) ? 0 : (page - 1) * pageSize;
		sql += "LIMIT " + startPos + ", " + pageSize + " ";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SurveyInfoVO> surveys = new ArrayList<>();

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SurveyInfoVO s = new SurveyInfoVO();
				s.setS_code(rs.getInt("s_code"));
				s.setWriter(rs.getString("writer"));
				s.setS_title(rs.getString("s_title"));
				s.setInterest_count(rs.getInt("interest_count"));
				s.setWritten_date(rs.getString("written_date"));
				surveys.add(s);
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
		return surveys;
	}

	public int getTotalCountByMyEndInterest(String email) {
		String sql = "SELECT COUNT(*)\r\n" + "FROM (SELECT \r\n" + "			A.s_code, \r\n"
				+ "			DATE_ADD(A.writtendate, INTERVAL D.g_deadLine DAY) end_date,\r\n"
				+ "			A.s_public,\r\n" + "			A.s_reported,\r\n" + "			D.g_sample_num, \r\n"
				+ "			D.g_deadline\r\n" + "		FROM survey A, members C, grades D \r\n"
				+ "		WHERE A.email = C.email AND C.g_name = D.g_name) sub1\r\n" + "		LEFT JOIN \r\n"
				+ "		(SELECT \r\n" + "			s_code,  \r\n" + "			COUNT(s_code) interest_count \r\n"
				+ "		FROM interests \r\n" + "		GROUP BY s_code) sub2 ON (sub1.s_code = sub2.s_code)\r\n"
				+ "		LEFT JOIN\r\n" + "		(SELECT \r\n" + "			s_code, COUNT(s_code) sample_num \r\n"
				+ "		FROM pointhistory\r\n" + "		WHERE ph_type='P'\r\n"
				+ "		GROUP BY s_code) sub3 ON (sub1.s_code = sub3.s_code) \r\n" + "		INNER JOIN \r\n"
				+ "		(SELECT\r\n" + "			A.email, \r\n" + "			A.s_code \r\n"
				+ "		FROM interests A, survey B \r\n" + "		WHERE A.s_code = B.s_code \r\n"
				+ "		AND A.email = ?) sub4 ON (sub4.s_code = sub1.s_code)\r\n" + "WHERE sub1.s_public = 'Y'\r\n"
				+ "		AND sub1.s_reported != 'Y'\r\n" + "		AND (g_sample_num - IFNULL(sample_num, 0) = 0\r\n"
				+ "		OR DATE(NOW()) >= DATE(end_date));";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rowCount = 0;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
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
		return rowCount;
	}

	public ArrayList<SurveyInfoVO> getSurveyByMyEndInterest(int page, int pageSize, String email) {
		String sql = "SELECT \r\n" + "		sub1.s_code s_code, \r\n" + "		nick writer, \r\n"
				+ "		s_title, \r\n" + "		interest_count, \r\n" + "		DATE(writtendate) written_date, \r\n"
				+ "		DATE(end_date) end_date\r\n" + "FROM (SELECT \r\n" + "			A.s_code, \r\n"
				+ "			A.email,\r\n" + "			C.nick, \r\n" + "			A.s_title, \r\n"
				+ "			A.writtendate, \r\n" + "			A.s_reported, \r\n"
				+ "			DATE_ADD(A.writtendate, INTERVAL D.g_deadLine DAY) end_date,\r\n"
				+ "			A.s_public,\r\n" + "			D.g_sample_num, \r\n" + "			D.g_deadline\r\n"
				+ "		FROM survey A, members C, grades D \r\n"
				+ "		WHERE A.email = C.email AND C.g_name = D.g_name) sub1 \r\n" + "		LEFT JOIN \r\n"
				+ "	  (SELECT \r\n" + "	  			s_code, \r\n" + "				COUNT(s_code) interest_count\r\n"
				+ "		FROM interests \r\n" + "		GROUP BY s_code) sub2 \r\n"
				+ "	   ON (sub1.s_code = sub2.s_code)\r\n" + "	   	LEFT JOIN\r\n" + "		(SELECT \r\n"
				+ "			s_code, COUNT(s_code) sample_num\r\n" + "		FROM\r\n" + "			pointhistory\r\n"
				+ "		WHERE ph_type='P'\r\n" + "		GROUP BY\r\n"
				+ "			s_code) sub3 ON (sub1.s_code = sub3.s_code)\r\n" + "		INNER JOIN \r\n"
				+ "		(SELECT\r\n" + "			A.email,\r\n" + "			A.s_code\r\n" + "		FROM \r\n"
				+ "			interests A, survey B\r\n" + "		WHERE\r\n" + "			A.s_code = B.s_code \r\n"
				+ "			AND A.email = ?) sub4 ON (sub4.s_code = sub1.s_code)\r\n" + "WHERE \r\n"
				+ "		sub1.s_public = 'Y' \r\n" + "		AND sub1.s_reported != 'Y'\r\n"
				+ "		AND (g_sample_num - IFNULL(sample_num, 0) = 0\r\n" + "		OR DATE(NOW()) >= DATE(end_date))"
				+ "ORDER BY\r\n" + "	TIMESTAMPDIFF(DAY, NOW(), end_date) ASC ";
		int startPos = ((page - 1) * pageSize < 0) ? 0 : (page - 1) * pageSize;
		sql += "LIMIT " + startPos + ", " + pageSize + " ";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SurveyInfoVO> surveys = new ArrayList<>();

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SurveyInfoVO s = new SurveyInfoVO();
				s.setS_code(rs.getInt("s_code"));
				s.setWriter(rs.getString("writer"));
				s.setS_title(rs.getString("s_title"));
				s.setInterest_count(rs.getInt("interest_count"));
				s.setWritten_date(rs.getString("written_date"));
				surveys.add(s);
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
		return surveys;
	}

	public int getTotalCountByMyEndSurvey(String email) {
		String sql = "SELECT COUNT(*)\r\n" + "FROM (SELECT  \r\n" + "			A.s_code, \r\n"
				+ "			A.email,\r\n" + "			A.s_reported,\r\n"
				+ "			DATE_ADD(A.writtendate, INTERVAL D.g_deadLine DAY) end_date, \r\n"
				+ "			D.g_sample_num, \r\n" + "			D.g_deadline\r\n"
				+ "		FROM survey A, members C, grades D \r\n"
				+ "		WHERE A.email = C.email AND C.g_name = D.g_name) sub1 \r\n" + "		LEFT JOIN \r\n"
				+ "		(SELECT  \r\n" + "			s_code,  \r\n" + "			COUNT(s_code) interest_count \r\n"
				+ "		FROM interests\r\n" + "		GROUP BY s_code) sub2 ON (sub1.s_code = sub2.s_code)\r\n"
				+ "		LEFT JOIN\r\n" + "		(SELECT\r\n" + "			s_code, COUNT(s_code) sample_num\r\n"
				+ "		FROM pointhistory\r\n" + "		WHERE ph_type='P'\r\n"
				+ "		GROUP BY s_code) sub3 ON (sub1.s_code = sub3.s_code)\r\n" + "WHERE\r\n"
				+ "	g_sample_num - IFNULL(sample_num, 0) = 0\r\n" + "	OR DATE(NOW()) >= DATE(end_date)\r\n"
				+ "	AND sub1.email = ?\r\n" + "	AND sub1.s_reported != 'Y'\r\n" + "ORDER BY\r\n"
				+ "	TIMESTAMPDIFF(DAY, NOW(), end_date) ASC";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rowCount = 0;
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
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
		return rowCount;
	}

	public ArrayList<SurveyInfoVO> getSurveyByMyEndSurvey(int page, int pageSize, String email) {
		String sql = "SELECT\r\n" + "	sub1.s_code s_code, \r\n" + "	nick writer, \r\n" + "	s_title,  \r\n"
				+ "	interest_count,  \r\n" + "	DATE(writtendate) written_date, \r\n"
				+ "	DATE(end_date) end_date \r\n" + "FROM (SELECT  \r\n" + "			A.s_code, \r\n"
				+ "			A.email,\r\n" + "			C.nick, \r\n" + "			A.s_title,  \r\n"
				+ "			A.writtendate, \r\n" + "			A.s_reported, \r\n"
				+ "			DATE_ADD(A.writtendate, INTERVAL D.g_deadLine DAY) end_date, \r\n"
				+ "			A.s_public,\r\n" + "			D.g_sample_num, \r\n" + "			D.g_deadline\r\n"
				+ "		FROM survey A, members C, grades D \r\n"
				+ "		WHERE A.email = C.email AND C.g_name = D.g_name) sub1 \r\n" + "		LEFT JOIN \r\n"
				+ "		(SELECT  \r\n" + "			s_code,  \r\n" + "			COUNT(s_code) interest_count \r\n"
				+ "		FROM interests\r\n" + "		GROUP BY s_code) sub2 \r\n"
				+ "		ON (sub1.s_code = sub2.s_code)\r\n" + "		LEFT JOIN\r\n" + "		(SELECT\r\n"
				+ "			s_code, COUNT(s_code) sample_num\r\n" + "		FROM pointhistory\r\n"
				+ "		WHERE ph_type='P'\r\n" + "		GROUP BY\r\n"
				+ "			s_code) sub3 ON (sub1.s_code = sub3.s_code)\r\n" + "WHERE\r\n"
				+ "	g_sample_num - IFNULL(sample_num, 0) = 0\r\n" + "	OR DATE(NOW()) >= DATE(end_date)\r\n"
				+ "	AND sub1.email = ?\r\n" + "	AND sub1.s_reported != 'Y'\r\n"
				+ "ORDER BY TIMESTAMPDIFF(DAY, NOW(), end_date) ASC ";
		int startPos = ((page - 1) * pageSize < 0) ? 0 : (page - 1) * pageSize;
		sql += "LIMIT " + startPos + ", " + pageSize + " ";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SurveyInfoVO> surveys = new ArrayList<>();

		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SurveyInfoVO s = new SurveyInfoVO();
				s.setS_code(rs.getInt("s_code"));
				s.setWriter(rs.getString("writer"));
				s.setS_title(rs.getString("s_title"));
				s.setInterest_count(rs.getInt("interest_count"));
				s.setWritten_date(rs.getString("written_date"));
				surveys.add(s);
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
		return surveys;
	}
}
