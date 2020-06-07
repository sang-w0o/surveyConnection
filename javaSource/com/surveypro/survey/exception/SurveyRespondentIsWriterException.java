package com.surveypro.survey.exception;

public class SurveyRespondentIsWriterException extends SurveyException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 7;
	private static final String MESSAGE = "�ڱ� �ڽ��� �������� ������ �� �����ϴ�.";

	public SurveyRespondentIsWriterException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
