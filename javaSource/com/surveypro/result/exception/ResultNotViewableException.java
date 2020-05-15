package com.surveypro.result.exception;

public class ResultNotViewableException extends ResultException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 1;
	private static final String MESSAGE = "설문 결과는 작성자 또는 결과 구매 회원만 볼 수 있습니다.";

	public ResultNotViewableException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
