package com.surveypro.survey.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.surveypro.survey.service.ISurveyService;
import com.surveypro.survey.service.SurveyGetSurveyInfoService;
import com.surveypro.vo.SurveyInfoVO;

public class SurveyGetSurveyInfoController implements SurveyBackController {
	
	private ISurveyService service;
	
	public SurveyGetSurveyInfoController() {
		service = new SurveyGetSurveyInfoService();
	}
	
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		JSONArray jArray = new JSONArray();
		JSONObject jObj = new JSONObject();
		ArrayList<SurveyInfoVO> list = null;
		
		try {
			service.doService(request, response);
			list = (ArrayList<SurveyInfoVO>)request.getAttribute("list");
			
			for (SurveyInfoVO s : list) {
				JSONObject jtmp = new JSONObject();
				jtmp.putAll(s.convertMap());
				jArray.add(jtmp);
			}
			
			jObj.put("errno", 0);
			jObj.put("message", "설문 리스트 가져오기 성공");
			jObj.put("list", jArray);
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
