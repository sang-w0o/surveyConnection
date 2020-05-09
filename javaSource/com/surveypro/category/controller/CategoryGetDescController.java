package com.surveypro.category.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.category.service.CategoryGetDescService;
import com.surveypro.category.service.ICategoryService;

public class CategoryGetDescController implements CategoryBackController {

	public ICategoryService service;

	public CategoryGetDescController() {
		service = new CategoryGetDescService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj = new JSONObject();
		try {
			service.doService(request, response);
			String c_desc = (String) request.getAttribute("c_desc");
			jObj.put("result", true);
			jObj.put("message", c_desc + "�� ������ �������µ� �����߽��ϴ�.");
			jObj.put("c_desc", c_desc);
		} catch (Exception e) {
			jObj.put("result", false);
			jObj.put("message", "ī�װ� ������ �������µ� �����߽��ϴ�.");
		}

		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			out = response.getWriter();
			out.println(jObj.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
