package com.surveypro.subjectiveresult.exception;

public class SubjectiveResultInsertException extends SubjectiveResultException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 1;
	private static final String MESSAGE = "주관식 결과 삽입 중 오류가 발생했습니다.";

	public SubjectiveResultInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {

	}

}
