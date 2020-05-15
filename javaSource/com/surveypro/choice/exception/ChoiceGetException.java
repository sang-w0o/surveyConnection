package com.surveypro.choice.exception;

public class ChoiceGetException extends ChoiceException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 101;
	public static final String MESSAGE = "선택지 가져오기에 실패했습니다.";

	public ChoiceGetException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}
}
