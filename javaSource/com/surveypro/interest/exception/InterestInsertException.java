package com.surveypro.interest.exception;

public class InterestInsertException extends InterestException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 1;
	private static final String MESSAGE = "���� ��� ó�� �� ������ �߻��߽��ϴ�.";

	public InterestInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
