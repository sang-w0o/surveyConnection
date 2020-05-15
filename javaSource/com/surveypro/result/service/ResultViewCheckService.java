package com.surveypro.result.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.PointHistoryDAO;
import com.surveypro.result.exception.ResultNotViewableException;
import com.surveypro.vo.MemberVO;

public class ResultViewCheckService implements IResultService {

	private PointHistoryDAO dao;

	public ResultViewCheckService() {
		dao = (PointHistoryDAO) DAOManager.getDAO(PointHistoryDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);

		MemberVO m = (MemberVO) session.getAttribute("userInfo");
		if (m == null) {
			throw new ResultNotViewableException();
		}

		String email = m.getEmail();
		int s_code = Integer.parseInt(request.getParameter("s_code"));

		synchronized (dao) {

			if (dao.isViewable(email, s_code)) {

			} else {
				throw new ResultNotViewableException();
			}
		}

	}

}
