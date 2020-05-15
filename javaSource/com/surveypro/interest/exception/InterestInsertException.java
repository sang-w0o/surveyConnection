package com.surveypro.interest.exception;

public class InterestInsertException extends InterestException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 1;
	private static final String MESSAGE = "관심 등록 처리 중 오류가 발생했습니다.";

	public InterestInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
