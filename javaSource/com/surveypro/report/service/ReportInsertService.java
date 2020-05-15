package com.surveypro.report.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.ReportDAO;
import com.surveypro.report.exception.ReportInsertException;
import com.surveypro.vo.ReportVO;

public class ReportInsertService implements IReportService {

	private ReportDAO dao;

	public ReportInsertService() {
		dao = (ReportDAO) DAOManager.getDAO(ReportDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String cause = request.getParameter("cause");
		String reporter = request.getParameter("reporter");
		int s_code = Integer.parseInt(request.getParameter("s_code"));

		ReportVO v = new ReportVO();
		v.setCause(cause);
		v.setReporter(reporter);
		v.setS_code(s_code);

		synchronized (dao) {
			if (dao.insert(v)) {

			} else {
				throw new ReportInsertException();
			}
		}

	}

}
