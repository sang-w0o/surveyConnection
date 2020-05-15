package com.surveypro.report.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.ReportDAO;
import com.surveypro.report.exception.ReportRemoveException;

public class ReportRemoveService implements IReportService {

	private ReportDAO dao;

	public ReportRemoveService() {
		dao = (ReportDAO) DAOManager.getDAO(ReportDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int s_code = Integer.parseInt(request.getParameter("s_code"));

		synchronized (dao) {
			if (dao.removeReport(s_code)) {
				request.setAttribute("ReportRemoveResult", true);
			} else {
				throw new ReportRemoveException();
			}
		}

	}

}
