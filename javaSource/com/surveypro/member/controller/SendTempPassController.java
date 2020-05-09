package com.surveypro.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.member.service.IMemberService;
import com.surveypro.member.service.SendTempPassService;

public class SendTempPassController implements MemberBackController {

	private IMemberService service;

	public SendTempPassController() {
		service = new SendTempPassService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		JSONObject jObj = new JSONObject();
		try {
			service.doService(request, response);
//			boolean result = (Boolean) request.getAttribute("passUpdateResult");
			jObj.put("result", true);
			jObj.put("message", "�ӽ� ��й�ȣ�� ���۵Ǿ����ϴ�.");
		} catch (Exception e) {
			jObj.put("result", false);
			jObj.put("message", "���Ե��� ���� �̸��� �ּ��Դϴ�.");
			e.printStackTrace();
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
