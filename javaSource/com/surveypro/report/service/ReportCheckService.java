package com.surveypro.report.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.ReportDAO;
import com.surveypro.report.exception.ReportCheckException;
import com.surveypro.vo.ReportVO;

public class ReportCheckService implements IReportService {

	private ReportDAO dao;

	public ReportCheckService() {
		dao = (ReportDAO) DAOManager.getDAO(ReportDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String reporter = request.getParameter("reporter");
		int s_code = Integer.parseInt(request.getParameter("s_code"));

		ReportVO r = new ReportVO();
		r.setReporter(reporter);
		r.setS_code(s_code);

		if (dao.checkIfAlreadyExists(r)) {
			throw new ReportCheckException();
		}

	}

}
