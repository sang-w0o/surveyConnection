package com.surveypro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surveypro.member.exception.MemberLogoutException;

public class MemberLogoutService implements IMemberService {

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			HttpSession session = request.getSession(false);
			session.setAttribute("result", false);
			session.invalidate();
		} catch (Exception e) {
			throw new MemberLogoutException();
		}
	}
}
