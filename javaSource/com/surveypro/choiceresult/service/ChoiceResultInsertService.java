package com.surveypro.choiceresult.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.choiceresult.exception.ChoiceResultInsertException;
import com.surveypro.controller.DAOManager;
import com.surveypro.dao.ChoiceResultDAO;
import com.surveypro.vo.ChoiceResultVO;

public class ChoiceResultInsertService implements IChoiceResultService {

	private ChoiceResultDAO dao;

	public ChoiceResultInsertService() {
		dao = (ChoiceResultDAO) DAOManager.getDAO(ChoiceResultDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String[] choices = request.getParameterValues("choices[]");
		String[] q_numbers = request.getParameterValues("q_numbers[]");
		int s_code = Integer.parseInt(request.getParameter("s_code"));
		String respondent = request.getParameter("respondent");

		synchronized (dao) {
			for (int i = 0; i < choices.length; i++) {
				ChoiceResultVO c = new ChoiceResultVO();
				c.setRespondent(respondent);
				c.setS_code(s_code);
				c.setChoice_num(Integer.parseInt(choices[i]));
				c.setQ_number(Integer.parseInt(q_numbers[i]));
				if (dao.insert(c)) {

				} else {
					throw new ChoiceResultInsertException();
				}
			}
		}

	}

}
