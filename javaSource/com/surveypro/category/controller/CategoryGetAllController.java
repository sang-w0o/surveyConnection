package com.surveypro.category.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.surveypro.category.service.CategoryGetAllService;
import com.surveypro.category.service.ICategoryService;
import com.surveypro.vo.CategoryVO;

public class CategoryGetAllController implements CategoryBackController {

	private ICategoryService service;

	public CategoryGetAllController() {
		service = new CategoryGetAllService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj;
		PrintWriter out = null;
		try {
			service.doService(request, response);
			jObj = new JSONObject();
			jObj.put("result", true);
			jObj.put("message", "Fetching all categories completed.");
			ArrayList<CategoryVO> categories = (ArrayList<CategoryVO>) request.getAttribute("categories");
			JSONArray jAry = new JSONArray();
			for (CategoryVO category : categories) {
				JSONObject jTemp = new JSONObject();
				jTemp.putAll(category.convertMap());
				jAry.add(jTemp);
			}
			jObj.put("categories", jAry);
		} catch (Exception e) {
			jObj = new JSONObject();
			jObj.put("result", false);
			jObj.put("message", "Fetching all categories failed.");
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		try {
			out = response.getWriter();
			out.println(jObj.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
