package com.surveypro.survey.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.ChoiceResultDAO;
import com.surveypro.dao.SubjectiveResultDAO;

public class SurveyCheckResponseService implements ISurveyService {
	
	private ChoiceResultDAO cdao;
	private SubjectiveResultDAO sdao;
	
	public SurveyCheckResponseService() {
		cdao = (ChoiceResultDAO)DAOManager.getDAO(ChoiceResultDAO.KEY);
		sdao = (SubjectiveResultDAO)DAOManager.getDAO(SubjectiveResultDAO.KEY);
	}
	
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		int s_code = Integer.parseInt(request.getParameter("s_code"));
		String resp = (String)request.getParameter("respondent");
		boolean res1;
		boolean res2;
		
		synchronized (cdao) {
			res1 = cdao.checkChoiceResult(s_code, resp);
		}
		
		synchronized (sdao) {
			res2 = sdao.checkSubjectiveResult(s_code, resp);
		}
	
		// �ش� ������ �̹� ������
		if (res1 == true || res2 == true) {
			request.setAttribute("res", "t");
		}
		// �ش� ������ ������ �� ����
		else {
			request.setAttribute("res", "f");
		}
	}
}
