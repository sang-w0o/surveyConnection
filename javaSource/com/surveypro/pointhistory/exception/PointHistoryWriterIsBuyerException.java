package com.surveypro.pointhistory.exception;

public class PointHistoryWriterIsBuyerException extends PointHistoryException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 1;
	private static final String MESSAGE = "������ �ۼ��� ������ ������ �� �����ϴ�.";

	public PointHistoryWriterIsBuyerException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
