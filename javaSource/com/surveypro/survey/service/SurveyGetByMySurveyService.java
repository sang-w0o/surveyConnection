package com.surveypro.survey.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.SurveyInfoDAO;
import com.surveypro.vo.MemberVO;
import com.surveypro.vo.SurveyInfoVO;

public class SurveyGetByMySurveyService implements ISurveyService {
	private SurveyInfoDAO dao;

	public static final int PAGESIZE = 10;

	public SurveyGetByMySurveyService() {
		dao = (SurveyInfoDAO)DAOManager.getDAO(SurveyInfoDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		MemberVO m = (MemberVO)session.getAttribute("userInfo");
		String email = m.getEmail();
		
		String strPage = request.getParameter("page");
		String mode = request.getParameter("mode");

		int page = 1;
		try {
			if (strPage != null) {
				page = Integer.parseInt(strPage);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		mode = (mode == null) ? "" : mode;
		
		synchronized (dao) {
			int totalRecord = 0;
			String myType = (String)request.getParameter("myType");
			switch (myType) {
			case "MY":
				totalRecord = dao.getTotalCountByMySurvey(email);
				break;
			case "MY1":
				totalRecord = dao.getTotalCountByMyEndSurvey(email);
				break;
			case "inter":
				totalRecord = dao.getTotalCountByMyInterest(email);
				break;
			case "inter1":
				totalRecord = dao.getTotalCountByMyEndInterest(email);
				break;
			case "phar":
				totalRecord = dao.getTotalCountByMyPurchase(email);
				break;
			}
			
			int pageCount = (int) Math.ceil((double) totalRecord / PAGESIZE);

			switch (mode) {
			case "first":
				page = 1;
				break;
			case "last":
				page = pageCount;
				break;
			case "prev":
				if (--page < 1)
					page = 1;
				break;
			case "next":
				if (++page > pageCount) {
					page = pageCount;
				}
				break;
			default:
				if (page < 1)
					page = 1;
				if (page > pageCount)
					page = pageCount;
				break;
			}
		
			ArrayList<SurveyInfoVO> surveys = null;
			switch (myType) {
			case "MY":
				surveys = dao.getSurveyByMySurvey(page, PAGESIZE, email);
				break;
			case "MY1":
				surveys = dao.getSurveyByMyEndSurvey(pageCount, PAGESIZE, email);
				break;
			case "inter":
				surveys = dao.getSurveyByMyInterest(pageCount, PAGESIZE, email);
				break;
			case "inter1":
				surveys = dao.getSurveyByMyEndInterest(pageCount, PAGESIZE, email);
				break;
			case "phar":
				surveys = dao.getSurveyByMyPurchase(pageCount, PAGESIZE, email);
				break;
			}
			
			request.setAttribute("email", email);
			request.setAttribute("page", page);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("surveys", surveys);
		}
	}
}
