package com.surveypro.report.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.surveypro.report.service.IReportService;
import com.surveypro.report.service.ReportApproveService;

public class ReportApproveController implements ReportBackController {

	private IReportService service;

	public ReportApproveController() {
		service = new ReportApproveService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj = new JSONObject();
		try {
			service.doService(request, response);
			jObj.put("result", true);
			jObj.put("message", "신고 승인 처리에 성공했습니다.");
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
