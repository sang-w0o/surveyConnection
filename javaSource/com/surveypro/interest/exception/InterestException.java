package com.surveypro.interest.exception;

public abstract class InterestException extends Exception {

	private static final long serialVersionUID = 1L;

	protected int errno;

	public InterestException(String e) {
		super(e);
	}

	public InterestException(int errno, String e) {
		this(e);
		this.errno = errno;
	}

	public int getErrno() {
		return errno;
	}

	public abstract void doException();
}
