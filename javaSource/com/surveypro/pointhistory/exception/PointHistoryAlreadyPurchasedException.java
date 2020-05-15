package com.surveypro.pointhistory.exception;

public class PointHistoryAlreadyPurchasedException extends PointHistoryException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 4;
	private static final String MESSAGE = "한번 구매한 설문은 다시 구매할 수 없습니다.";

	public PointHistoryAlreadyPurchasedException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
