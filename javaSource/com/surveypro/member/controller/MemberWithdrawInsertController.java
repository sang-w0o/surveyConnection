package com.surveypro.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.surveypro.member.service.IMemberService;
import com.surveypro.member.service.MemberWithdrawInsertService;

public class MemberWithdrawInsertController implements MemberBackController {
	private IMemberService service;

	public MemberWithdrawInsertController() {
		service = new MemberWithdrawInsertService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jObj = new JSONObject();
		try {
			HttpSession session = request.getSession();
			service.doService(request, response);
			jObj.put("result", true);
			jObj.put("message", "탈퇴 처리에 성공했습니다.");
			session.invalidate();
		} catch (Exception e) {
			jObj.put("result", false);
			jObj.put("message", e.getMessage());
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
