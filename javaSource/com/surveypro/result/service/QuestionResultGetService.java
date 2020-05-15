package com.surveypro.result.service;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.CategoryDAO;
import com.surveypro.dao.QuestionDAO;
import com.surveypro.dao.QuestionResultDAO;
import com.surveypro.dao.SurveyDAO;
import com.surveypro.vo.QuestionResultVO;
import com.surveypro.vo.QuestionVO;
import com.surveypro.vo.SurveyVO;

public class QuestionResultGetService implements IResultService {
	private QuestionResultDAO qrdao;
	private QuestionDAO qdao;
	private SurveyDAO sdao;
	private CategoryDAO cdao;

	public QuestionResultGetService() {
		sdao = (SurveyDAO) DAOManager.getDAO(SurveyDAO.KEY);
		qdao = (QuestionDAO) DAOManager.getDAO(QuestionDAO.KEY);
		qrdao = (QuestionResultDAO) DAOManager.getDAO(QuestionResultDAO.KEY);
		cdao = (CategoryDAO) DAOManager.getDAO(CategoryDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int s_code = Integer.parseInt(request.getParameter("s_code"));
		ArrayList<QuestionResultVO> qrlist = new ArrayList<>();
		ArrayList<QuestionVO> list = qdao.getQuestion(s_code);
		Iterator<QuestionVO> qit = list.iterator();
		SurveyVO s = null;
		synchronized (sdao) {
			s = sdao.getSurvey(s_code);

			request.setAttribute("title", s.getS_title());
			request.setAttribute("email", s.getEmail());
			request.setAttribute("sample", sdao.getSample(s_code));
		}
		synchronized (cdao) {
			request.setAttribute("category", cdao.getDesc(s.getC_code()));
		}
		synchronized (qrdao) {
			while (qit.hasNext()) {
				QuestionVO q = qit.next();
				qrlist.add(qrdao.getQuestionResultVO(s_code, q.getQ_number()));
			}
			request.setAttribute("QuestionResult", qrlist);
		}
	}
}
