package com.surveypro.choiceresult.exception;

public abstract class ChoiceResultException extends Exception {

	private static final long serialVersionUID = 1L;

	protected int errno;

	public ChoiceResultException(String e) {
		super(e);
	}

	public ChoiceResultException(int errno, String e) {
		this(e);
		this.errno = errno;
	}

	public int getErrno() {
		return errno;
	}

	public abstract void doException();
}
