package com.surveypro.survey.exception;

public class SurveyPriceUpdateException extends SurveyException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 3;
	private static final String MESSAGE = "설문 포인트 갱신 중 오류가 발생했습니다.";

	public SurveyPriceUpdateException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
