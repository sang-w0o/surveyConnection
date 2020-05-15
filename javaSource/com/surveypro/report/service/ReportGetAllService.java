package com.surveypro.report.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.ReportDAO;
import com.surveypro.vo.ReportVO;

public class ReportGetAllService implements IReportService {

	private ReportDAO dao;

	public ReportGetAllService() {
		dao = (ReportDAO) DAOManager.getDAO(ReportDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		synchronized (dao) {
			ArrayList<ReportVO> reports = dao.getAllReports();
			request.setAttribute("reports", reports);
		}
	}

}
