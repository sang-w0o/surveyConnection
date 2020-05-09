package com.surveypro.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, BackController> services;

	@SuppressWarnings("rawtypes")
	@Override
	public void init(ServletConfig config) throws ServletException {
		services = new HashMap<>();

		Enumeration<String> params = config.getInitParameterNames();
		ServletContext sc = config.getServletContext();
		String contextPath = sc.getContextPath();
		if (!contextPath.endsWith("/")) {
			contextPath = contextPath + "/";
		}
		while (params.hasMoreElements()) {
			String param = params.nextElement();
			try {
				String classPath = config.getInitParameter(param);
				Class cls = Class.forName(classPath);
				services.put(contextPath + param, (BackController) cls.newInstance());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		services.get(uri).execute(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
