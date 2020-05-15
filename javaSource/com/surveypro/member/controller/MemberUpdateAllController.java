package com.surveypro.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.member.service.IMemberService;
import com.surveypro.member.service.MemberUpdateAllService;

public class MemberUpdateAllController implements MemberBackController {

	private IMemberService service;

	public MemberUpdateAllController() {
		service = new MemberUpdateAllService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj = new JSONObject();
		try {
			service.doService(request, response);
			jObj.put("result", true);
			jObj.put("message", "ȸ�� ��� ���ſ� �����߽��ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
			jObj.put("result", false);
			jObj.put("message", "ȸ�� ��� ���ſ� �����߽��ϴ�.");
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
