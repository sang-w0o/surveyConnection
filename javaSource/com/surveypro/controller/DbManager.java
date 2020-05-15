package com.surveypro.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbManager {
	public static Connection getConnection() throws NamingException, SQLException {

		InitialContext ic = new InitialContext();
		DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/knj");

		return ds.getConnection();
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
		}
	}

	public static void close(Statement s) {
		try {
			s.close();
		} catch (Exception e) {
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
		}
	}

	public static void close(ResultSet rs, Statement s) {
		try {
			rs.close();
		} catch (Exception e) {
		}
		try {
			s.close();
		} catch (Exception e) {
		}
	}

	public static void close(Statement s, Connection con) {
		try {
			s.close();
		} catch (Exception e) {
		}
		try {
			con.close();
		} catch (Exception e) {
		}
	}

	public static void close(PreparedStatement p) {
		try {
			p.close();
		} catch (Exception e) {
		}
	}
}