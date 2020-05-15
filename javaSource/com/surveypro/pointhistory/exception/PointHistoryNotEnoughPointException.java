package com.surveypro.pointhistory.exception;

public class PointHistoryNotEnoughPointException extends PointHistoryException {
	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 3;
	private static final String MESSAGE = "해당 설문 결과를 구매하기 위한 잔여 포인트가 부족합니다.";

	public PointHistoryNotEnoughPointException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
