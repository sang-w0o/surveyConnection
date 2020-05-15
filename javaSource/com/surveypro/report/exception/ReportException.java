package com.surveypro.report.exception;

public abstract class ReportException extends Exception {

	private static final long serialVersionUID = 1L;

	protected int errno;

	public ReportException(String e) {
		super(e);
	}

	public ReportException(int errno, String e) {
		this(e);
		this.errno = errno;
	}

	public int getErrno() {
		return errno;
	}

	public abstract void doException();
}
