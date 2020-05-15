package com.surveypro.survey.exception;

public class SurveyGetEndSurveyException extends SurveyException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 6;
	private static final String MESSAGE = "마감된 설문을 읽어오는 중 에러가 발생했습니다.";

	public SurveyGetEndSurveyException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
