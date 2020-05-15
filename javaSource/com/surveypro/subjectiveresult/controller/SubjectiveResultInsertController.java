package com.surveypro.subjectiveresult.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.subjectiveresult.service.ISubjectiveResultService;
import com.surveypro.subjectiveresult.service.SubjectiveResultInsertService;

public class SubjectiveResultInsertController implements SubjectiveResultBackController {

	private ISubjectiveResultService service;

	public SubjectiveResultInsertController() {
		service = new SubjectiveResultInsertService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jObj = new JSONObject();

		try {
			service.doService(request, response);
			jObj.put("result", true);
			jObj.put("message", "주관식 결과 제출에 성공했습니다.");
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
