package com.surveypro.survey.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.SurveyDAO;
import com.surveypro.survey.exception.SurveyPriceUpdateException;

public class SurveyPriceUpdateService implements ISurveyService {

	private SurveyDAO dao;

	public SurveyPriceUpdateService() {
		dao = (SurveyDAO) DAOManager.getDAO(SurveyDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int s_code = Integer.parseInt(request.getParameter("s_code"));

		if (dao.updatePrice(s_code)) {

		} else {
			throw new SurveyPriceUpdateException();
		}

	}

}
