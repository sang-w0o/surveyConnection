package com.surveypro.survey.exception;

public class SurveyGetEndSurveyException extends SurveyException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 6;
	private static final String MESSAGE = "������ ������ �о���� �� ������ �߻��߽��ϴ�.";

	public SurveyGetEndSurveyException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
