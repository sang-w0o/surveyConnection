package com.surveypro.pointhistory.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.DAOManager;
import com.surveypro.dao.PointHistoryDAO;
import com.surveypro.pointhistory.exception.PointHistoryAlreadyPurchasedException;
import com.surveypro.pointhistory.exception.PointHistoryBuyAndSellException;
import com.surveypro.pointhistory.exception.PointHistoryNotEnoughPointException;
import com.surveypro.pointhistory.exception.PointHistoryWriterIsBuyerException;

public class PointHistoryBuyAndSellService implements IPointHistoryService {

	private PointHistoryDAO dao;

	public PointHistoryBuyAndSellService() {
		dao = (PointHistoryDAO) DAOManager.getDAO(PointHistoryDAO.KEY);
	}

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String buyer = request.getParameter("buyer");
		String seller = request.getParameter("seller");
		int s_code = Integer.parseInt(request.getParameter("s_code"));
		int price = Integer.parseInt(request.getParameter("price"));

		synchronized (dao) {

			if (dao.isWriterOfSurvey(s_code, buyer)) {
				throw new PointHistoryWriterIsBuyerException();
			}
			if (dao.isAlreadyPurchased(buyer, s_code)) {
				throw new PointHistoryAlreadyPurchasedException();
			} else {
				if (dao.isBuyable(buyer, price)) {
					if (dao.purchase(seller, buyer, s_code, price)) {

					} else {
						throw new PointHistoryBuyAndSellException();
					}
				} else {
					throw new PointHistoryNotEnoughPointException();
				}
			}
		}

	}

}
