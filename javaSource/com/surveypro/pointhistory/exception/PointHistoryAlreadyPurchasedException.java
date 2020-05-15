package com.surveypro.pointhistory.exception;

public class PointHistoryAlreadyPurchasedException extends PointHistoryException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 4;
	private static final String MESSAGE = "�ѹ� ������ ������ �ٽ� ������ �� �����ϴ�.";

	public PointHistoryAlreadyPurchasedException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
