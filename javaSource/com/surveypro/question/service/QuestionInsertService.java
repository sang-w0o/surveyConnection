package com.surveypro.question.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.QuestionDAO;
import com.surveypro.question.exception.QuestionInsertException;
import com.surveypro.vo.QuestionVO;

public class QuestionInsertService implements IQuestionService {

	private QuestionDAO qdao;
	
	public QuestionInsertService() {
		qdao = (QuestionDAO)DAOManager.getDAO(QuestionDAO.KEY);
	}
	
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] qList = request.getParameterValues("qList[]");
		String[] qListType = request.getParameterValues("qListType[]");
		int s_code = Integer.parseInt(request.getParameter("s_code"));
		int count = qList.length;
		
		synchronized (qdao) {
			for (int i = 0; i < count; i++) {
				QuestionVO q = new QuestionVO();
				q.setS_code(s_code);
				q.setQ_number(i+1);
				q.setQ_title(qList[i]);
				q.setQ_type(qListType[i]);
				if (qdao.insert(q)) {}
				else {
					throw new QuestionInsertException();
				}
			}
		}
	}
}
