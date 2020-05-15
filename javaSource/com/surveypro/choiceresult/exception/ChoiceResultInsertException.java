package com.surveypro.choiceresult.exception;

public class ChoiceResultInsertException extends ChoiceResultException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 1;
	private static final String MESSAGE = "객관식 결과를 삽입하는 도중 오류가 발생했습니다.";

	public ChoiceResultInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
