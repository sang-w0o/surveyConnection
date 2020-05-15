package com.surveypro.report.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.surveypro.report.service.IReportService;
import com.surveypro.report.service.ReportGetAllService;
import com.surveypro.vo.ReportVO;

public class ReportGetAllController implements ReportBackController {

	private IReportService service;

	public ReportGetAllController() {
		service = new ReportGetAllService();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		JSONObject jObj;
		PrintWriter out = null;
		try {
			service.doService(request, response);
			jObj = new JSONObject();
			jObj.put("result", true);
			jObj.put("message", "Fetching all reports completed.");
			ArrayList<ReportVO> reports = (ArrayList<ReportVO>) request.getAttribute("reports");
			JSONArray jAry = new JSONArray();
			for (ReportVO report : reports) {
				JSONObject jTemp = new JSONObject();
				jTemp.putAll(report.convertMap());
				jAry.add(jTemp);
			}
			jObj.put("reports", jAry);
		} catch (Exception e) {
			jObj = new JSONObject();
			jObj.put("result", false);
			jObj.put("message", "Fetching all reports failed.");
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		try {
			out = response.getWriter();
			out.println(jObj.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
