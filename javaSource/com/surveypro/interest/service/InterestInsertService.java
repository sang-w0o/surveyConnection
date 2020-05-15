package com.surveypro.interest.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.InterestDAO;
import com.surveypro.interest.exception.InterestInsertException;
import com.surveypro.vo.InterestVO;

public class InterestInsertService implements IInterestService {

	private InterestDAO dao;

	public InterestInsertService() {
		dao = (InterestDAO) DAOManager.getDAO(InterestDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int s_code = Integer.parseInt(request.getParameter("s_code"));
		String email = request.getParameter("email");

		InterestVO i = new InterestVO();
		i.setS_code(s_code);
		i.setEmail(email);

		synchronized (dao) {
			if (dao.insert(i)) {

			} else {
				throw new InterestInsertException();
			}
		}

	}

}
