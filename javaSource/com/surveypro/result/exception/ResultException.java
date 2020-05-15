package com.surveypro.result.exception;

public abstract class ResultException extends Exception {

	private static final long serialVersionUID = 1L;

	protected int errno;

	public ResultException(String e) {
		super(e);
	}

	public ResultException(int errno, String e) {
		this(e);
		this.errno = errno;
	}

	public int getErrno() {
		return errno;
	}

	public abstract void doException();
}
