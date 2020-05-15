package com.surveypro.pointhistory.exception;

public class PointHistoryWriterIsBuyerException extends PointHistoryException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 1;
	private static final String MESSAGE = "본인이 작성한 설문은 구매할 수 없습니다.";

	public PointHistoryWriterIsBuyerException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
