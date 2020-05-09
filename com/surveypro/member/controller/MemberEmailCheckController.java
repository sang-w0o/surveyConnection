package com.surveypro.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.member.service.IMemberService;
import com.surveypro.member.service.MemberEmailCheckService;

public class MemberEmailCheckController implements MemberBackController {

	private IMemberService service;

	public MemberEmailCheckController() {
		service = new MemberEmailCheckService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj = new JSONObject();
		try {
			service.doService(request, response);
			String email = (String) request.getAttribute("email");
			jObj.put("result", true);
			jObj.put("message", "사용 가능한 이메일입니다.");
			jObj.put("email", email);
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
