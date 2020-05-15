package com.surveypro.pointhistory.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.surveypro.pointhistory.service.PointHistoryGetListService;
import com.surveypro.service.IService;

public class PointHistoryGetListController implements PointHistoryBackController {
	IService service = new PointHistoryGetListService();

	@Override
	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		JSONObject jObj = new JSONObject();
		JSONArray jAry = new JSONArray();
		try {
			service.doService(request, response);
			ArrayList<HashMap<String, String>> aList = (ArrayList<HashMap<String, String>>) request
					.getAttribute("list");
			for (HashMap<String, String> list : aList) {
				JSONObject jtemp = new JSONObject();
				jtemp.putAll(list);
				jAry.add(jtemp);
			}
			jObj.put("list", jAry);

			int totalPoint = (Integer) request.getAttribute("totalPoint");
			jObj.put("totalPoint", totalPoint);
		} catch (Exception e) {
			e.printStackTrace();
		}

		PrintWriter out = null;
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			out = response.getWriter();
			out.println(jObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
