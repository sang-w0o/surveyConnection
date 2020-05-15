package com.surveypro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.surveypro.controller.DbManager;
import com.surveypro.vo.CategoryVO;

public class CategoryDAO {

	public static final String KEY = "CategoryDAO";

	public CategoryDAO() {
	}

	public String getDesc(String c_code) {
		String sql = "SELECT c_desc FROM categories WHERE c_code=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String desc = null;
		
		try {
			con = DbManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				desc = rs.getString("c_desc");
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
		return desc;
	}

	public ArrayList<CategoryVO> getAllCategories() {
		ArrayList<CategoryVO> categories = new ArrayList<>();
		String sql = "SELECT * FROM categories;";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				CategoryVO c = new CategoryVO();
				c.setC_code(rs.getString("c_code"));
				c.setC_desc(rs.getString("c_desc"));
				categories.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(rs, stmt);
			DbManager.close(con);
		}
		return categories;
	}

	public ArrayList<String> getAllDesc() {
		ArrayList<String> allDesc = new ArrayList<>();
		String sql = "SELECT c_desc FROM categories;";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String temp = rs.getString("c_desc");
				allDesc.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			DbManager.close(rs, stmt);
			DbManager.close(con);
		}
		return allDesc;
	}
}
