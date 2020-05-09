package com.surveypro.survey.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.surveypro.survey.service.ISurveyService;
import com.surveypro.survey.service.SurveyGetByCategoryService;
import com.surveypro.vo.SurveyInfoVO;

public class SurveyGetByCategoryController implements SurveyBackController {

	private ISurveyService service;

	public SurveyGetByCategoryController() {
		service = new SurveyGetByCategoryService();
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
			jObj.put("message", "Fetching surveys by category completed.");
			int page = (Integer) request.getAttribute("page");
			String c_code = (String) request.getAttribute("c_code");
			int pageCount = (Integer) request.getAttribute("pageCount");
			ArrayList<SurveyInfoVO> surveys = (ArrayList<SurveyInfoVO>) request.getAttribute("surveys");
			jObj.put("page", page);
			jObj.put("c_code", c_code);
			jObj.put("pageCount", pageCount);
			JSONArray jAry = new JSONArray();
			for (SurveyInfoVO survey : surveys) {
				JSONObject jTemp = new JSONObject();
				jTemp.putAll(survey.convertMap());
				jAry.add(jTemp);
			}
			jObj.put("surveys", jAry);
		} catch (Exception e) {
			jObj = new JSONObject();
			jObj.put("result", false);
			jObj.put("message", "Fetching surveys by category failed.");
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
