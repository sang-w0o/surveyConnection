package com.surveypro.category.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.CategoryDAO;

public class CategoryGetAllDescService implements ICategoryService {
	private CategoryDAO dao;

	public CategoryGetAllDescService() {
		dao = (CategoryDAO) DAOManager.getDAO(CategoryDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		synchronized (dao) {
			ArrayList<String> allDesc = dao.getAllDesc();
			request.setAttribute("allDesc", allDesc);
		}
	}

}
