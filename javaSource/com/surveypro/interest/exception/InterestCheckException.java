package com.surveypro.interest.exception;

public class InterestCheckException extends InterestException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 2;
	private static final String MESSAGE = "한번 관심 등록한 설문은 다시 관심등록 할 수 없습니다.";

	public InterestCheckException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
