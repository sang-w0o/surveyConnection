package com.surveypro.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.member.service.IMemberService;
import com.surveypro.member.service.MemberMyPageUpdateService;

public class MemberMyPageUpdateController implements MemberBackController {
	private IMemberService service;

	public MemberMyPageUpdateController() {
		service = new MemberMyPageUpdateService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj = new JSONObject();

		try {
			service.doService(request, response);
			int point = (Integer) request.getAttribute("point");
			String email = (String) request.getAttribute("email");
			jObj.put("result", true);
			jObj.put("point", point);
			jObj.put("email", email);

		} catch (Exception e) {
			jObj.put("result", false);
			jObj.put("point", -1);
		}

		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			out = response.getWriter();
			out.println(jObj.toJSONString());
		} catch (Exception e) {

		}
	}

}
