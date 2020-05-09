package com.surveypro.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.surveypro.member.service.IMemberService;
import com.surveypro.member.service.MemberPassChangeService;

public class MemberPassChangeController implements MemberBackController {

	public IMemberService service;

	public MemberPassChangeController() {
		service = new MemberPassChangeService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jObj = new JSONObject();
		try {
			HttpSession session = request.getSession();
			service.doService(request, response);
			jObj.put("result", false);
			jObj.put("message", "비밀 번호 변경이 완료되었습니다. 다시 로그인 하세요.");
			session.invalidate();
		} catch (Exception e) {
			jObj.put("result", false);
			jObj.put("message", e.getMessage());
			e.printStackTrace();
		}
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			out = response.getWriter();
			out.print(jObj.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
