package com.surveypro.report.exception;

public class ReportRemoveException extends ReportException {

	private static final long serialVersionUID = 1L;

	private static final int ERRNO = 2;
	private static final String MESSAGE = "�Ű� �ݷ� ó���� �����߽��ϴ�..";

	public ReportRemoveException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
