package com.surveypro.choice.exception;

public class ChoiceInsertException extends ChoiceException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 100;
	public static final String MESSAGE = "������ ��Ͽ� �����߽��ϴ�.";

	public ChoiceInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}
}
