package com.surveypro.category.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.surveypro.category.service.CategoryGetAllDescService;
import com.surveypro.category.service.ICategoryService;

public class CategoryGetAllDescController implements CategoryBackController {

	private ICategoryService service;

	public CategoryGetAllDescController() {
		service = new CategoryGetAllDescService();
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
			jObj.put("message", "Fetching all descriptions completed.");
			ArrayList<String> allDesc = (ArrayList<String>) request.getAttribute("allDesc");
			JSONArray jAry = new JSONArray();
			for (String desc : allDesc) {
				jAry.add(desc);
			}
			jObj.put("allDesc", jAry);
		} catch (Exception e) {
			jObj = new JSONObject();
			jObj.put("result", false);
			jObj.put("message", "Fetching all descriptions failed.");
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
