package com.surveypro.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.member.service.IMemberService;
import com.surveypro.member.service.MemberLoginCheckService;

public class MemberLoginCheckController implements MemberBackController {

	private IMemberService service;

	public MemberLoginCheckController() {
		service = new MemberLoginCheckService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj = new JSONObject();
		try {
			service.doService(request, response);
			jObj.put("result", true);
			jObj.put("message", "로그인 상태 입니다.");
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
