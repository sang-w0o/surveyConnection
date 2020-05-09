package com.surveypro.withdraw.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.WithdrawDAO;
import com.surveypro.vo.MemberVO;

public class WithdrawInsertService implements IWithdrawService {

	private WithdrawDAO wdao;

	public WithdrawInsertService() {
		wdao = (WithdrawDAO) DAOManager.getDAO(WithdrawDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		MemberVO m = (MemberVO) session.getAttribute("userInfo");
		String email = m.getEmail();
		synchronized (wdao) {
			if (wdao.insert(email)) {
				request.setAttribute("isWithdrawed", true);
			} else {
				throw new Exception("탈퇴 처리에 실패했습니다.");
			}
		}
	}

}
