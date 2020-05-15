package com.surveypro.pointhistory.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.pointhistory.service.IPointHistoryService;
import com.surveypro.pointhistory.service.PointHistoryInsertRespondentService;

public class PointHistoryInsertRespondentController implements PointHistoryBackController {

	private IPointHistoryService service;

	public PointHistoryInsertRespondentController() {
		service = new PointHistoryInsertRespondentService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj = new JSONObject();

		try {
			service.doService(request, response);
			jObj.put("result", true);
			jObj.put("message", "����Ʈ ���� ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
			jObj.put("result", false);
			jObj.put("message", "����Ʈ ���� ���Կ� �����߽��ϴ�.");
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
