package com.surveypro.category.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.service.IService;

public interface ICategoryService extends IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
