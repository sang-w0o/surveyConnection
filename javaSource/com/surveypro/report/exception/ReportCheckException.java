package com.surveypro.report.exception;

public class ReportCheckException extends ReportException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 4;
	private static final String MESSAGE = "�ѹ� �Ű��� ������ �ٽ� �Ű��� �� �����ϴ�.";

	public ReportCheckException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
