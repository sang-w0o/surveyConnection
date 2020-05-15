package com.surveypro.choice.exception;

public abstract class ChoiceException extends Exception {

	private static final long serialVersionUID = 1L;

	protected int errno;

	public ChoiceException(String e) {
		super(e);
	}

	public ChoiceException(int errno, String e) {
		this(e);
		this.errno = errno;
	}

	public int getErrno() {
		return errno;
	}

	public abstract void doException();
}
