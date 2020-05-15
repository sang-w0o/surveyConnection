package com.surveypro.result.exception;

public class ResultNotViewableException extends ResultException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 1;
	private static final String MESSAGE = "���� ����� �ۼ��� �Ǵ� ��� ���� ȸ���� �� �� �ֽ��ϴ�.";

	public ResultNotViewableException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
