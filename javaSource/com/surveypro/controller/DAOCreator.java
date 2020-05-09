package com.surveypro.controller;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DAOCreator implements ServletContextListener {

	@SuppressWarnings("rawtypes")
	public void contextInitialized(ServletContextEvent sce) {

		ServletContext sc = sce.getServletContext();
		Enumeration names = sc.getInitParameterNames();
		while (names.hasMoreElements()) {
			String key = (String) names.nextElement();
			String clsName = (String) sc.getInitParameter(key);

			try {
				Class cls = Class.forName(clsName);
				DAOManager.addDAO(key, cls.newInstance());
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
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}
