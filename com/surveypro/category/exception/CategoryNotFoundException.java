package com.surveypro.category.exception;

public class CategoryNotFoundException extends CategoryException {

	private static final long serialVersionUID = 1L;
	private static int ERRNO = 1;
	private static String MESSAGE = "�ش� ī�װ��� �������� �ʽ��ϴ�.";

	public CategoryNotFoundException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {

	}

}
