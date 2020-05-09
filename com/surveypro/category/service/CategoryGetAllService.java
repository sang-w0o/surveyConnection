package com.surveypro.category.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.CategoryDAO;
import com.surveypro.vo.CategoryVO;

public class CategoryGetAllService implements ICategoryService {

	private CategoryDAO dao;

	public CategoryGetAllService() {
		dao = (CategoryDAO) DAOManager.getDAO(CategoryDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		synchronized (dao) {
			ArrayList<CategoryVO> categories = dao.getAllCategories();
			request.setAttribute("categories", categories);
		}
	}

}
