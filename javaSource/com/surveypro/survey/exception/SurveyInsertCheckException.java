package com.surveypro.survey.exception;

public class SurveyInsertCheckException extends SurveyException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 5;
	private static final String MESSAGE = "���� ������ �ۼ��� �� �����ϴ�.\n Ÿ���� ������ �����Ͽ� �ۼ� ȸ���� �ø�����!";

	public SurveyInsertCheckException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
