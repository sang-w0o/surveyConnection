package com.surveypro.pointhistory.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.MemberDAO;
import com.surveypro.dao.PointHistoryDAO;
import com.surveypro.dao.SurveyDAO;
import com.surveypro.vo.PointHistoryVO;
import com.surveypro.vo.SurveyVO;

public class PointHistoryGetListService implements IPointHistoryService {
	private PointHistoryDAO phdao;
	private SurveyDAO sdao;
	private MemberDAO mdao;

	public PointHistoryGetListService() {
		phdao = (PointHistoryDAO) DAOManager.getDAO(PointHistoryDAO.KEY);
		sdao = (SurveyDAO) DAOManager.getDAO(SurveyDAO.KEY);
		mdao = (MemberDAO) DAOManager.getDAO(MemberDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		HashMap<String, String> pointHis = null;
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		synchronized (phdao) {
			ArrayList<PointHistoryVO> list1 = phdao.getHistoryByEmail(email);
			for (PointHistoryVO p : list1) {
				synchronized (sdao) {
					pointHis = new HashMap<>();
					SurveyVO s = sdao.getHisSurvey(p.getS_code());
					pointHis.put("email", email);
					pointHis.put("s_title", s.getS_title());
					pointHis.put("ph_type", p.getPh_type());
					pointHis.put("pointchange", p.getPointchange() + "");
					list.add(pointHis);
				}
			}
			request.setAttribute("list", list);
		}
		synchronized (mdao) {
			int totalPoint = mdao.getPoint(email);
			request.setAttribute("totalPoint", totalPoint);
		}
	}
}
