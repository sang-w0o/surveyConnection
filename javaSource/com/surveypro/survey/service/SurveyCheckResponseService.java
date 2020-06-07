package com.surveypro.survey.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.ChoiceResultDAO;
import com.surveypro.dao.SubjectiveResultDAO;
import com.surveypro.dao.SurveyDAO;

public class SurveyCheckResponseService implements ISurveyService {

	private ChoiceResultDAO cdao;
	private SubjectiveResultDAO sdao;
	private SurveyDAO surveyDao;

	public SurveyCheckResponseService() {
		cdao = (ChoiceResultDAO) DAOManager.getDAO(ChoiceResultDAO.KEY);
		sdao = (SubjectiveResultDAO) DAOManager.getDAO(SubjectiveResultDAO.KEY);
		surveyDao = (SurveyDAO) DAOManager.getDAO(SurveyDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int s_code = Integer.parseInt(request.getParameter("s_code"));
		String resp = (String) request.getParameter("respondent");
		boolean res;
		boolean res1;
		boolean res2;

		synchronized (surveyDao) {
			res = surveyDao.isWriterOfSurvey(s_code, resp);
		}

		synchronized (cdao) {
			res1 = cdao.checkChoiceResult(s_code, resp);
		}

		synchronized (sdao) {
			res2 = sdao.checkSubjectiveResult(s_code, resp);
		}

		// 해당 설문에 이미 참여함

		if (res) {
			request.setAttribute("res", "writerOfSurvey");
			return;
		}

		if (res1 == true || res2 == true) {
			request.setAttribute("res", "t");
		}
		// 해당 설문에 참여한 적 없음
		else {
			request.setAttribute("res", "f");
		}
	}
}
