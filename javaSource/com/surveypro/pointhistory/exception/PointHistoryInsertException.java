package com.surveypro.pointhistory.exception;

public class PointHistoryInsertException extends PointHistoryException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 1;
	private static final String MESSAGE = "포인트 내역 삽입에 실패했습니다.";

	public PointHistoryInsertException() {
		super(ERRNO, MESSAGE);
	}

	public void doException() {

	}
}
