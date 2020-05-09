package com.surveypro.category.exception;

public abstract class CategoryException extends Exception {

	private static final long serialVersionUID = 1L;

	protected int errno;

	public CategoryException(String e) {
		super(e);
	}

	public CategoryException(int errno, String e) {
		this(e);
		this.errno = errno;
	}

	public int getErrno() {
		return errno;
	}

	public abstract void doException();

}
