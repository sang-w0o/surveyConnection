package com.surveypro.survey.exception;

public class SurveyCheckResponseException extends SurveyException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 10;
	public static final String MESSAGE = "�ش� ������ �̹� �����߽��ϴ�.";

	public SurveyCheckResponseException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}
}
