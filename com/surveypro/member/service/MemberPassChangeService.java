package com.surveypro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.MemberDAO;
import com.surveypro.member.exception.MemberPassUpdateException;
import com.surveypro.vo.MemberVO;

public class MemberPassChangeService implements IMemberService {
	private MemberDAO mdao;

	public MemberPassChangeService() {
		mdao = (MemberDAO) DAOManager.getDAO(MemberDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		MemberVO m = (MemberVO) session.getAttribute("userInfo");
		String pass = (String) request.getParameter("changepass");

		synchronized (mdao) {
			if (mdao.updatePassword(m.getEmail(), pass)) {
				request.setAttribute("passChangeResult", true);
			} else {
				throw new MemberPassUpdateException();
			}
		}
	}

}
