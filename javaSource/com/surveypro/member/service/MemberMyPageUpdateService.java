package com.surveypro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.MemberDAO;
import com.surveypro.member.exception.MemberLoginCheckException;
import com.surveypro.vo.MemberVO;

public class MemberMyPageUpdateService implements IMemberService {

	private MemberDAO mdao;

	public MemberMyPageUpdateService() {
		mdao = (MemberDAO) DAOManager.getDAO(MemberDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		MemberVO m1 = (MemberVO) session.getAttribute("userInfo");
		if (m1 == null) {
			throw new MemberLoginCheckException();
		}

//		int point = (Integer) request.getAttribute("point");
//		request.setAttribute("point", point);

		synchronized (mdao) {
			int point = mdao.getPoint(m1.getEmail());
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("point", point);
			request.setAttribute("email", m1.getEmail());

		}

	}

}
