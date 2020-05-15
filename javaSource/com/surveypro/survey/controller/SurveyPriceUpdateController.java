package com.surveypro.survey.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.survey.service.ISurveyService;
import com.surveypro.survey.service.SurveyPriceUpdateService;

public class SurveyPriceUpdateController implements SurveyBackController {

	private ISurveyService service;

	public SurveyPriceUpdateController() {
		service = new SurveyPriceUpdateService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj = new JSONObject();
		try {
			service.doService(request, response);
			jObj.put("result", true);
			jObj.put("message", "설문 포인트 갱신 성공");
		} catch (Exception e) {
			jObj.put("result", false);
			jObj.put("message", "설문 포인트 갱신에 실패했습니다.");
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
