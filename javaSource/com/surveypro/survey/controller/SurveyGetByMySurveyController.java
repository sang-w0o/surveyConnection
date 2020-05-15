package com.surveypro.survey.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.surveypro.survey.service.ISurveyService;
import com.surveypro.survey.service.SurveyGetByMySurveyService;
import com.surveypro.vo.MemberVO;
import com.surveypro.vo.SurveyInfoVO;

public class SurveyGetByMySurveyController implements SurveyBackController {
	private ISurveyService service;

	public SurveyGetByMySurveyController() {
		service = new SurveyGetByMySurveyService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj;
		PrintWriter out = null;
		
		HttpSession session = request.getSession(false);
		MemberVO m = (MemberVO)session.getAttribute("userInfo");
		
		try {
			service.doService(request, response);
			jObj = new JSONObject();
			if (m == null) {
				jObj.put("respondent", null);
			}
			else {
				jObj.put("respondent", m.getEmail());
			}
			int page = (Integer) request.getAttribute("page");
			int pageCount = (Integer) request.getAttribute("pageCount");
			ArrayList<SurveyInfoVO> surveys = (ArrayList<SurveyInfoVO>) request.getAttribute("surveys");
			
			jObj.put("result", true);
			jObj.put("message", "내 설문 가져오기 성공");
			jObj.put("page", page);
			jObj.put("pageCount", pageCount);
			JSONArray jAry = new JSONArray();
			for (SurveyInfoVO survey : surveys) {
				JSONObject jTemp = new JSONObject();
				jTemp.putAll(survey.convertMap());
				jAry.add(jTemp);
			}
			jObj.put("surveys", jAry);
		} 
		catch (Exception e) {
			jObj = new JSONObject();
			jObj.put("result", false);
			jObj.put("message", "내 설문 가져오기 실패");
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		try {
			out = response.getWriter();
			out.println(jObj.toJSONString());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
