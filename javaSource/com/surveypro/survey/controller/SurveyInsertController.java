package com.surveypro.survey.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.survey.service.ISurveyService;
import com.surveypro.survey.service.SurveyInsertService;

public class SurveyInsertController implements SurveyBackController {

	private ISurveyService service;

	public SurveyInsertController() {
		service = new SurveyInsertService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj = new JSONObject();

		try {
			service.doService(request, response);
			jObj.put("result", true);
			jObj.put("s_code", request.getAttribute("s_code"));
			jObj.put("message", "설문지 등록에 성공했습니다.");
		} catch (Exception e) {
			jObj.put("result", false);
			jObj.put("message", e.getMessage());
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
