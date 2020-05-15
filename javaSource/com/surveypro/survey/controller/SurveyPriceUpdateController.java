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
			jObj.put("message", "���� ����Ʈ ���� ����");
		} catch (Exception e) {
			jObj.put("result", false);
			jObj.put("message", "���� ����Ʈ ���ſ� �����߽��ϴ�.");
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
