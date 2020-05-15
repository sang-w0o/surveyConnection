package com.surveypro.survey.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.CategoryDAO;
import com.surveypro.dao.SurveyDAO;
import com.surveypro.vo.SurveyVO;

public class SurveyGetBySurveyCodeService implements ISurveyService {
	
	private SurveyDAO sdao;
	private CategoryDAO cdao;
	
	public SurveyGetBySurveyCodeService() {
		sdao = (SurveyDAO)DAOManager.getDAO("SurveyDAO");
		cdao = (CategoryDAO)DAOManager.getDAO("CategoryDAO");
	}
	
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		int s_code = Integer.parseInt(request.getParameter("s_code"));
		SurveyVO s = null;
		String c_code = null;
		String c_desc = null;
		
		synchronized (sdao) {
			s = sdao.getSurvey(s_code);
			c_code = s.getC_code();
		}
		synchronized (cdao) {
			c_desc = cdao.getDesc(c_code);
		}
		request.setAttribute("SurveyVO", s);
		request.setAttribute("c_desc", c_desc);
	}
}
