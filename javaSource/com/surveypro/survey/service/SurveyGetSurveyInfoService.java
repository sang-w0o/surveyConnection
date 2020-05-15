package com.surveypro.survey.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.SurveyInfoDAO;
import com.surveypro.vo.SurveyInfoVO;

public class SurveyGetSurveyInfoService implements ISurveyService {

	private SurveyInfoDAO dao;

	public SurveyGetSurveyInfoService() {
		dao = (SurveyInfoDAO) DAOManager.getDAO("SurveyInfoDAO");
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<SurveyInfoVO> list = null;
		String type = (String) request.getParameter("msg");

		synchronized (dao) {
			switch (type) {
			case "deadLine":
				list = dao.getSurveyInfoByDeadLine();
				break;
			case "spareSampleNum":
				list = dao.getSurveyInfoBySpareSampleNum();
				break;
			case "endSurvey":
				list = dao.getSurveyInfoByEndSurvey();
				break;
			default:
				break;
			}
		}

		request.setAttribute("list", list);
	}
}
