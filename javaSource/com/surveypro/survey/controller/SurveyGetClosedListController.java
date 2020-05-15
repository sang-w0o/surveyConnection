package com.surveypro.survey.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.surveypro.survey.service.ISurveyService;
import com.surveypro.survey.service.SurveyGetClosedListService;
import com.surveypro.vo.MemberVO;
import com.surveypro.vo.SurveyInfoVO;

public class SurveyGetClosedListController implements SurveyBackController {

	private ISurveyService service;

	public SurveyGetClosedListController() {
		service = new SurveyGetClosedListService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONArray jArray = new JSONArray();
		JSONObject jObj = new JSONObject();
		ArrayList<SurveyInfoVO> endSurveyList = null;

		HttpSession session = request.getSession(false);
		MemberVO m = (MemberVO) session.getAttribute("userInfo");
		if (m == null) {
			jObj.put("respondent", null);
		} else {
			jObj.put("respondent", m.getEmail());
		}

		try {
			service.doService(request, response);
			endSurveyList = (ArrayList<SurveyInfoVO>) request.getAttribute("endSurveyList");

			for (SurveyInfoVO s : endSurveyList) {
				JSONObject jTmp = new JSONObject();
				jTmp.putAll(s.convertMap());
				jArray.add(jTmp);
			}

			jObj.put("result", true);
			jObj.put("message", "마감 설문 목록 가져오기 성공!");
			jObj.put("endSurveyList", jArray);
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
