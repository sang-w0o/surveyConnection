package com.surveypro.subjectiveresult.exception;

public abstract class SubjectiveResultException extends Exception {

	private static final long serialVersionUID = 1L;

	protected int errno;

	public SubjectiveResultException(String e) {
		super(e);
	}

	public SubjectiveResultException(int errno, String e) {
		this(e);
		this.errno = errno;
	}

	public int getErrno() {
		return errno;
	}

	public abstract void doException();
}
