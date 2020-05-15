package com.surveypro.choiceresult.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.choiceresult.service.ChoiceResultInsertService;
import com.surveypro.choiceresult.service.IChoiceResultService;

public class ChoiceResultInsertController implements ChoiceResultBackController {

	private IChoiceResultService service;

	public ChoiceResultInsertController() {
		service = new ChoiceResultInsertService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj = new JSONObject();

		try {
			service.doService(request, response);
			jObj.put("result", true);
			jObj.put("message", "객관식 결과 제출에 성공했습니다.");
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
