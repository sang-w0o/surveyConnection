package com.surveypro.pointhistory.exception;

public class PointHistoryBuyAndSellException extends PointHistoryException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 2;
	private static final String MESSAGE = "���� ��û ó���� �����߽��ϴ�.";

	public PointHistoryBuyAndSellException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
