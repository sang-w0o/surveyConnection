package com.surveypro.survey.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.survey.exception.SurveyCheckResponseException;
import com.surveypro.survey.service.ISurveyService;
import com.surveypro.survey.service.SurveyCheckResponseService;

public class SurveyCheckResponseController implements SurveyBackController {
	
	private ISurveyService service;
	
	public SurveyCheckResponseController() {
		service = new SurveyCheckResponseService();
	}
	
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject jObj = new JSONObject();
		int s_code = Integer.parseInt(request.getParameter("s_code"));
		String resp = (String)request.getParameter("respondent");
		String res = "";
		jObj.put("s_code", s_code);
		jObj.put("resp", resp);
		
		try {
			service.doService(request, response);
			res = (String)request.getAttribute("res");
			if (res.equals("t")) {
				throw new SurveyCheckResponseException();
			}
			jObj.put("errno", 0);
			jObj.put("message", "설문 참여 가능");
		}
		catch (Exception e) {
			jObj.put("errno", 1);
			jObj.put("message", e.getMessage());
		}
		
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			out = response.getWriter();
			out.println(jObj.toJSONString());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
