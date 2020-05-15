package com.surveypro.pointhistory.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.PointHistoryDAO;
import com.surveypro.pointhistory.exception.PointHistoryInsertException;
import com.surveypro.vo.PointHistoryVO;

public class PointHistoryInsertRespondentService implements IPointHistoryService {

	private PointHistoryDAO dao;

	public PointHistoryInsertRespondentService() {
		dao = (PointHistoryDAO) DAOManager.getDAO(PointHistoryDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int s_code = Integer.parseInt(request.getParameter("s_code"));
		String email = request.getParameter("respondent");

		PointHistoryVO phv = new PointHistoryVO();
		phv.setS_code(s_code);
		phv.setEmail(email);

		synchronized (dao) {
			if (dao.insertFivePoints(phv)) {

			} else {
				throw new PointHistoryInsertException();
			}
		}

	}

}
