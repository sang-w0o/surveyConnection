package com.surveypro.choice.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.surveypro.choice.service.ChoiceGetService;
import com.surveypro.choice.service.IChoiceService;
import com.surveypro.vo.ChoiceVO;

public class ChoiceGetController implements ChoiceBackController {

	private IChoiceService service;
	
	public ChoiceGetController() {
		service = new ChoiceGetService();
	}
	
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		JSONArray jArray = new JSONArray();
		JSONObject jObj = new JSONObject();
		ArrayList<ChoiceVO> list = null;
		
		try {
			service.doService(request, response);
			list = (ArrayList<ChoiceVO>)request.getAttribute("list");
			
			for (ChoiceVO c : list) {
				JSONObject jtmp = new JSONObject();
				jtmp.putAll(c.convertMap());
				jArray.add(jtmp);
			}
			
			jObj.put("errno", 0);
			jObj.put("message", "선택지 리스트 가져오기 성공");
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
