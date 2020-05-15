package com.surveypro.report.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.ReportDAO;
import com.surveypro.report.exception.ReportApproveException;

public class ReportApproveService implements IReportService {

	private ReportDAO dao;

	public ReportApproveService() {
		dao = (ReportDAO) DAOManager.getDAO(ReportDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int s_code = Integer.parseInt(request.getParameter("s_code"));

		synchronized (dao) {
			if (dao.approveReport(s_code)) {
				request.setAttribute("ReportApproveResult", true);
			} else {
				throw new ReportApproveException();
			}
		}

	}

}
