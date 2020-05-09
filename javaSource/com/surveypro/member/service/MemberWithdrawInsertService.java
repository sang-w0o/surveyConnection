package com.surveypro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.MemberDAO;
import com.surveypro.dao.WithdrawDAO;
import com.surveypro.member.exception.MemberPassException;
import com.surveypro.member.exception.MemberWithdrawInsertException;
import com.surveypro.vo.MemberVO;

public class MemberWithdrawInsertService implements IMemberService {

	private MemberDAO mdao;
	private WithdrawDAO wdao;

	public MemberWithdrawInsertService() {
		mdao = (MemberDAO) DAOManager.getDAO(MemberDAO.KEY);
		wdao = (WithdrawDAO) DAOManager.getDAO(WithdrawDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		String pass = (String) request.getParameter("pass");
		MemberVO m = (MemberVO) session.getAttribute("userInfo");

		synchronized (mdao) {
			if (mdao.checkPassword(m.getEmail(), pass)) {
				synchronized (wdao) {
					if (wdao.insert(m.getEmail())) {
						request.setAttribute("withdrawResult", true);
						// session.invalidate();
					} else {
						throw new MemberWithdrawInsertException();
					}
				}
			} else {
				throw new MemberPassException();
			}
		}
	}

}
