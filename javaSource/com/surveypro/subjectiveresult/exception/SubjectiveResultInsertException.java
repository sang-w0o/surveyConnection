package com.surveypro.subjectiveresult.exception;

public class SubjectiveResultInsertException extends SubjectiveResultException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 1;
	private static final String MESSAGE = "�ְ��� ��� ���� �� ������ �߻��߽��ϴ�.";

	public SubjectiveResultInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {

	}

}
