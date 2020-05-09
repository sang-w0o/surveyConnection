package com.surveypro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.MemberDAO;
import com.surveypro.member.exception.MemberNickAlreadyInUseException;
import com.surveypro.member.exception.MemberNickEmptyException;

public class MemberNickCheckService implements IMemberService {

	private MemberDAO dao;

	public MemberNickCheckService() {
		dao = (MemberDAO) DAOManager.getDAO(MemberDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nick = (String) request.getParameter("nick");

		if (nick == null || nick.trim().equals("")) {
			throw new MemberNickEmptyException();
		}
		synchronized (dao) {
			if (dao.checkNick(nick)) {
				request.setAttribute("nick", nick);
			} else {
				throw new MemberNickAlreadyInUseException();
			}
		}
	}

}
