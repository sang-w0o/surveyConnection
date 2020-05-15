package com.surveypro.subjectiveresult.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.SubjectiveResultDAO;
import com.surveypro.subjectiveresult.exception.SubjectiveResultInsertException;
import com.surveypro.vo.SubjectiveResultVO;

public class SubjectiveResultInsertService implements ISubjectiveResultService {

	private SubjectiveResultDAO dao;

	public SubjectiveResultInsertService() {
		dao = (SubjectiveResultDAO) DAOManager.getDAO(SubjectiveResultDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String[] answers = request.getParameterValues("answers[]");
		String[] q_numbers = request.getParameterValues("q_numbers[]");
		String respondent = request.getParameter("respondent");
		int s_code = Integer.parseInt(request.getParameter("s_code"));

		synchronized (dao) {
			for (int i = 0; i < answers.length; i++) {
				SubjectiveResultVO s = new SubjectiveResultVO();
				s.setS_code(s_code);
				s.setQ_number(Integer.parseInt(q_numbers[i]));
				s.setRespondent(respondent);
				s.setAnswer(answers[i]);
				if (dao.insert(s)) {

				} else {
					throw new SubjectiveResultInsertException();
				}
			}
		}

	}

}
