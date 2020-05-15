package com.surveypro.question.exception;

public abstract class QuestionException extends Exception {

	private static final long serialVersionUID = 1L;

	protected int errno;

	public QuestionException(String e) {
		super(e);
	}

	public QuestionException(int errno, String e) {
		this(e);
		this.errno = errno;
	}

	public int getErrno() {
		return errno;
	}

	public abstract void doException();
}
