package com.surveypro.interest.exception;

public class InterestCheckException extends InterestException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 2;
	private static final String MESSAGE = "�ѹ� ���� ����� ������ �ٽ� ���ɵ�� �� �� �����ϴ�.";

	public InterestCheckException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
