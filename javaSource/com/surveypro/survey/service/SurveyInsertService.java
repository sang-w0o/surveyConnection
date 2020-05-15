package com.surveypro.survey.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.SurveyDAO;
import com.surveypro.survey.exception.SurveyInsertException;
import com.surveypro.vo.SurveyVO;

public class SurveyInsertService implements ISurveyService {

	private SurveyDAO dao;

	public SurveyInsertService() {
		dao = (SurveyDAO) DAOManager.getDAO(SurveyDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String s_title = request.getParameter("s_title");
		String email = request.getParameter("email");
		String c_code = request.getParameter("c_code");
		String s_public = request.getParameter("s_public");

		synchronized (dao) {
			int insertID = dao.getLastS_id(email) + 1;

			SurveyVO survey = new SurveyVO();

			survey.setS_title(s_title);
			survey.setEmail(email);
			survey.setC_code(c_code);
			survey.setS_public(s_public);

			if (dao.insert(survey, insertID)) {
				request.setAttribute("surveyInsertResult", true);
				request.setAttribute("s_code", dao.getLastS_code());
			} else {
				throw new SurveyInsertException();
			}
		}

	}

}
