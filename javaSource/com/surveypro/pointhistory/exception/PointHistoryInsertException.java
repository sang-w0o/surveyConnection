package com.surveypro.pointhistory.exception;

public class PointHistoryInsertException extends PointHistoryException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 1;
	private static final String MESSAGE = "����Ʈ ���� ���Կ� �����߽��ϴ�.";

	public PointHistoryInsertException() {
		super(ERRNO, MESSAGE);
	}

	public void doException() {

	}
}
