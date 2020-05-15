package com.surveypro.pointhistory.exception;

public abstract class PointHistoryException extends Exception {

	private static final long serialVersionUID = 1L;

	protected int errno;

	public PointHistoryException(String e) {
		super(e);
	}

	public PointHistoryException(int errno, String e) {
		this(e);
		this.errno = errno;
	}

	public int getErrno() {
		return errno;
	}

	public abstract void doException();
}
