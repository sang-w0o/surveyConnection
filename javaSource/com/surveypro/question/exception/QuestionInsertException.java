package com.surveypro.question.exception;

public class QuestionInsertException extends QuestionException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 101;
	public static final String MESSAGE = "문항 등록에 실패했습니다.";

	public QuestionInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}
}
