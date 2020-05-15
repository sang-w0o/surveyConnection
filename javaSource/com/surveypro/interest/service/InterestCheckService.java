package com.surveypro.interest.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.InterestDAO;
import com.surveypro.interest.exception.InterestCheckException;
import com.surveypro.vo.InterestVO;

public class InterestCheckService implements IInterestService {

	private InterestDAO dao;

	public InterestCheckService() {
		dao = (InterestDAO) DAOManager.getDAO(InterestDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String email = request.getParameter("email");
		int s_code = Integer.parseInt(request.getParameter("s_code"));

		InterestVO i = new InterestVO();
		i.setEmail(email);
		i.setS_code(s_code);

		if (dao.checkIfAlreadyExists(i)) {
			throw new InterestCheckException();
		}

	}

}
