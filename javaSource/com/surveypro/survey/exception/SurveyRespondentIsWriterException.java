package com.surveypro.survey.exception;

public class SurveyRespondentIsWriterException extends SurveyException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 7;
	private static final String MESSAGE = "자기 자신의 설문에는 참여할 수 없습니다.";

	public SurveyRespondentIsWriterException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
