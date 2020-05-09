package com.surveypro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.MemberDAO;
import com.surveypro.member.exception.MemberEmailEmptyException;
import com.surveypro.member.exception.MemberInsertException;
import com.surveypro.member.exception.MemberNickEmptyException;
import com.surveypro.member.exception.MemberPassAndPassCheckException;
import com.surveypro.vo.MemberVO;

public class MemberInsertService implements IMemberService {

	private MemberDAO mdao;

	public MemberInsertService() {
		mdao = (MemberDAO) DAOManager.getDAO(MemberDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String email = (String) request.getParameter("email");
		String nick = (String) request.getParameter("nick");
		String pass1 = (String) request.getParameter("pass1");
		String pass2 = (String) request.getParameter("pass2");

		if (email == null || email.trim().equals("")) {
			throw new MemberEmailEmptyException();
		}
		if (nick == null || nick.trim().equals("")) {
			throw new MemberNickEmptyException();
		}
		if (pass1 == null || !pass1.equals(pass2)) {
			throw new MemberPassAndPassCheckException();
		}

		MemberVO member = new MemberVO();
		member.setEmail(email);
		member.setNick(nick);
		member.setPass(pass1);

		synchronized (mdao) {
			if (mdao.insert(member)) {
				request.setAttribute("member", member);
			} else {
				throw new MemberInsertException();
			}
		}
	}

}
