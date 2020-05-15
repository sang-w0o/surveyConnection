package com.surveypro.question.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.surveypro.question.service.IQuestionService;
import com.surveypro.question.service.QuestionGetService;
import com.surveypro.vo.QuestionVO;

public class QuestionGetController implements QuestionBackController {

	private IQuestionService service;
	
	public QuestionGetController() {
		service = new QuestionGetService();
	}
	
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		JSONArray jArray = new JSONArray();
		JSONObject jObj = new JSONObject();
		ArrayList<QuestionVO> list = null;
		
		try {
			service.doService(request, response);
			list = (ArrayList<QuestionVO>)request.getAttribute("list");
			
			for (QuestionVO q : list) {
				JSONObject jtmp = new JSONObject();
				jtmp.putAll(q.convertMap());
				jArray.add(jtmp);
			}
			
			jObj.put("errno", 0);
			jObj.put("message", "문항 리스트 가져오기 성공");
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
