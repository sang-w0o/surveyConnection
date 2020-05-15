package com.surveypro.survey.exception;

public class SurveyCheckResponseException extends SurveyException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 10;
	public static final String MESSAGE = "해당 설문에 이미 참여했습니다.";

	public SurveyCheckResponseException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}
}
