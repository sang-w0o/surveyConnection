package com.surveypro.category.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.category.exception.CategoryNotFoundException;
import com.surveypro.controller.DAOManager;
import com.surveypro.dao.CategoryDAO;

public class CategoryGetDescService implements ICategoryService {

	private CategoryDAO dao;

	public CategoryGetDescService() {
		dao = (CategoryDAO) DAOManager.getDAO(CategoryDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String c_code = request.getParameter("c_code");

		synchronized (dao) {
			String desc = dao.getDesc(c_code);
			if (desc == null) {
				throw new CategoryNotFoundException();
			}
			request.setAttribute("c_desc", desc);
		}

	}

}
