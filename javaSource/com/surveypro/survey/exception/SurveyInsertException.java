package com.surveypro.survey.exception;

public class SurveyInsertException extends SurveyException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 5;
	public static final String MESSAGE = "설문 등록에 실패했습니다.";

	public SurveyInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
