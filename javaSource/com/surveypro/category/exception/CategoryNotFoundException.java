package com.surveypro.category.exception;

public class CategoryNotFoundException extends CategoryException {

	private static final long serialVersionUID = 1L;
	private static int ERRNO = 1;
	private static String MESSAGE = "해당 카테고리가 존재하지 않습니다.";

	public CategoryNotFoundException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {

	}

}
