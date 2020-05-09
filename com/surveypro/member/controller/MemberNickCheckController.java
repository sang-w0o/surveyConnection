package com.surveypro.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.member.service.IMemberService;
import com.surveypro.member.service.MemberNickCheckService;

public class MemberNickCheckController implements MemberBackController {

	private IMemberService service;

	public MemberNickCheckController() {
		service = new MemberNickCheckService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj = new JSONObject();
		try {
			service.doService(request, response);
			String nick = (String) request.getAttribute("nick");
			jObj.put("result", true);
			jObj.put("message", "사용 가능한 별명입니다.");
			jObj.put("nick", nick);
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
