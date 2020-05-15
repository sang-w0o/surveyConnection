package com.surveypro.pointhistory.exception;

public class PointHistoryNotEnoughPointException extends PointHistoryException {
	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 3;
	private static final String MESSAGE = "�ش� ���� ����� �����ϱ� ���� �ܿ� ����Ʈ�� �����մϴ�.";

	public PointHistoryNotEnoughPointException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
