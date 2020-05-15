package com.surveypro.pointhistory.exception;

public class PointHistoryBuyAndSellException extends PointHistoryException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 2;
	private static final String MESSAGE = "구매 요청 처리에 실패했습니다.";

	public PointHistoryBuyAndSellException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
