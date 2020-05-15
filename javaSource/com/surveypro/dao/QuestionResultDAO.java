package com.surveypro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.naming.NamingException;

import com.surveypro.controller.DbManager;
import com.surveypro.vo.QuestionResultVO;
import com.surveypro.vo.QuestionVO;

public class QuestionResultDAO {
	public static final String KEY = "QuestionResultDAO";

	public QuestionVO getQuestionVO(int s_code, int q_number) {
		String sql = "SELECT * FROM questions WHERE s_code = " + s_code + " AND q_number=" + q_number;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		QuestionVO q = null;
		try {
			q = new QuestionVO();
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			q.setQ_number(q_number);
			q.setS_code(s_code);
			if (rs.next()) {
				q.setQ_title(rs.getString("q_title"));
				q.setQ_type(rs.getString("q_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(stmt);
			DbManager.close(con);
		}
		return q;
	}

	public ArrayList<Integer> getChoiceNum(int s_code, int q_number) {
		String sql = "SELECT * FROM choices WHERE s_code=" + s_code + " AND q_number=" + q_number;
		Connection con = null;
		Statement pstmt = null;
		ResultSet rs = null;
		ArrayList<Integer> list = new ArrayList<>();
		try {
			con = DbManager.getConnection();
			pstmt = con.createStatement();
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				Integer num = rs.getInt("choice_num");
				list.add(num);
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

	public Integer getChoiceCount(int s_code, int q_number, int choice_num) {
		String sql = "SELECT count(*) AS num FROM choiceresults WHERE s_code=" + s_code + " AND q_number=" + q_number
				+ " AND choice_num =" + choice_num;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int num = 0;
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

	public String getChoiceContent(int s_code, int q_number, int choice_num) {
		String sql = "SELECT * FROM choices WHERE s_code =" + s_code + " AND q_number =" + q_number
				+ " AND choice_num =" + choice_num;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String str = "";
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				str = rs.getString("choice_content");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(stmt);
			DbManager.close(con);
		}
		return str;
	}

	public ArrayList<String> getSubjectiveResultList(int s_code, int q_number) {
		
		String sql = "SELECT * FROM subjectiveresults WHERE s_code=" + s_code + " AND q_number =" + q_number;
		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		
		ArrayList<String> list = null;
		try {
			list = new ArrayList<>();
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String str = rs.getString("answer");
				list.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(stmt);
			DbManager.close(con);
		}
		return list;
	}

	public QuestionResultVO getQuestionResultVO(int s_code, int q_number) {
		QuestionResultVO qrvo = new QuestionResultVO();
		HashMap<String, Integer> choices = new HashMap<>();
		ArrayList<Integer> choList = null;
		ArrayList<String> subList = null;
		QuestionVO q = getQuestionVO(s_code, q_number);
		qrvo.setS_code(s_code);
		qrvo.setQ_number(q_number);

		qrvo.setQ_title(q.getQ_title());

		qrvo.setQ_type(q.getQ_type());

		if (qrvo.getQ_type().equals("C")) {

			choList = getChoiceNum(s_code, q_number);
			Iterator<Integer> choit = choList.iterator();
			while (choit.hasNext()) {
				int choNum = choit.next();
				int value = getChoiceCount(s_code, q_number, choNum);
				String key = getChoiceContent(s_code, q_number, choNum);
				choices.put(key, value);
			}
		} else {
			subList = getSubjectiveResultList(s_code, q_number);
		}
		qrvo.setChoices(choices);
		qrvo.setSubjectives(subList);

		return qrvo;
	}
}
