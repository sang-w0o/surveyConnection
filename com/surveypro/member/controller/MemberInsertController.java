package com.surveypro.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.member.service.IMemberService;
import com.surveypro.member.service.MemberInsertService;
import com.surveypro.vo.MemberVO;

public class MemberInsertController implements MemberBackController {
	private IMemberService service;

	public MemberInsertController() {
		service = new MemberInsertService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jObj = new JSONObject();
		try {
			service.doService(request, response);
			MemberVO member = (MemberVO) request.getAttribute("member");
			jObj.put("result", true);
			jObj.put("message", "회원가입에 성공했습니다.");
			jObj.put("member", member.convertMap());
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
			out.println(jObj.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
