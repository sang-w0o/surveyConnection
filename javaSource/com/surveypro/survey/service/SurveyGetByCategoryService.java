package com.surveypro.survey.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.SurveyInfoDAO;
import com.surveypro.vo.SurveyInfoVO;

public class SurveyGetByCategoryService implements ISurveyService {

	private SurveyInfoDAO dao;

	public static final int PAGESIZE = 10;

	public SurveyGetByCategoryService() {
		dao = (SurveyInfoDAO) DAOManager.getDAO(SurveyInfoDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String strPage = request.getParameter("page");
		String mode = request.getParameter("mode");
		String c_code = request.getParameter("c_code");

		int page = 1;
		try {
			if (strPage != null) {
				page = Integer.parseInt(strPage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		c_code = (c_code == null) ? "" : c_code;
		mode = (mode == null) ? "" : mode;
		synchronized (dao) {
			int totalRecord = dao.getTotalCountByCategory(c_code);
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
			ArrayList<SurveyInfoVO> surveys = dao.getSurveyByCategory(page, PAGESIZE, c_code);
			request.setAttribute("page", page);
			request.setAttribute("c_code", c_code);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("surveys", surveys);
		}
	}

}
