package com.surveypro.result.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.surveypro.question.controller.QuestionBackController;
import com.surveypro.result.service.IResultService;
import com.surveypro.result.service.QuestionResultGetService;
import com.surveypro.vo.QuestionResultVO;

public class QuestionResultGetController implements QuestionBackController{
	private IResultService service;
	
	public QuestionResultGetController() {
		service = new QuestionResultGetService();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		JSONArray jArray = new JSONArray();
		JSONObject jObj = new JSONObject();
		try {
			service.doService(request, response);
			ArrayList<QuestionResultVO> list = (ArrayList<QuestionResultVO>)request.getAttribute("QuestionResult");
			for(QuestionResultVO qr : list) {
				JSONObject jtemp = new JSONObject();
				jtemp.putAll(qr.convertMap());
				jArray.add(jtemp);
			}
			jObj.put("list",jArray);
			jObj.put("email",(String)request.getAttribute("email"));
			jObj.put("category",(String)request.getAttribute("category"));
			jObj.put("sample",request.getAttribute("sample"));
			jObj.put("title",(String)request.getAttribute("title"));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			out = response.getWriter();
			out.println(jObj.toJSONString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
