package com.surveypro.survey.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.SurveyDAO;
import com.surveypro.survey.exception.SurveyInsertCheckException;
import com.surveypro.vo.MemberVO;

public class SurveyInsertCheckService implements ISurveyService {

	private SurveyDAO dao;

	public SurveyInsertCheckService() {
		dao = (SurveyDAO) DAOManager.getDAO(SurveyDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberVO member = (MemberVO) request.getSession(false).getAttribute("userInfo");
		String email = member.getEmail();

		synchronized (dao) {
			if (dao.isRegisterable(email)) {

			} else {
				throw new SurveyInsertCheckException();
			}
		}

	}

}
