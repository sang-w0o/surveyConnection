package com.surveypro.survey.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.SurveyInfoDAO;
import com.surveypro.survey.exception.SurveyGetEndSurveyException;
import com.surveypro.vo.SurveyInfoVO;

public class SurveyGetClosedListService implements ISurveyService {

	private SurveyInfoDAO dao;

	public SurveyGetClosedListService() {
		dao = (SurveyInfoDAO) DAOManager.getDAO(SurveyInfoDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<SurveyInfoVO> endSurveyList = null;

		synchronized (dao) {

			endSurveyList = dao.getClosedSurveyList();
			if (endSurveyList == null) {
				throw new SurveyGetEndSurveyException();
			} else {
				request.setAttribute("endSurveyList", endSurveyList);
			}
		}

	}

}
