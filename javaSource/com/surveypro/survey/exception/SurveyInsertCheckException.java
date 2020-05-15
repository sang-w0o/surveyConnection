package com.surveypro.survey.exception;

public class SurveyInsertCheckException extends SurveyException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 5;
	private static final String MESSAGE = "현재 설문을 작성할 수 없습니다.\n 타인의 설문에 참여하여 작성 회수를 늘리세요!";

	public SurveyInsertCheckException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
