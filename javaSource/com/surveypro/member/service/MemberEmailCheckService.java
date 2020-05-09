package com.surveypro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.MemberDAO;
import com.surveypro.dao.WithdrawDAO;
import com.surveypro.member.exception.MemberEmailAlreadyInUseException;
import com.surveypro.member.exception.MemberEmailEmptyException;
import com.surveypro.member.exception.MemberNotRegisterableException;

public class MemberEmailCheckService implements IMemberService {

	private MemberDAO dao;
	private WithdrawDAO wdao;

	public MemberEmailCheckService() {
		dao = (MemberDAO) DAOManager.getDAO(MemberDAO.KEY);
		wdao = (WithdrawDAO) DAOManager.getDAO(WithdrawDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String email = (String) request.getParameter("email");

		if (email == null || email.trim().equals("")) {
			throw new MemberEmailEmptyException();
		}

		synchronized (wdao) {
			if (wdao.isWithdrawed(email)) {
				if (wdao.isRegisterable(email)) {
					if (wdao.delete(email)) {
						throw new Exception("�簡���� ���� '��й�ȣ ã��'���� '�ӽ� ��й�ȣ ����'�� Ŭ�����ּ���.");
					}
				} else {
					throw new MemberNotRegisterableException();
				}

			} else {
				synchronized (dao) {
					if (dao.checkEmail(email)) {
						request.setAttribute("email", email);
					} else {
						throw new MemberEmailAlreadyInUseException();
					}
				}
			}
		}
	}

}
