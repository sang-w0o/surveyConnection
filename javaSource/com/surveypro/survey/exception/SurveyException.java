package com.surveypro.survey.exception;

public abstract class SurveyException extends Exception {

	private static final long serialVersionUID = 1L;

	protected int errno;

	public SurveyException(String e) {
		super(e);
	}

	public SurveyException(int errno, String e) {
		this(e);
		this.errno = errno;
	}

	public int getErrno() {
		return errno;
	}

	public abstract void doException();
}
