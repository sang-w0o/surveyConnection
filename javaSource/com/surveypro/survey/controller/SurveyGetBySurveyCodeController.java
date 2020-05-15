package com.surveypro.survey.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.survey.service.ISurveyService;
import com.surveypro.survey.service.SurveyGetBySurveyCodeService;
import com.surveypro.vo.SurveyVO;

public class SurveyGetBySurveyCodeController implements SurveyBackController {
	
	private ISurveyService service;
	
	public SurveyGetBySurveyCodeController() {
		service = new SurveyGetBySurveyCodeService();
	}
	
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject jObj = new JSONObject();
		SurveyVO s = null;
		String c_desc = null;
		
		try {
			service.doService(request, response);
			s = (SurveyVO)request.getAttribute("SurveyVO");
			c_desc = (String)request.getAttribute("c_desc");
			jObj.put("c_desc", c_desc);
			jObj.put("survey", s.convertMap());
			jObj.put("errno", 0);
			jObj.put("message", "설문 가져오기 성공");
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
