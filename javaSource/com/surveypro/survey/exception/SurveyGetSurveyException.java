package com.surveypro.survey.exception;

public class SurveyGetSurveyException extends SurveyException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 6;
	public static final String MESSAGE = "설문 띄우기에 실패했습니다.";

	public SurveyGetSurveyException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}
}
