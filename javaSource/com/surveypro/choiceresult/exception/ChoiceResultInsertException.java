package com.surveypro.choiceresult.exception;

public class ChoiceResultInsertException extends ChoiceResultException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 1;
	private static final String MESSAGE = "������ ����� �����ϴ� ���� ������ �߻��߽��ϴ�.";

	public ChoiceResultInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
