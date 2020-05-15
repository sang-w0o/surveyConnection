package com.surveypro.question.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.QuestionDAO;
import com.surveypro.vo.QuestionVO;

public class QuestionGetService implements IQuestionService {

	private QuestionDAO dao;
	
	public QuestionGetService() {
		dao = (QuestionDAO)DAOManager.getDAO("QuestionDAO");
	}
	
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
	
		ArrayList<QuestionVO> list = null;
		int s_code = Integer.parseInt(request.getParameter("s_code"));
		
		synchronized (dao) {
			list = dao.getQuestion(s_code);
		}
		
		request.setAttribute("list", list);
	}
}
