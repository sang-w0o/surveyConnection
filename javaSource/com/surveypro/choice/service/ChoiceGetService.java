package com.surveypro.choice.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.ChoiceDAO;
import com.surveypro.vo.ChoiceVO;

public class ChoiceGetService implements IChoiceService {

	private ChoiceDAO dao;
	
	public ChoiceGetService() {
		dao = (ChoiceDAO)DAOManager.getDAO("ChoiceDAO");
	}
	
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
	
		ArrayList<ChoiceVO> list = null;
		int s_code = Integer.parseInt(request.getParameter("s_code"));
		int q_number = Integer.parseInt(request.getParameter("q_number"));
		
		synchronized (dao) {
			list = dao.getChoice(s_code, q_number);
		}
		
		request.setAttribute("list", list);
	}
}
