package com.surveypro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.AdminDAO;
import com.surveypro.member.exception.MemberUpdateAllException;

public class MemberUpdateAllService implements IMemberService {

	private AdminDAO dao;

	public MemberUpdateAllService() {
		dao = (AdminDAO) DAOManager.getDAO(AdminDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		synchronized (dao) {

			if (dao.updateAllMembers()) {

			} else {
				throw new MemberUpdateAllException();
			}
		}

	}

}
