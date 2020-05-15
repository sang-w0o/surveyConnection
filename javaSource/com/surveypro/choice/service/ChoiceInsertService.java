package com.surveypro.choice.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.choice.exception.ChoiceInsertException;
import com.surveypro.controller.DAOManager;
import com.surveypro.dao.ChoiceDAO;
import com.surveypro.dao.SurveyDAO;
import com.surveypro.vo.ChoiceVO;

public class ChoiceInsertService implements IChoiceService {

	private ChoiceDAO cdao;
	private SurveyDAO sdao;
	
	public ChoiceInsertService() {
		cdao = (ChoiceDAO)DAOManager.getDAO(ChoiceDAO.KEY);
		sdao = (SurveyDAO)DAOManager.getDAO(SurveyDAO.KEY);
	}
	
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] choiceList = request.getParameterValues("choiceList[]");
		int q_number = Integer.parseInt(choiceList[0]);
		int count = choiceList.length;
		
		synchronized (sdao) {
			int s_code = sdao.getLastS_code();
		
			for (int i = 1; i < count; i++) {
				ChoiceVO ci = new ChoiceVO();
				ci.setS_code(s_code);
				ci.setQ_number(q_number);
				ci.setChoice_num(i);
				ci.setChoice_content(choiceList[i]);
				
				synchronized (cdao) {
					if (cdao.insert(ci)) {}
					else {
						throw new ChoiceInsertException();
					}
				}
			}
		}
	}

}
