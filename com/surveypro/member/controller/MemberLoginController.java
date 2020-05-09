package com.surveypro.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.member.service.IMemberService;
import com.surveypro.member.service.MemberLoginService;

public class MemberLoginController implements MemberBackController {

	private IMemberService service;

	public MemberLoginController() {
		service = new MemberLoginService();
	}

	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj = new JSONObject();

		try {
			service.doService(request, response);
			jObj.put("errno", 0);
			jObj.put("message", "�α����� �Ϸ�Ǿ����ϴ�");
		} catch (Exception e) {
			// �̸��϶�, ��й�ȣ���� ����ְų�
			// �̸����� �������� �ʰų�
			// ��й�ȣ�� ��ġ���� �ʴ� ���
			jObj.put("errno", 1);
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