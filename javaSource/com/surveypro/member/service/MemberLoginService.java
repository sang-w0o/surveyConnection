package com.surveypro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.MemberDAO;
import com.surveypro.dao.WithdrawDAO;
import com.surveypro.member.exception.MemberEmailEmptyException;
import com.surveypro.member.exception.MemberEmailNotFoundException;
import com.surveypro.member.exception.MemberPassEmptyException;
import com.surveypro.member.exception.MemberPassException;
import com.surveypro.member.exception.MemberWithdrawLoginException;
import com.surveypro.vo.MemberVO;

public class MemberLoginService implements IMemberService {

	private MemberDAO dao;
	private WithdrawDAO wdao;

	public MemberLoginService() {
		dao = (MemberDAO) DAOManager.getDAO(MemberDAO.KEY);
		wdao = (WithdrawDAO) DAOManager.getDAO(WithdrawDAO.KEY);
	}

	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberVO m = null;
		HttpSession session = null;

		String email = (String) request.getParameter("email");
		String pass = (String) request.getParameter("pass");

		if (email == null || email.trim().equals("")) {
			throw new MemberEmailEmptyException();
		}
		if (pass == null || pass.trim().equals("")) {
			throw new MemberPassEmptyException();
		}

		// 탈퇴회원 체크
		synchronized (wdao) {
			if (wdao.isWithdrawed(email)) {
				if (wdao.isRegisterable(email)) {
					synchronized (dao) {
						if (!dao.checkEmail(email)) {
							if (dao.checkPassword(email, pass)) {

								// 이메일, 패스워드 일치
								m = dao.getMember(email, pass);
								session = request.getSession();
								m.setPass(pass);
								m.setEmail(email);
								session.setAttribute("result", true);
								session.setAttribute("userInfo", m);

								// 포인트 출력을 위해서
								session.setAttribute("point", dao.getPoint(email));
							} else {
								// 패스워드 일치안함
								throw new MemberPassException();
							}
						} else {
							// 이메일 존재 안함
							throw new MemberEmailNotFoundException();
						}
					}
				} else {
					throw new MemberWithdrawLoginException();
				}

			}

			else {
				synchronized (dao) {
					if (!dao.checkEmail(email)) {
						if (dao.checkPassword(email, pass)) {

							// 이메일, 패스워드 일치
							m = dao.getMember(email, pass);
							session = request.getSession();
							m.setPass(pass);
							session.setAttribute("result", true);
							session.setAttribute("userInfo", m);

							// 포인트 출력을 위해서
							session.setAttribute("point", dao.getPoint(email));
						} else {
							// 패스워드 일치안함
							throw new MemberPassException();
						}
					} else {
						// 이메일 존재 안함
						throw new MemberEmailNotFoundException();
					}
				}
			}
		}
	}
}
