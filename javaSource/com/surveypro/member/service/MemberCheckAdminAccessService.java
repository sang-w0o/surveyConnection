package com.surveypro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surveypro.member.exception.MemberAdminAccessException;
import com.surveypro.vo.MemberVO;

public class MemberCheckAdminAccessService implements IMemberService {

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("userInfo") == null) {
			throw new MemberAdminAccessException();
		} else {
			MemberVO m = (MemberVO) session.getAttribute("userInfo");
			if (!m.getEmail().equals("admin@surveypro.com")) {
				throw new MemberAdminAccessException();
			}
		}

	}

}
